package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an array of words
        // words.add("one");
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("mother", "әṭa", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("son", "angsi", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("daughter", "tune", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("grandmother", "ama", R.drawable.family_older_sister, R.raw.family_older_sister));


        // Create a new {@link TextView}
        // adapter knows how to create
        //WordAdapter itemsAdapter = new WordAdapter(this,words);
        WordAdapter itemsAdapter = new WordAdapter(this,words, R.color.category_numbers);

        //ArrayAdapter itemsAdapter = new ArrayAdapter();
        //WordAdapter itemsAdapter = new WordAdapter();

        // Find the {@link ListView} object in the
        // There should be a {@link ListView}
        // word_list.xml
        ListView listView = (ListView) findViewById(R.id.list);


        // Make the {@link ListView} use the
        // {@link ListView} will display

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start(); // no need  to call prepare(); create() does that for you
            }

        });

    }

}
