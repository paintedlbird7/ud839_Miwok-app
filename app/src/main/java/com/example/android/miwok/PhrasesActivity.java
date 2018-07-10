package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }

    };

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
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start(); // no need  to call prepare(); create() does that for you
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }

        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    /**
     * Clean up the media player by releasing its resources.
     */

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}

