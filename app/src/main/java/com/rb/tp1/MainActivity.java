package com.rb.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rb.tp1.logic.FakeDao;
import com.rb.tp1.logic.IStorageTasks;
import com.rb.tp1.logic.Task;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private FakeDao Dao = new FakeDao();

    private ArrayAdapter<Task> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listView = findViewById(R.id.listView);

        this.adapter = new ArrayAdapter<Task>(this,android.R.layout.simple_list_item_1, new ArrayList<Task>());
        this.listView.setAdapter(adapter);

        for (Task task:this.Dao.ReadTasks().getTasks()){
            adapter.add(task);
        }
    }
}