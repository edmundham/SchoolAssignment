package ca.bcit.lab4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Bundle bundle = getIntent().getExtras();
        ImageView imageView = findViewById(R.id.imageView1);
        TextView nameView = findViewById(R.id.textView1);
        TextView categoryView = findViewById(R.id.textView2);
        TextView countryOfOriginView = findViewById(R.id.textView3);
        TextView unitView = findViewById(R.id.textView4);
        TextView priceView = findViewById(R.id.textView5);

        byte[] b = bundle.getByteArray("photo");
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);

        imageView.setImageBitmap(bitmap);
        nameView.setText(bundle.getString("name"));
        categoryView.setText(bundle.getString("category"));
        countryOfOriginView.setText(bundle.getString("countryOfOrigin"));
        unitView.setText(bundle.getString("unit"));
        priceView.setText(String.valueOf(bundle.getFloat("price")));
    }
}
