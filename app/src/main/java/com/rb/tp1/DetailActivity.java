package com.rb.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.rb.tp1.logic.Exception;
import com.rb.tp1.logic.Task;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        EditText titreEditText = findViewById(R.id.titre_edittext);
        EditText descriptionEditText = findViewById(R.id.description_edittext);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button BckButton = findViewById(R.id.backButton);

        Task selectedTask = (Task) getIntent().getSerializableExtra("selectedTask");
        if (selectedTask != null) {

            titreEditText.setText(selectedTask.getTitle());
            descriptionEditText.setText(selectedTask.getDescription());
            ratingBar.setRating(selectedTask.getPriority());
        }

        BckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créez un Intent pour l'activité que vous souhaitez lancer
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);

                // Lancez l'activité en utilisant l'Intent
                startActivity(intent);
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
