package tomerbu.edu.sqlitedemos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    //addExpense
    //getExpenseById
    //getAllExpenses
    //deleteExpense
    //updateExpense
}
