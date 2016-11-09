package com.example.clarinetmaster.testcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.clarinetmaster.testcardview.Adapters.recyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private final String[] dataset = {"Android", "iOS", "Windows", "Linux", "MacOS"};

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

        adapter = new recyclerViewAdapter(this, dataset);
        rv.setAdapter(adapter);

    }

}
