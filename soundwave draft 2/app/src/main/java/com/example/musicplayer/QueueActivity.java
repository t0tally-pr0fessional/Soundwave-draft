package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class QueueActivity extends AppCompatActivity {
RecyclerView queueList;
SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        queueList= findViewById(R.id.RecyclerView);
        songAdapter= new SongAdapter(MainActivity.Queue);
        queueList.setAdapter(songAdapter);
        queueList.setLayoutManager(new LinearLayoutManager(this));
        }
    }
