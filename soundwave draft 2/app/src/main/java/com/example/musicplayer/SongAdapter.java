package com.example.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<myView>{
    public SongAdapter(ArrayList<Integer> songs) {
        this.songs = songs;
    }

    ArrayList<Integer> songs;
    Context context;

    @NonNull
    @NotNull
    @Override
    public myView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View songView = inflater.inflate(R.layout.item_song,parent,false);
        myView viewHolder = new myView(songView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myView holder, int position) {
        SongCollection songCollection = new SongCollection();
        int songId = songs.get(position);
        Song song = songCollection.getCurrentSong(songId);
        TextView artist = holder.titleArtist;
        artist.setText(song.getArtiste());
        TextView title = holder.titleTxt;
        artist.setText(song.getTitle());
        int imageId = song.getDrawable();
        holder.image.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}
