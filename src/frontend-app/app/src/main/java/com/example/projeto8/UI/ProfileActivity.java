package com.example.projeto8.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto8.R;
import com.example.projeto8.api.patient.PatientService;
import com.example.projeto8.model.Patient;
import com.example.projeto8.remote.RetrofitClient;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
/*
    private ImageView iconHome, iconExercise, iconProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_activity);

        TextView edName = findViewById(R.id.edName);
        TextView edEmail = findViewById(R.id.edEmail);

        // MENU
        iconHome = findViewById(R.id.iconHome);
        iconExercise = findViewById(R.id.iconExercise);
        iconProfile = findViewById(R.id.iconProfile);
        setupMenuClicks();

        //Para pegar os dados a partir do que veio no Login
        SharedPreferences prefs = getSharedPreferences("STORAGE", MODE_PRIVATE);
        String name = prefs.getString("patient_name", "Sem nome");
        String email = prefs.getString("patient_email", "Sem email");

        if (name != null && surname != null) {
            loadPatient(name, surname);
        }

        edName.setText(name);
        edEmail.setText(email);
    }

    private void loadPatient(String name, String surname) {
        PatientService service = RetrofitClient.getPatientService();

        service.getPatientByFullName(name, surname)
                .enqueue(new Callback<List<Patient>>() {

                    @Override
                    public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                        if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {

                            Patient p = response.body().get(0); // pega o primeiro

                            txtName.setText(p.getName() + " " + p.getSurname());
                            txtStatus.setText("Status: " + p.getStatus());

                            txtEmail.setText(p.getEmail());
                            txtCpf.setText(p.getCpf());
                            txtBirthDate.setText(p.getBirthDate());

                            txtGender.setText(p.getGender());
                            txtHeight.setText(p.getHeight());
                            txtWeight.setText(p.getWeight());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Patient>> call, Throwable t) {
                        Log.e("API_ERROR", t.getMessage());
                    }
                });
    }

    private void setupMenuClicks() {
        iconHome.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        iconExercise.setOnClickListener(v -> {
            startActivity(new Intent(this, ExercisesActivity.class));
            finish();
        });

        iconProfile.setOnClickListener(v -> {
            // já está na pag
        });
    }*/
}