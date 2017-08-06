package com.sanding.testsqlite.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sanding.testsqlite.bean.Person;
import com.sanding.testsqlite.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */

public class DBManger {
    private  static  MySQlitHelper instance;
    public  static MySQlitHelper getInstance(Context context){
        if (instance==null){
            instance=new MySQlitHelper(context);
        }
        return instance;
    }
public  static Cursor selectDataBySql(SQLiteDatabase db, String sql, String[] selectionArgs){
    Cursor cursor=null;
        if (db!=null){
           cursor= db.rawQuery(sql,selectionArgs);
        }
    return  cursor;
    }
    //查询返回集合数据,将cursor转换成list集合
    public  static List<Person> cursorToList(Cursor cursor){
        List<Person> persons=new ArrayList<>();
        if (cursor!=null){
            while (cursor.moveToNext()){
                //根据参数中指定的字段名称获取字段下标
                int index=cursor.getColumnIndex(Constant.ID);
                //根据下标获取字段的值
                int id =cursor.getInt(index);
                //同样的道理，获取响应的值
                String name=cursor.getString(cursor.getColumnIndex(Constant.NAME));
                String age=cursor.getString(cursor.getColumnIndex(Constant.AGE));
               Person person=new Person(name,age,id);
            persons.add(person);
            }
        }
return persons;
    }
}
