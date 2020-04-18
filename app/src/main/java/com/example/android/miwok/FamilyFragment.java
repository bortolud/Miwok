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
public class FamilyFragment extends Fragment {
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

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        word.add(new Word("mother", "әṭa",R.drawable.family_mother,R.raw.family_mother));
        word.add(new Word("son", "angsi",R.drawable.family_son,R.raw.family_son));
        word.add(new Word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        word.add(new Word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        word.add(new Word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        word.add(new Word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        word.add(new Word("younger sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        word.add(new Word("grandmother", "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        word.add(new Word("grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
        Log.d("NumbersActivity","Number in 0 position is: "+word.get(0));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
//        for(int i = 0; i<word.size(); i++) {
//            TextView num = new TextView(this);
//            rootView.addView(num);
//            num.setText(word.get(i));

        final WordAdapter Adapter = new WordAdapter(getActivity(), word,R.color.category_family);
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
