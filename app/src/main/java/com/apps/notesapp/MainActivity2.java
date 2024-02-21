package com.apps.notesapp;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    CardView card1, card2, card3, card4;

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        btn1 = findViewById(R.id.d1);
        btn2 = findViewById(R.id.d2);
        btn3 = findViewById(R.id.d3);
        btn4 = findViewById(R.id.d4);

        String tech = getIntent().getExtras().getString("tech");

        getSupportActionBar().setTitle(tech.substring(0, 1).toUpperCase() + tech.substring(1));

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("tech", tech);
                intent.putExtra("res", "notes");
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("tech", tech);
                intent.putExtra("res", "books");
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("tech", tech);
                intent.putExtra("res", "questions");
                startActivity(intent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("tech", tech);
                intent.putExtra("res", "documentation");
                startActivity(intent);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Downloading Started...", Toast.LENGTH_SHORT).show();
                downloadFile(MainActivity2.this, "html", ".pdf", DIRECTORY_DOWNLOADS,"https://drive.usercontent.google.com/u/0/uc?id=1JJ9QKNq250PtUV7EMEIz1PBRBc7a5tV_&export=download");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Downloading Started...", Toast.LENGTH_SHORT).show();
                downloadFile(MainActivity2.this, "html", ".pdf", DIRECTORY_DOWNLOADS,"https://drive.usercontent.google.com/u/0/uc?id=1JJ9QKNq250PtUV7EMEIz1PBRBc7a5tV_&export=download");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Downloading Started...", Toast.LENGTH_SHORT).show();
                downloadFile(MainActivity2.this, "html", ".pdf", DIRECTORY_DOWNLOADS,"https://drive.usercontent.google.com/u/0/uc?id=1JJ9QKNq250PtUV7EMEIz1PBRBc7a5tV_&export=download");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Downloading Started...", Toast.LENGTH_SHORT).show();
                downloadFile(MainActivity2.this, "html", ".pdf", DIRECTORY_DOWNLOADS,"https://drive.usercontent.google.com/u/0/uc?id=1JJ9QKNq250PtUV7EMEIz1PBRBc7a5tV_&export=download");
            }
        });
    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }
}