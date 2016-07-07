package me.naylinaung.padc_myanmarattractions.utils;

import com.google.gson.Gson;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
