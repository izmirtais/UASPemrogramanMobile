package com.example.uaspemrogramanmobile.fragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.uaspemrogramanmobile.R;


public class AlamFragment extends Fragment {

    Button button,button2,button3;
    public AlamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_alam, container, false);

        button = (Button) rootView.findViewById(R.id.button);
        button2 = (Button) rootView.findViewById(R.id.button2);
        button3 = (Button) rootView.findViewById(R.id.button3);

        final MediaPlayer sound = MediaPlayer.create(getActivity(), R.raw.alam);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setLooping(true);
                sound.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound.isPlaying()) {
                    sound.pause();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.stop();
            }
        });

        return rootView;
    }

}