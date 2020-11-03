package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class SharedPrefData extends AppCompatActivity  implements IHighScoreData {
    @Override
    public void saveHighScoreList(ArrayList<Score> list) {

        ArrayList<String> strToConvert = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            strToConvert.add(list.get(i).getName() + "," + list.get(i).getPoints());
        }



        SharedPreferences sharedPref = getSharedPreferences("Shared Pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(strToConvert);
        editor.putString("MyList",json);
        editor.apply();
    }

    @Override
    public ArrayList<Score> getHighScoreList() {

        ArrayList<String> strToConvert;

        SharedPreferences sharedPref = getSharedPreferences("Shared Pref",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPref.getString("MyList",null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        strToConvert = gson.fromJson(json,type);

        if(strToConvert == null){
            return new ArrayList<>();
        }

        ArrayList<Score> list = new ArrayList<>();

        for (int i = 0; i < strToConvert.size(); i++) {
            String[] temp = strToConvert.get(i).split(",");

            Score s = new Score(temp[0], Integer.parseInt(temp[1]));
            list.add(s);
        }

        return list;
    }
}
