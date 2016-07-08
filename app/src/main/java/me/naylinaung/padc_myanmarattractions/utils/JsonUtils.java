package me.naylinaung.padc_myanmarattractions.utils;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

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

    public String LoadOnlineData() {
        DownloadJsonTask task = new DownloadJsonTask();
        try {
            String result = task.execute("http://www.aungpyaephyo.xyz/myanmar_attractions/myanmar_attractions.json").get();
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public class DownloadJsonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }
}
