package com.xy.test.emoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EmojiAdapter emojiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdapter();
    }

    public void initAdapter(){
        GridView gridView=findViewById(R.id.gv_emoji);
        emojiAdapter=new EmojiAdapter(this);
        gridView.setAdapter(emojiAdapter);
        emojiAdapter.addData();
    }
}
