package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        songImgBtn = findViewById(R.id.SongImage1);
        playlistImgBtn = findViewById(R.id.PlaylistBtn1);
        favImgBtn = findViewById(R.id.FavBtn1);
        artistImgBtn = findViewById(R.id.ArtistBtn1);
        //songDisplay();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }
    //Buttons on page
    static ImageButton songBtn;
    static ImageButton songImgBtn;
    static ImageButton playlistBtn;
    static ImageButton playlistImgBtn;
    static ImageButton favBtn;
    static ImageButton favImgBtn;
    static ImageButton artistBtn;
    static ImageButton artistImgBtn;


    SongCollection songCollection = new SongCollection();
    private int drawable;

// send songs image button to main activity
    public void playSong(View view) {
        Intent songPage = new Intent(this, MainActivity.class);
        startActivity(songPage);

    }
    //second fragment code to send play song
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



   /* public void songDisplay(){
        Song song = songCollection.getCurrentSong(0);
        drawable = song.getDrawable();
        songImgBtn.setImageResource(drawable);

        song = songCollection.getCurrentSong(1);
        drawable = song.getDrawable();
        playlistImgBtn.setImageResource(drawable);
        song = songCollection.getCurrentSong(0);
        drawable = song.getDrawable();
        favImgBtn.setImageResource(drawable);
    }*/
    public void playlistImg(View view) {
        Intent intent = new Intent(this, PlaylistActivity.class);
        startActivity(intent);
    }

    public void favouritesImg(View view) {
    }

    public void artistImg(View view) {
    }


}