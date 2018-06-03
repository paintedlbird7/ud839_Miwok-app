package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.layout;

public class NumbersActivity extends AppCompatActivity {


    private Object android;
    private ListAdapter adapter;
    private ListAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_numbers);

        // Create an array of words
        // words.add("one");
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));


        // Create a new {@link TextView}
        // adapter knows how to create
        //WordAdapter itemsAdapter = new WordAdapter(this,words);
        ArrayAdapter adapter = new WordAdapter(this,words);

        //ArrayAdapter itemsAdapter = new ArrayAdapter();
        //WordAdapter itemsAdapter = new WordAdapter();

        // Find the {@link ListView} object in the
        // There should be a {@link ListView}
        // activity_numbers.xml layout
        ListView listView = (ListView) findViewById(R.id.list);


        // Make the {@link ListView} use the
        // {@link ListView} will display

        listView.setAdapter(itemsAdapter);

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

