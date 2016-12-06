package ir.adicom.app.checkmanagmentapp;

/**
 * Created by adicom on 12/6/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "checkListDataBase";

    // Contacts table name
    private static final String TABLE_CHECKLIST = "checkLists";

    // Contacts Table Columns names

    private static final String KEY_ID = "id";
    private static final String KEY_PRICE = "price";
    private static final String KEY_VAJHE = "vajhe";
    private static final String KEY_BABAT = "babat";
    private static final String KEY_DATE = "date";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CHECKLIST + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PRICE + " TEXT,"
                + KEY_VAJHE + " TEXT,"
                + KEY_BABAT + " TEXT,"
                + KEY_DATE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHECKLIST);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new check
    void addCheck(Check check) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRICE, check.getPrice()); 
        values.put(KEY_VAJHE, check.getVajhe()); 
        values.put(KEY_BABAT, check.getBabat()); 
        values.put(KEY_DATE, check.getDate()); 

        // Inserting Row
        db.insert(TABLE_CHECKLIST, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Check
    Check getCheck(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CHECKLIST, new String[] { KEY_ID,
                        KEY_PRICE, KEY_VAJHE, KEY_BABAT, KEY_DATE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Check check = new Check(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
        // return check
        return check;
    }

    // Getting All Checks
    public List<Check> getAllChecks() {
        List<Check> checkList = new ArrayList<Check>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CHECKLIST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Check check = new Check();
                check.setId(Integer.parseInt(cursor.getString(0)));
                check.setPrice(cursor.getString(1));
                check.setVajhe(cursor.getString(2));
                check.setBabat(cursor.getString(3));
                check.setDate(cursor.getString(4));
                // Adding check to list
                checkList.add(check);
            } while (cursor.moveToNext());
        }

        // return check list
        return checkList;
    }

    // Updating single check
    public int updateCheck(Check check) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PRICE, check.getPrice());
        values.put(KEY_VAJHE, check.getVajhe());
        values.put(KEY_BABAT, check.getBabat());
        values.put(KEY_DATE, check.getDate());

        // updating row
        return db.update(TABLE_CHECKLIST, values, KEY_ID + " = ?",
                new String[] { String.valueOf(check.getId()) });
    }

    // Deleting single check
    public void deleteCheck(Check check) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHECKLIST, KEY_ID + " = ?",
                new String[] { String.valueOf(check.getId()) });
        db.close();
    }


    // Getting checks Count
    public int getChecksCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CHECKLIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
