package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_category);
          getSupportFragmentManager().beginTransaction()
                  .replace(R.id.container, new FamilyFragment())
                  .commit();


      }
    @Override
    protected void onStop(){
        super.onStop();

    }
    /**
     * Clean up the media player by releasing its resources.
     */

}
