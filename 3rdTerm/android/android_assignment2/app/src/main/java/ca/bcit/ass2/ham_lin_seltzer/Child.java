package ca.bcit.ass2.ham_lin_seltzer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Child implements Serializable {
    private String _firstName = "0";
    private String _lastName = "0";
    private String _birthDate;
    private String _street;
    private String _city;
    private String _province;
    private String _postalCode;
    private String _country;
    private double _latitude;
    private double _longitude;
    private boolean _isNaughty;
    private String _dateCreated;

    public static final Child[] CHILD_ITEMS = {
            new Child("Maggie", "Simpson0", new Date(111, Calendar.JULY, 3).toString(), "742 Evergreen Terrace", "Vancouver", "BC", "V1V1V1", "Canada", 123.123, 123.123, false, new java.util.Date(System.currentTimeMillis()+1000).toString()),
            new Child("Bart", "Simpson1", new Date(1987, Calendar.JULY, 5).toString(), "742 Evergreen Terrace", "Springfield", "Oregon", "12312", "USA",123.123, 123.123, true, new java.util.Date(System.currentTimeMillis()+2000).toString()),
            new Child("Lisa", "Simpson2", new Date(1987, Calendar.AUGUST, 21).toString(), "742 Evergreen Terrace", "Springfield", "Oregon", "12312", "USA", 123.123 , 123.123, false, new java.util.Date(System.currentTimeMillis()+3000).toString()),
            new Child("Homer", "Simpson3", new Date(1987, Calendar.JANUARY, 21).toString(), "742 Evergreen Terrace", "Springfield", "Oregon", "12312", "USA", 123.123, 123.123, false, new java.util.Date(System.currentTimeMillis()+4000).toString()),
            new Child("Marge", "Simpson4", new Date(1987, Calendar.FEBRUARY, 21).toString(), "742 Evergreen Terrace", "Springfield", "Oregon", "12312", "USA", 123.123, 123.123, false, new java.util.Date(System.currentTimeMillis()+5000).toString())
    };

    public Child(String _firstName, String _lastName, String _birthDate, String _street, String _city, String _province, String _postalCode, String _country, double _latitude, double _longitude, boolean _isNaughty, String _dateCreated) {
        this._firstName = _firstName;
        this._lastName = _lastName;
        this._birthDate = _birthDate;
        this._street = _street;
        this._city = _city;
        this._province = _province;
        this._postalCode = _postalCode;
        this._country = _country;
        this._latitude = _latitude;
        this._longitude = _longitude;
        this._isNaughty = _isNaughty;
        this._dateCreated = _dateCreated;
    }

    public Child(String _firstName, String _lastName) {
        if (_firstName != null && _lastName != null) {
            this._firstName = _firstName;
            this._lastName = _lastName;
        }
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_birthDate() {
        return _birthDate;
    }

    public void set_birthDate(String _birthDate) {
        this._birthDate = _birthDate;
    }

    public String get_street() {
        return _street;
    }

    public void setStreet(String _street) {
        this._street = _street;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_province() {
        return _province;
    }

    public void set_province(String _province) {
        this._province = _province;
    }

    public String get_postalCode() {
        return _postalCode;
    }

    public void set_postalCode(String _postalCode) {
        this._postalCode = _postalCode;
    }

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public double get_latitude() {
        return _latitude;
    }

    public void set_latitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double get_longitude() {
        return _longitude;
    }

    public void set_longitude(double _longitude) {
        this._longitude = _longitude;
    }

    public boolean is_isNaughty() {
        return _isNaughty;
    }

    public void set_isNaughty(boolean _isNaughty) {
        this._isNaughty = _isNaughty;
    }

    public String get_dateCreated() {
        return _dateCreated;
    }

    public void set_dateCreated(String _dateCreated) {
        this._dateCreated = _dateCreated;
    }


}
