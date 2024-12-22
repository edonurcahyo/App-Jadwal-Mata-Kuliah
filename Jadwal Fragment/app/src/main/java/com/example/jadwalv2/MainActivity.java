package com.example.jadwalv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button logoutButton, classroomButton;
    private SharedPreferences sharedPreferences;

    private static final String PREF_NAME = "LoginPrefs";
    private static final String IS_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi Tombol
        logoutButton = findViewById(R.id.explicitIntentButton);
        classroomButton = findViewById(R.id.implicitIntentButton);

        // SharedPreferences untuk cek status login
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Listener untuk Tombol Logout
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hapus data login dari SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                // Notifikasi logout berhasil
                Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();

                // Arahkan kembali ke LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        // Listener untuk Tombol "Go to Classroom"
        classroomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buka URL Classroom
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(android.net.Uri.parse("https://classroom.itats.ac.id/"));
                startActivity(intent);
            }
        });
    }
}
