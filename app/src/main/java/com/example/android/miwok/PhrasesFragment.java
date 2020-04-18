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
public class PhrasesFragment extends Fragment {
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

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        word.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        word.add(new Word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        word.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        word.add(new Word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        word.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        word.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        word.add(new Word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        word.add(new Word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        word.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));
        Log.d("NumbersActivity","Number in 0 position is: "+word.get(0));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
//        for(int i = 0; i<word.size(); i++) {
//            TextView num = new TextView(this);
//            rootView.addView(num);
//            num.setText(word.get(i));

        final WordAdapter Adapter = new WordAdapter(getActivity(), word,R.color.category_phrases);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
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
