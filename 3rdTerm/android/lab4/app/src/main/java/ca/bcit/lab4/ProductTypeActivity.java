package ca.bcit.lab4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTypeActivity extends AppCompatActivity {

    private static final String TAG = "ProductTypeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_type);

        Bundle bundle = getIntent().getExtras();
        final String category = bundle.getString("categoryName");

        Food[] categoryFood;

        switch (category) {
            case "Fruit":
                categoryFood = Food.fruits;
                break;
            case "Vegetables":
                categoryFood = Food.vegetables;
                break;
            case "Bakery":
                categoryFood = Food.bakery;
                break;
            default:
                categoryFood = null;
                break;
        }

        String[] categoryFoodNames = new String[categoryFood.length];

        for (int i = 0; i < categoryFood.length; i++) {
            categoryFoodNames[i] = categoryFood[i].getName();
        }

        ListView view = findViewById(R.id.listType);
        final List<Food> categoryList = new ArrayList<>(Arrays.asList(categoryFood));

        ArrayAdapter<Food> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoryList);
        view.setAdapter(arrayAdapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), categoryList.get(position).getImageResourceId());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();

                Intent intent = new Intent(ProductTypeActivity.this, ProductDetailActivity.class);
                intent.putExtra("name", categoryList.get(position).getName());
                intent.putExtra("category", categoryList.get(position).getCategory());
                intent.putExtra("countryOfOrigin", categoryList.get(position).getCountryOfOrigin());
                intent.putExtra("unit", categoryList.get(position).getUnit());
                intent.putExtra("price", categoryList.get(position).getPrice());
                intent.putExtra("photo", b);
                startActivity(intent);
            }
        });
    }
}
