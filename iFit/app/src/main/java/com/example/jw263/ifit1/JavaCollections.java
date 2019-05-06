package com.example.jw263.ifit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jw263.ifit1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class JavaCollections extends AppCompatActivity {

    //Declare the textview
    private TextView mTextView;

    //Declare each of the datatypes
    private ArrayList mArrayList;
    private HashSet mHashSet;
    private HashMap mHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_collections);

        //get textview in GUI
        mTextView = (TextView)findViewById(R.id.TextView);
    }

    public void arrayListButtonClick(View v){
        //Create new ArrayListAct
        mArrayList = new ArrayList();

        //Create one long string to record everything with the arraylist
        String tmpString = "Initial Size of Arraylist: " + mArrayList.size() + "\n";

        //Add elements to array list
        mArrayList.add("Sam");
        mArrayList.add("Zach");
        mArrayList.add("Alex");

        //display array list
        tmpString += "Contents of ArrayListAct after first set: \n\t" + mArrayList + "\n";

        //rm two elements from arraylist with index and content
        mArrayList.remove(0);
        mArrayList.remove("Alex");

        //display array list
        tmpString += "Size of ArrayListAct after deletions: " + mArrayList.size() + "\n";
        tmpString += "Contents of ArrayListAct after deletions: \n\t" +mArrayList + "\n";

        //put entire string in the textview
        mTextView.setText(tmpString);
    }

    public void onHashSetClick(View view){
        String tmpString;

        //Create empty hashset
        mHashSet = new HashSet();
        tmpString = "Empty HashSet size: " + mHashSet.size() + "\n";

        //Add items: Types of exercises
        mHashSet.add("Cardio");
        mHashSet.add("Muscular");
        mHashSet.add("Flexibility");
        mHashSet.add("Body Comp");

        tmpString += "HashSet size after add: " + mHashSet.size() + "\n";
        tmpString += "HashSet is: " + mHashSet + "\n";

        //Check to see if item is in hashset
        //This one is
        tmpString += "HashSet contains Cardio: " + mHashSet.contains("Cardio") + "\n";

        //This one doesn't
        tmpString += "HashSet contains cycling: " + mHashSet.contains("cycling") + "\n";

        //Remove an item
        mHashSet.remove("Body Comp");
        tmpString += "HashSet after remove Body Comp: \n\t" + mHashSet + "\n";

        //Set string to the view
        mTextView.setText(tmpString);


    }

    public void onHashMapClick(View view){
        String tmpString;

        //Create empty hashmap
        mHashMap = new HashMap();
        tmpString = "Empty HashMap size: " + mHashMap.size() + "\n";

        //Put some key pairs in
        mHashMap.put(1, "Sam");
        mHashMap.put(2, "Zach");
        mHashMap.put(3, "Alex");

        tmpString += "HashMap size after add: " +mHashMap.size() + "\n";
        tmpString += "HashMap is: " + mHashMap + "\n";

        //Check to see if key is in the map
        //This one is
        tmpString += "HashMap contains 2: " + mHashMap.containsKey(2) + "\n";

        //This one doesn't
        tmpString += "HashMap contains 7: " +mHashMap.containsKey(7) + "\n";

        //Get all of the keys
        tmpString += "Keys are: " + mHashMap.keySet() + "\n";

        //Remove an item
        mHashMap.remove(3);
        tmpString += "HashMap size after remove: " + mHashMap.size() + "\n";
        tmpString += "HashMap is: " + mHashMap + "\n";

        mTextView.setText(tmpString);

    }

    public void onButtonClickArrayListAct(View v){
        //Create new intent
        Intent myIntent = new Intent(this, ArrayListAct.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClickHashSet(View v){
        //Create new intent
        Intent myIntent = new Intent(this, com.example.jw263.ifit1.HashSet.class);

        //start new activity
        startActivity(myIntent);

    }

    public void onButtonClickHashMap(View v){
        //Create new intent
        Intent myIntent = new Intent(this, com.example.jw263.ifit1.HashMap.class);

        //start new activity
        startActivity(myIntent);

    }
}
