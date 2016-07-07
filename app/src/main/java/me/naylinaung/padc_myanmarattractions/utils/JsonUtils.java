package me.naylinaung.padc_myanmarattractions.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

import me.naylinaung.padc_myanmarattractions.MyanmarAttractionsApp;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class JsonUtils {

    private static final String PATH_DUMMY_DATA = "dummy_data";

    private static JsonUtils objInstance;

    private Context context;

    public static JsonUtils getInstance() {
        if (objInstance == null) {
            objInstance = new JsonUtils();
        }

        return objInstance;
    }

    private  JsonUtils() {
        context = MyanmarAttractionsApp.getContext();
    }

    private byte[] readJsonFile(String fileName) throws IOException {
        InputStream in = context.getAssets().open(fileName);
        int size = in.available();
        byte[] buffer = new byte[size];
        in.read(buffer);
        in.close();
        return buffer;
    }

    public String LoadDummyData(String fileName) throws IOException {
        byte[] buffer = this.readJsonFile(PATH_DUMMY_DATA + "/" + fileName);
        return new String(buffer, "UTF-8");
    }

}
