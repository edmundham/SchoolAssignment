package ca.bcit.ass2.ham_lin_seltzer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;


public class ChildrenDetailsFragment extends Fragment {

    private String childName;
    private Child child;

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public ChildrenDetailsFragment() {
        // Required empty public constructor
    }

    public Child getChild() {
        return child;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            childName = savedInstanceState.getString("childName");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_children_details, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View v = getView();
        if (childName.equals("0")) {
            TextView name = v.findViewById(R.id.firstName);
            name.setText("No matching values");
        } else {
            child = getChild(childName);

            TextView name = v.findViewById(R.id.firstName);
            name.setText(getResources().getString(R.string.firstNameLabel, child.get_firstName()));

            TextView desc = v.findViewById(R.id.lastName);
            desc.setText(getResources().getString(R.string.lastNameLabel, child.get_lastName()));

            TextView birth = v.findViewById(R.id.birthDate);
            birth.setText(getResources().getString(R.string.birthdateLabel, child.get_birthDate()));

            TextView street = v.findViewById(R.id.street);
            street.setText(getResources().getString(R.string.streetLabel, child.get_street()));

            TextView city = v.findViewById(R.id.city);
            city.setText(getResources().getString(R.string.cityLabel, child.get_city()));

            TextView province = v.findViewById(R.id.province);
            province.setText(getResources().getString(R.string.provinceLabel, child.get_province()));

            TextView postalCode = v.findViewById(R.id.postalCode);
            postalCode.setText(getResources().getString(R.string.postalCodeLabel ,child.get_postalCode()));

            TextView count = v.findViewById(R.id.country);
            count.setText(getResources().getString(R.string.countryLabel,child.get_country()));

            TextView lat = v.findViewById(R.id.latitude);
            Double latitudeNum = child.get_latitude();
            String latString = latitudeNum.toString();
            lat.setText(getResources().getString(R.string.latitudeLabel, latString));

            TextView longitude = v.findViewById(R.id.longitude);
            Double longNum = child.get_longitude();
            String longString = longNum.toString();
            longitude.setText(getResources().getString(R.string.longitudeLabel, longString));

            TextView isNaughty = v.findViewById(R.id.isNaughty);
            String string = valueOf(child.is_isNaughty());
            isNaughty.setText(getResources().getString(R.string.naughtyLabel, string));

            TextView dateCreated = v.findViewById(R.id.dateCreated);
            dateCreated.setText(getResources().getString(R.string.dateCreatedLabel, child.get_dateCreated()));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("childName", childName);
    }

    private Child getChild(String chld) {
        SQLiteOpenHelper helper = new SantasListDbHelper(getContext());
        try {
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("LIST",
                    new String[]{"FIRST_NAME", "LAST_NAME", "BIRTH_DATE", "STREET", "CITY",
                            "PROVINCE", "POSTAL_CODE", "COUNTRY", "LATITUDE", "LONGITUDE", "ISNAUGHTY",
                            "DATE_CREATED"},
                    "FIRST_NAME = ? OR LAST_NAME = ?",
                    new String[]{chld, chld},
                    null, null, null);

            // move to the first record
            if (cursor.moveToFirst()) {
                // get the child details from the cursor
                child = new Child(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getDouble(8),
                        cursor.getDouble(9),
                        cursor.getInt(10) > 0,
                        cursor.getString(11)
                );
            }
            cursor.close();
            db.close();
        } catch (SQLiteException sqlex) {
            String msg = "[ChildrenDetailsActivity/getChild] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(getContext(), msg, Toast.LENGTH_LONG);
            t.show();
        }

        return child;
    }


}
