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
public class NumbersFragment extends Fragment {

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

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        final ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        word.add(new Word("two", "otiiko", R.drawable.number_two,R.raw.number_two));
        word.add(new Word("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        word.add(new Word("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        word.add(new Word("five", "massokka",R.drawable.number_five,R.raw.number_five));
        word.add(new Word("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        word.add(new Word("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        word.add(new Word("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        word.add(new Word("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        word.add(new Word("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));
        Log.d("NumbersActivity","Number in 0 position is: "+word.get(0));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
//        for(int i = 0; i<word.size(); i++) {
//            TextView num = new TextView(this);
//            rootView.addView(num);
//            num.setText(word.get(i));

        final WordAdapter Adapter = new WordAdapter(getActivity(), word,R.color.category_numbers);
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
