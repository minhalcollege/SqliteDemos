package tomerbu.edu.sqlitedemos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * DB Access object - Queries, SELECT READ UPDATE DELETE
 * ALL SQL Goes here. No SQL outside this class.
 */

//prepared queries
public class ExpenseDAO {
    //disk access requires context.
    //database -> context
    private SQLiteDatabase db;

    //ctor:
    public ExpenseDAO(Context context) {
        //init the db ->
        ExpenseDbHelper helper =
                new ExpenseDbHelper(context);

        db = helper.getWritableDatabase();
    }

    public Expense getExpense(int id) {
        String sql = "SELECT * FROM Expenses WHERE _id=" + id;

        Cursor cursor =
                db.rawQuery(sql, null);

        cursor.moveToFirst();

        int tIdx = cursor.getColumnIndex("title");
        int categoryIdx = cursor.getColumnIndex("category");
        int idIdx = cursor.getColumnIndex("_id");

        int _id = cursor.getInt(idIdx);
        String title = cursor.getString(tIdx);
        String category = cursor.getString(categoryIdx);

        cursor.close();
        return new Expense(_id, title, category);
    }

    public ArrayList<Expense> getExpenses() {
        String sql = "SELECT * FROM Expenses";
        Cursor cursor =
                db.rawQuery(sql, null);

        //empty result set:
        ArrayList<Expense> expenses = new ArrayList<>();

        if (!cursor.moveToNext()) return expenses;

        int tIdx = cursor.getColumnIndex("title");
        int categoryIdx = cursor.getColumnIndex("category");
        int idIdx = cursor.getColumnIndex("_id");
        do {
            int _id = cursor.getInt(idIdx);
            String title = cursor.getString(tIdx);
            String category = cursor.getString(categoryIdx);

            expenses.add(new Expense(_id, title, category));
        } while (cursor.moveToNext());
        cursor.close();
        return expenses;
    }

    //addExpense
    public void addExpense(Expense expense) {
        //TODO: clean up! homework.
        //prawn to SQL Injection...
        String sql = String.format(
                "INSERT INTO Expenses(title, category)" +
                        "VALUES('%s', '%s');",
                expense.getTitle(),
                expense.getCategory()
        );

        db.execSQL(sql); //does not return a value.

/*
        ContentValues dict = new ContentValues();
        dict.put("title", expense.getTitle());
        dict.put("category", expense.getCategory());

        db.insert("Expenses",
                null, dict);*/
        //db.rawQuery() //SELECT
    }
    //getExpenseById

    //"bur\';'DROP TABLE Expenses"
    public ArrayList<Expense> getExpense(String search) {
        String sql = "SELECT * FROM Expenses WHERE category LIKE '%" + search + "%' OR title LIKE '%" + search + "%';";

        String[] args = {search, search};//?, ?

        Cursor cursor =
                db.rawQuery(sql, null);

        cursor.moveToFirst();


        ArrayList<Expense> expenses = new ArrayList<>();
        if (!cursor.moveToNext()) return expenses;


        int tIdx = cursor.getColumnIndex("title");
        int categoryIdx = cursor.getColumnIndex("category");
        int idIdx = cursor.getColumnIndex("_id");
        do {
            int _id = cursor.getInt(idIdx);
            String title = cursor.getString(tIdx);
            String category = cursor.getString(categoryIdx);
            Expense e = new Expense(_id, title, category);
            expenses.add(e);
        }
        while (cursor.moveToNext());

        cursor.close();
        return expenses;
    }

    //deleteExpense


    //updateExpense
    public void updateExpense(Expense expense) {
        if (expense.get_id() == null) {
            throw new RuntimeException("No Update for you");
        }

        String sql = String.format("UPDATE Expenses SET title = '%s', category= '%s' WHERE _id = %d",
                        expense.getTitle(),
                        expense.getCategory(),
                        expense.get_id()
                );
        Log.d("Expdb", sql);
        db.rawQuery(sql, null );
    }

    public void delete(Expense expense) {
        Integer id = expense.get_id();
        if (id == null) {
            throw new RuntimeException("Can't delete without id");
        }

        String sql = "DELETE FROM Expenses WHERE _id = " + id;

        db.execSQL(sql);
    }

}
