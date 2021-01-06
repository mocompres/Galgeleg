package com.example.galgeleg;

import android.content.ContentProvider;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordListAdapter extends BaseAdapter {

    ArrayList<String> wordList;
    Context context;

    public WordListAdapter(ArrayList<String> words, Context context) {
        this.wordList = words;
        this.context = context;
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public String getItem(int position) {
        return wordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = new TextView(this.context);
        textView.setText(getItem(position));

        //convertView = textView;


        return textView;
    }
}
