package ca.bcit.infosys;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class Address implements Serializable {

    private static final long serialVersionUid = 1L;

    private String stateOrProvince;
    private String country = "CA";
    private String city;
    private String street;
    private String postalCode;

    private List<String> countries = Arrays.asList(COUNTRIES);
    private List<String> statesOrProvinces = Arrays.asList(PROVINCES);

    public static final String[] COUNTRIES = {"CA", "US"};
    public static final String[] PROVINCES = {"BC", "AB", "ON", "NWT"};
    public static final String[] STATES = {"TX", "NYC", "CA", "WA"};

    public Address() {

    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<String> getStatesOrProvinces() {
        if (country.equalsIgnoreCase("ca")) {
            return statesOrProvinces = Arrays.asList(PROVINCES);
        } else if (country.equalsIgnoreCase("us")) {
            return statesOrProvinces = Arrays.asList(STATES);
        } else {
            return statesOrProvinces = null;
        }
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String save() {
        return null;
    }

    public void countryChanged(ValueChangeEvent event) {
        if (event.getNewValue().equals("CA")) {
            country = "CA";
        } else {
            country = "US";
        }
    }

    public void setStatesOrProvinces(List<String> statesOrProvinces) {
        this.statesOrProvinces = statesOrProvinces;
    }
}
