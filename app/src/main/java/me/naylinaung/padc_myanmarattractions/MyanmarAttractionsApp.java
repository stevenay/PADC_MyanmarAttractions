package me.naylinaung.padc_myanmarattractions;

import android.app.Application;
import android.content.Context;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class MyanmarAttractionsApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        context = null;
    }

    public static Context getContext() {
        return context;
    }

}
