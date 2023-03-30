package com.rb.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.rb.tp1.logic.Exception;
import com.rb.tp1.logic.FakeDao;
import com.rb.tp1.logic.IStorageTasks;
import com.rb.tp1.logic.Task;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private FakeDao Dao = new FakeDao();

    private ArrayAdapter<Task> adapter;

    public MainActivity() throws Exception {
    }

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

        ListView listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task selectedTask = (Task) parent.getItemAtPosition(position);
                // Créez un Intent pour l'activité que vous souhaitez lancer
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("selectedTask", selectedTask);
                // Lancez l'activité en utilisant l'Intent
                startActivity(intent);

            }
        });

        Button myButton = findViewById(R.id.button_detail);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créez un Intent pour l'activité que vous souhaitez lancer
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                // Lancez l'activité en utilisant l'Intent
                startActivity(intent);
            }
        });
    }
}