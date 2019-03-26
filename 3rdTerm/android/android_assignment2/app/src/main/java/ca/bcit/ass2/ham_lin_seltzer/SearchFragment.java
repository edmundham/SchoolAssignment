package ca.bcit.ass2.ham_lin_seltzer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class SearchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private SQLiteDatabase db;
    private Cursor cursor;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void btnToggleClick(View v) {
        EditText childNameTextInput = getView().findViewById(R.id.childName);
        String searchWord = childNameTextInput.getText().toString();
        String childName = getChildByFirstOrLastName(searchWord);

        MainActivity.openDetailFragment(childName);
    }

    private String getChildByFirstOrLastName(String firstOrLastName) {
        SQLiteOpenHelper helper = new SantasListDbHelper(getContext());
        Child child = null;
        String childName = null;
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("LIST",
                    new String[]{"FIRST_NAME", "LAST_NAME"},
                    "FIRST_NAME = ? OR LAST_NAME = ?",
                    new String[]{firstOrLastName, firstOrLastName},
                    null,
                    null,
                    null);

            // move to the first record
            if (cursor.moveToFirst()) {
                // get the country details from the cursor
                child = new Child(
                        cursor.getString(0),
                        cursor.getString(1)
                );
            }
        } catch (SQLiteException sqlex) {
            String msg = "[MainActivity / getChild] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(getContext(), msg, Toast.LENGTH_LONG);
            t.show();
        }
        if (child != null) {
            return child.get_firstName();
        }
        Child c = new Child(null, null);
        c.get_firstName();
        return c.get_firstName();
    }

}
