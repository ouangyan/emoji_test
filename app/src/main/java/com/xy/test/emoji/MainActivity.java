package com.xy.test.emoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        ListView listView=findViewById(R.id.lv_emoji);
        emojiAdapter=new EmojiAdapter(this);
        listView.setAdapter(emojiAdapter);
        emojiAdapter.addData();
    }
}
