package com.sanding.testsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sanding.testsqlite.bean.Person;
import com.sanding.testsqlite.constant.Constant;
import com.sanding.testsqlite.utils.DBManger;
import com.sanding.testsqlite.utils.MySQlitHelper;

import java.sql.SQLInput;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private MySQlitHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper= DBManger.getInstance(getApplicationContext());
    }
    //创建数据库，增加数据库的数据
    public void insert(View view){

        SQLiteDatabase db = helper.getWritableDatabase();
for (int i=1;i<30;i++){
    String sql="insert into "+ Constant.TABLE_NAME+" values("+i+",'张三"+i+"' ,20)";
    db.execSQL(sql);
}
        db.close();
    }
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.dbquery:
                SQLiteDatabase db=helper.getWritableDatabase();
                String selectSql="select * from "+Constant.TABLE_NAME;
                Cursor cursor=DBManger.selectDataBySql(db,selectSql,null);
               List<Person> lists= DBManger.cursorToList(cursor);
                for (Person person:lists){
                    Log.e("tostring",person.toString());
                }
                db.close();
                break;
            case R.id.btn_queryApi:
            db=helper.getWritableDatabase();
                /**
                 * query(String table, String[] columns, String selection,
                 String[] selectionArgs, String groupBy, String having,
                 String orderBy) {
                 String table:查询的表的名称
                 String[] columns：查询的列的名称,为null的时候，全部查询
                 String selection：查询条件，where字句
                 String[] selectionArgs表示查询条件占位符的取值
                 String groupBy 分组条件
                 String having 表示筛选条件
                 String orderBy 表示排序条件  order by字句
                 、
                 */
                cursor=db.query(Constant.TABLE_NAME,null,Constant.ID+">?",new String[]{"10"},null,null,Constant.ID+" desc");
                lists=DBManger.cursorToList(cursor);
                for (Person person:lists){
                    Log.e("tag",person.toString());
                }
                db.close();
                break;
            case R.id.jumpToCursorAdapter:
                Intent intent=new Intent(MainActivity.this,CusorAdapterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
