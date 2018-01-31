package tomerbu.edu.sqlitedemos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TomerBu on 31/01/2018.
 */

public class ExpenseDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "ExpenseDB";
    public static final int DB_VERSION = 1;

    public ExpenseDbHelper(Context context) {
        super(context, DB_NAME, null /*default*/, DB_VERSION);
    }


    //onCreate - method that runs once - When the db is first created.
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the expense table
        String sql = "CREATE TABLE Expenses(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "category TEXT NOT NULL " +
                ");";
        //run SQL against the db.
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //no problems - we can delete all the data
        String sql = "DROP TABLE Expenses;";
        db.execSQL(sql);

        sql = "CREATE TABLE Expenses(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "category TEXT NOT NULL " +
                ");";

        db.execSQL(sql);
    }
}
