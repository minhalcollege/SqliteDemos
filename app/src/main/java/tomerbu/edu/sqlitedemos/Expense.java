package tomerbu.edu.sqlitedemos;

import android.support.annotation.Nullable;

/**
 * Created by TomerBu on 31/01/2018.
 */

public class Expense {
    private Integer _id = null;
    private String title;
    private String category;

    //ctor
    public Expense(@Nullable Integer _id, String title, String category) {
        this._id = _id;
        this.title = title;
        this.category = category;
    }
    //ctor
    public Expense(String title, String category) {
        this.title = title;
        this.category = category;
    }

    //getters and setters
    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
