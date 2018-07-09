package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an array of words
        // words.add("one");
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_mother));
        words.add(new Word("mother", "әṭa", R.drawable.family_father));
        words.add(new Word("son", "angsi", R.drawable.family_daughter));
        words.add(new Word("daughter", "tune", R.drawable.family_son));
        words.add(new Word("grandmother", "ama", R.drawable.family_older_sister));


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

    }

}
