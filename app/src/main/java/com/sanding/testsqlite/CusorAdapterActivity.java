package com.sanding.testsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

//这是将查询的数据放到listview中
public class CusorAdapterActivity extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusor_adapter);
        listView= (ListView) findViewById(R.id.listSqilte);
    }
}
