package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    static ArrayList<Integer> Queue = new ArrayList<Integer>();
    SongCollection songCollection = new SongCollection();
    public void sendDataToActivity(int index){
        Intent intent = new Intent( this, PlaySongActivity.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }
    public void handleSelection(View myview){
        SongCollection songs = new SongCollection();
        String resourceId = getResources().getResourceEntryName(myview.getId());
        int currentArrayIndex = songs.SearchSongById(resourceId);
        Log.d("Temasek", "The index in tha array for the song is :" +currentArrayIndex);
        sendDataToActivity(currentArrayIndex);
    }

    public void addToFavorites(View view) {
        String songID= view.getContentDescription().toString();
        int song = songCollection.SearchSongById(songID);
        Intent intent = new Intent(this, QueueActivity.class);
        Queue.add(song);
        startActivity(intent);
    }

    public void goToFavoriteActivity(View view) {
        Intent intent = new Intent(this, PlaylistActivity.class);
        startActivity(intent);
    }
}

