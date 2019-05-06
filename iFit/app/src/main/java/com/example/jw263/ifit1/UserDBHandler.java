package com.example.jw263.ifit1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class UserDBHandler extends SQLiteOpenHelper {
    //Declare DB constants

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";

    //Declare TABLE constants

    private static final String TABLE_USERS = "Users";
    private static final String COLUMN_USERID = "user_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";


    //TABLE for Progress Bar
    private static final String TABLE_PROGRESS = "Progress";
    private static final String COLUMN_PROGRESS_ID = "progress_id";
    private static final String COLUMN_PART = "body_part";
    private static final String COLUMN_AAC = "aac";
    private static final String COLUMN_TRICEPS = "triceps";
    private static final String COLUMN_QUADRICEPS = "quadriceps";
    private static final String COLUMN_RUNNING = "running";
    private static final String COLUMN_CYCLING = "cycling";
    private static final String COLUMN_SWIMMING = "swimming";
    private static final String COLUMN_PULLDOWN = "pulldown";
    private static final String COLUMN_PUSHDOWN = "pushdown";
    private static final String COLUMN_SHOULDERPRESS = "shoulderpress";
    private static final String COLUMN_PUSHUPS = "pushups";
    private static final String COLUMN_SQUAT = "squat";
    private static final String COLUMN_LUNGE = "lunge";

    public UserDBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //override OnCreate
    @Override
    public void onCreate(SQLiteDatabase db){
        //construct sql command
        String CREATE_USERS_TABLE = "CREATE TABLE " +
                TABLE_USERS + "(" +
                COLUMN_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AGE +  " INT)";

        //construct sql command for Progress
        String CREATE_PROGRESS_TABLE = "CREATE TABLE " +
                TABLE_PROGRESS + "(" +
                COLUMN_PROGRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PART + " TEXT)";
//        TABLE_PROGRESS + " BOOL)";//

        //Execute SQL command
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_PROGRESS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROGRESS);

        //recreate table by onCreate
        onCreate(db);
    }

    //Add a user to User table DB
    public void addUser(User user){
        //Prep values for new entry
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getmUserName());
        values.put(COLUMN_AGE, user.getmAge());

        //open db
        SQLiteDatabase db = this.getWritableDatabase();

        //insert into db
        db.insert(TABLE_USERS, null, values);

        //close db
        db.close();
    }

    //Find a user in user table db
    public User findUser(String userName){
        //Construct sql string
        String sqlQuery = "SELECT * FROM " + TABLE_USERS +
                " WHERE " + COLUMN_NAME + " = \"" +
                userName + "\"";

        //Open db
        SQLiteDatabase db = this.getWritableDatabase();

        //Execute query on db and store returned rows
        Cursor myCursor = db.rawQuery(sqlQuery, null);

        //Create reference to user object
        User myUser = null;

        //If at least one row is returned, point to first entry and extract data
        if(myCursor.moveToFirst()){
            //Have to know index and type
            int tmpID = myCursor.getInt(0);
            String tmpName = myCursor.getString(1);
            int tmpAge = myCursor.getInt(2);
            myCursor.close();
            myUser = new User(tmpID, tmpName, tmpAge);
        }
        db.close();

        //return first user matching the name(if any)
        return  myUser;
    }

    //Delete user in database
    public boolean deleteUser(String username){
        //set default to false
        boolean result = false;

        //construct sql string to see if entry exists
        String sql_query = "SELECT * FROM " + TABLE_USERS +
                " WHERE " + COLUMN_NAME + " =\"" +
                username + "\"";

        //open db
        SQLiteDatabase db = this.getWritableDatabase();

        //execute query on db and store returned rows
        Cursor myCursor = db.rawQuery(sql_query, null);

        //if at least one row returned, get id if first one and delete it
        if(myCursor.moveToFirst()){
            //get id of first returned record
            int tmpID = myCursor.getInt(0);

            //delete entry with that id
            db.delete(TABLE_USERS, COLUMN_USERID + "= ?",
                    new String[]{String.valueOf(tmpID)});

            //close cursor
            myCursor.close();

            //set return result to true to show successful delete
            result = true;
        }

        //close db
        db.close();
        return result;
    }

    //Check on user Progress
    public void addProgress(String bodyPart){
        //set default to false
//        boolean result2 = false;
//
//        //construct sql string to see if entry exists
//        String sql_query = "SELECT * FROM " + TABLE_PROGRESS +
//                " WHERE " + COLUMN_AAC + " =\"" +
//                user.getmUserName() + "\"";

//        //Open db
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        //execute query on db and store returned rows
//        Cursor myCursor = db.rawQuery(sql_query, null);
//
//        UserDBHandler.update(TABLE_PROGRESS, )

//        ContentValues cv = new ContentValues();
//        cv.put("aac",false);
//
//        UserDBHandler.update(TABLE_PROGRESS, cv, )


//Prep values for new entry
        ContentValues values = new ContentValues();
        values.put(COLUMN_PART, bodyPart);

        //open db
        SQLiteDatabase db = this.getWritableDatabase();

        //insert into db
        db.insert(TABLE_PROGRESS, null, values);

        //close db
        db.close();
    }


    public ArrayList<String> getCompletedParts(){
        //Construct sql string
        String sqlQuery = "SELECT * FROM " + TABLE_PROGRESS;

        //Open db
        SQLiteDatabase db = this.getWritableDatabase();

        //Execute query on db and store returned rows
        Cursor myCursor = db.rawQuery(sqlQuery, null);

        //Create reference to user object
        ArrayList<String> myProgress = new ArrayList<>();

        //If at least one row is returned, point to first entry and extract data
        if(myCursor.moveToFirst()){
            while(myCursor.isAfterLast()){
                //Have to know index and type
                int tmpID = myCursor.getInt(0);
                String tmpName = myCursor.getString(1);
                myProgress.add(tmpName);
                myCursor.moveToNext();
            }
        }
        myCursor.close();
        db.close();

        //return first user matching the name(if any)
        return  myProgress;
    }
}
