package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlaySongActivity extends AppCompatActivity {
    private String title = " ";
    private String artiste = " ";
    private String fileLink = " ";
    private int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;
    private SongCollection songCollection = new SongCollection();
    SeekBar seekbar;
    Handler handler = new Handler();
    SongCollection originalSongCollection = new SongCollection();

    List<Song> shuffleList = Arrays.asList(songCollection.songs);

    Button repeatBtn;
    Boolean repeatFlag= false;

    Button shuffleBtn;
    Boolean shuffleFlag= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        seekbar = findViewById(R.id.seekBar);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        Log.d("temasek", "retrieved position is: " +currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
        seekbar.setMax(player.getDuration());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(player != null && player.isPlaying()) {
                    player.seekTo(seekbar.getProgress());

                }
            }
        });
        repeatBtn = findViewById(R.id.repeatbtn);
        shuffleBtn = findViewById(R.id.shufflebtn);
    }
    Runnable p_bar = new Runnable(){
        @Override
        public void run(){
            if(player != null && player.isPlaying()) {
                handler.postDelayed(this,1000);
                seekbar.setProgress(player.getCurrentPosition());
            }
        }
    };

    public void displaySongBasedOnIndex(int selectedIndex){
    Song song = songCollection.getCurrentSong(currentIndex);
    title = song.getTitle();
    artiste = song.getArtiste();
    fileLink = song.getFileLink();
    drawable = song.getDrawable();
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);
        TextView txtArtiste = findViewById(R.id.txtArtist);
        txtArtiste.setText(artiste);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);
    }
    public void playSong(String songUrl) {
        try {
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            p_bar.run();
            gracefullyStopsWhenMusicEnds();


            setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void playOrPauseMusic(View view) {
            if(player.isPlaying()) {
                player.pause();
                btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24);
            }else{
                player.start();
                seekbar.setMax(player.getDuration());
                handler.removeCallbacks(p_bar);
                handler.postDelayed(p_bar,1000);
                btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_pause_circle_outline_24);
            }
        }
        private void gracefullyStopsWhenMusicEnds(){
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                   Toast.makeText(getBaseContext(), "The song had ended and the onCompleteListener is activated\n " +
                           "The button text is changed to' PLAY' ", Toast.LENGTH_LONG).show();
                   if(repeatFlag){
                       playOrPauseMusic(null);
                   }else{

                   }
                   btnPlayPause.setBackgroundResource(R.drawable.ic_baseline_play_circle_outline_24);
                }
            });
        }
        public void playNext(View view){
        currentIndex = songCollection.getNextSong(currentIndex);
            Toast.makeText(this, "after clicking playNext, \nthe current index of the song\n"+
                    "in the SongCollection array is now" +currentIndex, Toast.LENGTH_LONG).show();
            Log.d("temasek","After playNext the index is now : " + currentIndex);
            displaySongBasedOnIndex(currentIndex);
            playSong(fileLink);
        }
        public void playPrevious(View view){
        currentIndex = songCollection.getPrevSong(currentIndex);
            Toast.makeText(this, "after clicking playPrevious, \nthe current index of the song\n"+
                    " array is now" + currentIndex, Toast.LENGTH_LONG).show();
            Log.d("temasek","After playPrevious the index is now : " + currentIndex);
            displaySongBasedOnIndex(currentIndex);
            playSong(fileLink);

        }
        @Override
    public void onBackPressed(){
            super.onBackPressed();
            player.release();
            handler.removeCallbacks(p_bar);
        }

        //repeat function
        public void repeatBtn(View view){
        if(repeatFlag){
            repeatBtn.setBackgroundResource(R.drawable.repeat_off);
        }else{
            repeatBtn.setBackgroundResource(R.drawable.repeat_on);
        }
        repeatFlag = !repeatFlag;
        }

        //shuffle function
        public void shuffleSong(View view){
        if(shuffleFlag){
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_off);
            songCollection = new SongCollection();
        }else{
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_on);
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);
        }
        shuffleFlag = !shuffleFlag;
        }




    }
