package com.example.clarinetmaster.testcardview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.clarinetmaster.testcardview.Adapters.recyclerViewAdapter;
import com.example.clarinetmaster.testcardview.Database.databaseHelper;
import com.example.clarinetmaster.testcardview.Model.Card;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Card> c = new ArrayList<>();

    private databaseHelper mHelper;
    private SQLiteDatabase db;

    private RecyclerView rv;
    private recyclerViewAdapter adapter;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        fetchData();

        adapter = new recyclerViewAdapter(this, c);
        rv.setAdapter(adapter);

    }

    public void fetchData(){
        mHelper = new databaseHelper(this);
        db = mHelper.getWritableDatabase();
        Cursor cursor = db.query(mHelper.TABLE_NAME, null, null, null, null, null, mHelper.COL_SCORE);
        while(cursor.moveToNext()){
            Card card = new Card(
                    cursor.getString(cursor.getColumnIndex(mHelper.COL_NAME)),
                    cursor.getInt(cursor.getColumnIndex(mHelper.COL_IMAGE)),
                    cursor.getInt(cursor.getColumnIndex(mHelper.COL_SCORE))
            );
            c.add(card);
        }
    }

}
