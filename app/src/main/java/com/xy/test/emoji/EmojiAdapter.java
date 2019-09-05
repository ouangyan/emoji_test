package com.xy.test.emoji;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ouyang on 2019/9/4.
 */

public class EmojiAdapter extends BaseAdapter {
    private Activity activity;
    private List<EmojiEntity> dataResource=new ArrayList<>();
    private List<EmojiEntity2> dataResource2=new ArrayList<>();

    public EmojiAdapter(Activity activity){
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return dataResource2.size();
    }

    @Override
    public Object getItem(int position) {
        return dataResource2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EmojiEntity2 emojiEntity=dataResource2.get(position);
        String unicode=emojiEntity.getUnicode();
        if(convertView==null)
            convertView=activity.getLayoutInflater().inflate(R.layout.grid_item,null);
        TextView tvUnicode=convertView.findViewById(R.id.tv_emoji);
        tvUnicode.setText(unicode);
        tvUnicode.setOnClickListener(emojiListener);
        convertView.setTag(emojiEntity);
        return convertView;
    }

    public void addData(){
//        dataResource.clear();
//        dataResource=JsonParseUtil.parseEmojiList(FileUtil.readAssetsFile(activity, "emoji_list.json"));
        dataResource2.clear();
        dataResource2=JsonParseUtil.parseEmojiList2(FileUtil.readAssetsFile(activity, "emojis.json"));
        this.notifyDataSetChanged();
    }

    View.OnClickListener emojiListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EmojiEntity2 emojiEntity2=(EmojiEntity2) ((View)v.getParent()).getTag();
            ListAdapterEvent event=new ListAdapterEvent();
            event.unicode=emojiEntity2.getUnicode();
            EventBus.getDefault().post(event);
        }
    };
}
