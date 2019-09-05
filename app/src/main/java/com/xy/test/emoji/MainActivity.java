package com.xy.test.emoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private ListAdapter listAdapter;
    private EmojiAdapter emojiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListAdapter();
        initEmojiAdapter();
        EventBus.getDefault().register(this);
    }

    public void initListAdapter(){
        ListView listView=findViewById(R.id.lv_emoji);
        listAdapter=new ListAdapter(this);
        listView.setAdapter(listAdapter);
    }

    public void initEmojiAdapter(){
        GridView gridView=findViewById(R.id.gv_emoji);
        emojiAdapter=new EmojiAdapter(this);
        gridView.setAdapter(emojiAdapter);
        emojiAdapter.addData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void execute(ListAdapterEvent event){
        String unicode=event.unicode;
        listAdapter.addData(unicode);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
