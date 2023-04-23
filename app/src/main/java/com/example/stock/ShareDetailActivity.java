package com.example.stock;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShareDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_detail);

        GetData data = new GetData();
        data.execute("");

        Log.d("jsonDATA", "onCreate: "+data.execute("https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=demo"));

    }

    private static class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String uri = strings[0];
            String result = null;
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(uri);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader inputStreamReader =  new InputStreamReader(in);

                int data = inputStreamReader.read();

                while(data != -1){
                    result += (char) data;
                    data = inputStreamReader.read();
                }
                return result;
            } catch (IOException e) {

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }
    }


}