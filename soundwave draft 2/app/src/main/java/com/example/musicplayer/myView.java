package com.example.musicplayer;

import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myView extends RecyclerView.ViewHolder {
    public TextView titleTxt;
    public TextView titleArtist;
    public ImageView image;
    public Button removeBtn;

    public myView(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);

        titleTxt = itemView.findViewById(R.id.textView7);
        titleArtist= itemView.findViewById(R.id.textView8);
        image = itemView.findViewById(R.id.imageView5);
        removeBtn = itemView.findViewById(R.id.remove_btn);


    }}

