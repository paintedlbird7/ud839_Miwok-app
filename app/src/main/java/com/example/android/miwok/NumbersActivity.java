package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.layout;

public class NumbersActivity extends AppCompatActivity {


    private Object android;
    private ListAdapter adapter;
    private ListAdapter itemsAdapter;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.word_list);

        // Create an array of words
        // words.add("one");
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));


        // Create a new {@link TextView}
        // adapter knows how to create
        //WordAdapter itemsAdapter = new WordAdapter(this,words);
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        //ArrayAdapter itemsAdapter = new ArrayAdapter();
        //WordAdapter itemsAdapter = new WordAdapter();

        // Find the {@link ListView} object in the
        // There should be a {@link ListView}
        // word_listyout
        ListView listView = (ListView) findViewById(R.id.list);


        // Make the {@link ListView} use the
        // {@link ListView} will display

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, R.raw.number_one);
                mMediaPlayer.start(); // no need  to call prepare(); create() does that for you
            }

        });
    }
}




        // For Loop: Find the root view of the whole layout
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//        for(int index = 0; index < words.size(); index++)
//        {
//            // Create a new TextView
//            TextView wordView = new TextView(this);
//
//            // Set the text to be word at the current index
//            wordView.setText(words.get(index));
//
//            // Add this TextView as another child to the root view of this layout
//            rootView.addView(wordView);
//        }
//    }
//}




// While Loop:  Create a variable to keep track of the current index position
//        int index = 0;
//        while(index<words.size()){
//            // Create a new {@link TextView} that displayed the word at
//            // and add the View as a child to the rootView
//
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(0));
//            rootView.addView(wordView);
//
//            //Update counter variable
//            index++; //index = index + 1
//        }


//        TextView wordView2 = new TextView(this);
//        wordView2.setText(words.get(1));
//        rootView.addView(wordView2);
//
//        TextView wordView3 = new TextView(this);
//        wordView3.setText(words.get(2));
//        rootView.addView(wordView3);

