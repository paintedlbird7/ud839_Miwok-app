package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private int imageResourceId;
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an array of words
        // words.add("one");
        final ArrayList<Word> words = new ArrayList<Word>();

         words.add(new Word("What is your name?", "innә oyaase'nә", imageResourceId, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is..", "michәksәs?", imageResourceId, R.raw.phrase_my_name_is));
        words.add(new Word("I’m feeling good.", "kuchi achit", imageResourceId, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", imageResourceId, R.raw.phrase_are_you_coming));
        words.add(new Word("Let’s go", "yoowutis", imageResourceId, R.raw.phrase_lets_go));


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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start(); // no need  to call prepare(); create() does that for you
            }

        });

    }



}
