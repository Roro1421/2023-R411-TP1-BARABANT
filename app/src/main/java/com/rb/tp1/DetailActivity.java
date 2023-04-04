package com.rb.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.rb.tp1.logic.Exception;
import com.rb.tp1.logic.Save;
import com.rb.tp1.logic.Task;

public class DetailActivity extends AppCompatActivity {

    private Save save;

    private Task selectedTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        try {
            this.save = new Save(this.getPreferences(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        EditText titreEditText = findViewById(R.id.titre_edittext);
        EditText descriptionEditText = findViewById(R.id.description_edittext);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button BckButton = findViewById(R.id.backButton);

        selectedTask = (Task) getIntent().getSerializableExtra("selectedTask");
        if (selectedTask != null) {

            titreEditText.setText(selectedTask.getTitle());
            descriptionEditText.setText(selectedTask.getDescription());
            ratingBar.setRating(selectedTask.getPriority());
        }

        BckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (titreEditText.getText().length() != 0){
                    try {
                        selectedTask = new Task(titreEditText.getText().toString(),descriptionEditText.getText().toString(),(int)ratingBar.getRating(),false);
                        save.AddTask(selectedTask);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    save.UpdateTask(selectedTask);
                }
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", selectedTask);
                setResult(Activity.RESULT_OK, returnIntent);;
                finish();
            }
        });
        
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                try {
                    if (selectedTask != null)
                    selectedTask.setPriority((int) rating);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
