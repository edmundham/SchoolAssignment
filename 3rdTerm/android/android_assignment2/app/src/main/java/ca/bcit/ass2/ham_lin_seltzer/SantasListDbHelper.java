package ca.bcit.ass2.ham_lin_seltzer;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class SantasListDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Child.db";
    private static final int DB_VERSION = 2;
    private Context context;
    private String tableName = "LIST";
    private String columnId = "_id";
    private String DATE_CREATED_COL = "DATE_CREATED";

    public SantasListDbHelper(Context context) {
        // The 3'rd parameter (null) is an advanced feature relating to cursors
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        updateMyDatabase(sqLiteDatabase, i, i1);
    }

    private String getCreateListTableSql() {
        String sql = "";
        sql += "CREATE TABLE " + tableName + " (";
        sql += columnId + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "FIRST_NAME TEXT, ";
        sql += "LAST_NAME TEXT, ";
        sql += "BIRTH_DATE TEXT, ";
        sql += "STREET TEXT, ";
        sql += "CITY TEXT, ";
        sql += "PROVINCE TEXT, ";
        sql += "POSTAL_CODE TEXT, ";
        sql += "COUNTRY TEXT, ";
        sql += "LATITUDE real, ";
        sql += "LONGITUDE real, ";
        sql += "ISNAUGHTY NUMERIC, ";
        sql += DATE_CREATED_COL + " TEXT); ";

        return sql;
    }

    private void insertList(SQLiteDatabase db, Child child) {
        ContentValues values = new ContentValues();
        values.put("FIRST_NAME", child.get_firstName());
        values.put("LAST_NAME", child.get_lastName());
        values.put("BIRTH_DATE", child.get_birthDate()); // Made date value toString
        values.put("STREET", child.get_street());
        values.put("CITY", child.get_city());
        values.put("PROVINCE", child.get_province());
        values.put("POSTAL_CODE", child.get_postalCode());
        values.put("COUNTRY", child.get_country());
        values.put("LATITUDE", child.get_latitude());
        values.put("LONGITUDE", child.get_longitude());
        values.put("ISNAUGHTY", child.is_isNaughty());
        values.put(DATE_CREATED_COL, child.get_dateCreated()); // Made date value toString

        db.insert("LIST", null, values);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            if (oldVersion < 1) {
                db.execSQL(getCreateListTableSql());
                for (Child c : Child.CHILD_ITEMS) {
                    insertList(db, c);
                }
            }
            if (oldVersion < 2)
                db.execSQL("ALTER TABLE LIST ADD COLUMN POPULATION NUMERIC;");
        } catch (SQLException sqle) {
            String msg = "[SantasListDbHelper/updateMyDatabase/insertChild] DB unavailable";
            msg += "\n\n" + sqle.toString();
            Toast t = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            t.show();
        }
    }

    public boolean addKid(Child child) {
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("FIRST_NAME", child.get_firstName());
            values.put("LAST_NAME", child.get_lastName());
            values.put("BIRTH_DATE", child.get_birthDate());
            values.put("STREET", child.get_street());
            values.put("CITY", child.get_city());
            values.put("PROVINCE", child.get_province());
            values.put("POSTAL_CODE", child.get_postalCode());
            values.put("COUNTRY", child.get_country());
            values.put("LATITUDE", child.get_latitude());
            values.put("LONGITUDE", child.get_longitude());
            values.put("ISNAUGHTY", child.is_isNaughty());
            values.put(DATE_CREATED_COL, child.get_dateCreated());

            database.insert("LIST", null, values);
            database.close();
        } catch (SQLException e) {
            String msg = "[SantasListDbHelper/insertChild] DB unavailable";
            msg += "\n\n" + e.toString();
            Toast t = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            t.show();
            // return false when error occurs
            return false;
        }
        // returns true when successful
        return true;
    }

    boolean deleteChild(Child child) {
        SQLiteDatabase db = getWritableDatabase();
        if (child.get_dateCreated() == null) {
            return false;
        }
        return db.delete(tableName, "first_name=? and last_name=?",
                new String[]{child.get_firstName(), child.get_lastName()}) == 1;
    }

    boolean editChild(Child child) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FIRST_NAME", child.get_firstName());
        values.put("LAST_NAME", child.get_lastName());
        values.put("BIRTH_DATE", child.get_birthDate());
        values.put("STREET", child.get_street());
        values.put("CITY", child.get_city());
        values.put("PROVINCE", child.get_province());
        values.put("POSTAL_CODE", child.get_postalCode());
        values.put("COUNTRY", child.get_country());
        values.put("LATITUDE", child.get_latitude());
        values.put("LONGITUDE", child.get_longitude());
        values.put("ISNAUGHTY", child.is_isNaughty());

        return database.update(tableName, values, "first_name=? and last_name=?",
                new String[]{child.get_firstName(), child.get_lastName()}) == 1;
    }

}
