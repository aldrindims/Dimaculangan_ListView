package com.example.aldrin.dimaculangan_listview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aldrin.dimaculangan_listview.Adapter.CustomAdapter;
import com.example.aldrin.dimaculangan_listview.Model.College;
import com.example.aldrin.dimaculangan_listview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] colleges;
    String[] year;
    ListView lv_colleges;
    CustomAdapter adapter;
    List<College> listVersions;
    int[] logos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_colleges = (ListView) findViewById(R.id.lvColleges);
        listVersions = new ArrayList<College>();
        colleges = getResources().getStringArray(R.array.Colleges);
        year = getResources().getStringArray(R.array.Year);
        logos = new int[] {R.drawable.archilogo, R.drawable.educlogo, R.drawable.englogo, R.drawable.iicslogo, R.drawable.medlogo};
        for (int i=0; i <colleges.length; i++) {
            listVersions.add(new College(logos[i], colleges[i], year[i]));
        }

        adapter = new CustomAdapter(this, listVersions);
        lv_colleges.setAdapter(adapter);
        lv_colleges.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "You clicked " + colleges[position];
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
