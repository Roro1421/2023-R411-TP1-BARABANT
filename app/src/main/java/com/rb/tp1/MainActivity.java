package com.rb.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
import com.rb.tp1.logic.Save;
import com.rb.tp1.logic.Task;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private FakeDao Dao = new FakeDao();

    private ArrayAdapter<Task> adapter;

    private Save save;

    public MainActivity() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listView = findViewById(R.id.listView);

        this.adapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, new ArrayList<Task>());
        this.listView.setAdapter(adapter);

        try {
            this.save = new Save(this.getPreferences(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (Task task : this.save.ReadTasks().getTasks()) {
                adapter.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Task task : this.Dao.ReadTasks().getTasks()) {
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
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            // Récupérer l'objet Task renvoyé par viewDetail
            Task task = (Task) data.getSerializableExtra("result");
            if (task != null){
                adapter.add(task);
            }
        }
    }
}