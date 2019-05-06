package com.example.jw263.ifit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jw263.ifit1.R;

public class usersettings extends AppCompatActivity {

    //declare gui
    private EditText mUserIDView;
    private EditText mNameView;
    private EditText mAgeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersettings);

        //Assign GUI
        mUserIDView = (EditText)findViewById(R.id.UserIDInput);
        mNameView = (EditText)findViewById(R.id.NameInput);
        mAgeView = (EditText)findViewById(R.id.AgeInput);
    }

    //when pressed add user with name and age
    public void addClick(View v){
        //get name and age to add to table
        String name = mNameView.getText().toString();
        Integer age = Integer.parseInt(mAgeView.getText().toString());

        //make new student object
        User user = new User(name, age);

        //Create db handler
        UserDBHandler handler = new UserDBHandler(this);

        //add user to db using handler
        handler.addUser(user);

        //clear input fields
        mNameView.setText("");
        mAgeView.setText("");

        //Tell user it worked
        Toast.makeText(this, name + "was added to db", Toast.LENGTH_LONG).show();

    }

    //when pressed find user with name
    public void findClick(View v){
        //get name of user
        String name = mNameView.getText().toString();

        //Create DB handler
        UserDBHandler handler = new UserDBHandler(this);

        //See if record exists with username indicted
        User user = handler.findUser(name);

        //if record exists, update gui
        if(user != null){
            mAgeView.setText(Integer.valueOf(user.getmAge()).toString());
            mUserIDView.setText(Integer.valueOf(user.getmID()).toString());
        }

        //else indicate error
        else
            mUserIDView.setText("User not found");

    }

    //when pressed delete user from db
    public void deleteClick(View v){
        //get name of student we want to del
        String name = mNameView.getText().toString();

        //Create db handler
        UserDBHandler handler = new UserDBHandler(this);

        //del student if exist
        boolean result = handler.deleteUser(name);

        //if successful, update gui
        if(result){
            mAgeView.setText("");
            mNameView.setText("");
            mUserIDView.setText("Record deleted");
        }
        else
            mUserIDView.setText("No match");

    }

    public void onButtonClickJavaCollections(View v){
        //Create new intent
        Intent myIntent = new Intent(this, JavaCollections.class);

        //start new activity
        startActivity(myIntent);

    }
}
