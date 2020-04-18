package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {
    MediaPlayer mediaPlayer;
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        word.add(new Word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        word.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        word.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        word.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        word.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));
        word.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        word.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        Log.d("NumbersActivity","Number in 0 position is: "+word.get(0));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
//        for(int i = 0; i<word.size(); i++) {
//            TextView num = new TextView(this);
//            rootView.addView(num);
//            num.setText(word.get(i));

        final WordAdapter Adapter = new WordAdapter(getActivity(), word,R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word tempWord = (Word) Adapter.getItem(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), tempWord.getSound());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mp){
                        releaseMediaPlayer();
                    }
                });
            }
        });

        return rootView;
    }
}
