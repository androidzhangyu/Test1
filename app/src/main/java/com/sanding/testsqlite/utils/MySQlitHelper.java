package com.sanding.testsqlite.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sanding.testsqlite.constant.Constant;

/**
 * Created by Administrator on 2017/8/5.
 */

public class MySQlitHelper extends SQLiteOpenHelper {
    public MySQlitHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
public MySQlitHelper(Context context){
    super(context, Constant.DATABASE_NAME,null,Constant.DATABASE_VERSION);
}
//当数据库创建的时候
    @Override
    public void onCreate(SQLiteDatabase db) {
String sql="create table "+Constant.TABLE_NAME+"("+Constant.ID+" Integer primary key , "+Constant.NAME+" varchar(10), "+Constant.AGE+" Integer )";
   db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
