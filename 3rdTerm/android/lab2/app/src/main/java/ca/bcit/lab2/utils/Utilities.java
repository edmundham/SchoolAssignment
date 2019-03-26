package ca.bcit.lab2.utils;

import android.graphics.Color;

import java.util.Random;

public class Utilities {

    public final static int colorGenerator() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        return color;
    }

}
