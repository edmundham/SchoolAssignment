package ca.bcit.ass1.ham_tang.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Country {

    private static final String TAG = "Country";

    private String[] countriesListByContinent;

    private String name;
    private String capital;
    private String region;
    private int population;
    private int area;
    private List<String> borders = new ArrayList<>();
    private String flag;

    public Country() {}

    public void setCountriesListByContinent(String continent) {
        HttpGetRequest getRequest = new HttpGetRequest();
        String result = null;
        String[] countryNames = null;
        try {
            result = getRequest.execute("region/" + continent).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            JSONArray jsonArray = new JSONArray(result);
            countryNames = new String[jsonArray.length()];
            for (int i= 0; i < jsonArray.length(); i++) {
                JSONObject countryObject = jsonArray.getJSONObject(i);
                String countryName = countryObject.getString("name");
                countryNames[i] = countryName;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.countriesListByContinent = countryNames;
    }

    public String[] getCountiesListByContinent() {
        return countriesListByContinent;
    }

    public void setCountryDetailsByCountryName(String countryName) {
        HttpGetRequest getRequest = new HttpGetRequest();
        String result = null;
        try {
            result = getRequest.execute("name/" + countryName).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i= 0; i < jsonArray.length(); i++) {
                JSONObject countryObject = jsonArray.getJSONObject(i);
                if (!countryName.equalsIgnoreCase(countryObject.getString("name"))) {
                    continue;
                }
                name = countryObject.getString("name");
                capital = countryObject.getString("capital");
                region = countryObject.getString("region");
                population = countryObject.getInt("population");
                area = countryObject.getInt("area");
                JSONArray borderArray = countryObject.getJSONArray("borders");
                flag = countryObject.getString("flag");
                for (int j = 0; j < borderArray.length(); j++) {
                    borders.add(borderArray.getString(j));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        if (name.isEmpty()) {
            return "N/A";
        }
        return name;
    }

    public String getCapital() {
        if (capital.isEmpty()) {
            return "N/A";
        }
        return capital;
    }

    public String getRegion() {
        if (region.isEmpty()) {
            return "N/A";
        }
        return region;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getFlag() {
        return flag;
    }

}
