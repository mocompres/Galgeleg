package com.example.galgeleg;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.transform.Result;

public class WordsFromWeb extends AsyncTask<String, String, String> {

    String data = "";
    String getURL;

    WordsFromWeb (String url)
    {
        getURL = url;
    }




    @Override
    protected String doInBackground(String... url) {

        String line = "";
        StringBuilder sb = new StringBuilder();
        try {

            URL urlTest = new URL(getURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlTest.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader((inputStream)));


            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
                data += line;
            }
            in.close();

        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        System.out.println(data);
    }
}
