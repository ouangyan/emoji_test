package com.xy.test.emoji;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ouyang on 2019/9/4.
 */

public class EmojiAdapter extends BaseAdapter {
    private Activity activity;
    private List<EmojiEntity> dataResource=new ArrayList<>();

    public EmojiAdapter(Activity activity){
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return dataResource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataResource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EmojiEntity emojiEntity=dataResource.get(position);
        String name=emojiEntity.getName();
        String unicode=emojiEntity.getUnicode();
        if(convertView==null)
            convertView=activity.getLayoutInflater().inflate(R.layout.item,null);
        TextView tvName=convertView.findViewById(R.id.tv_name);
        TextView tvUnicode=convertView.findViewById(R.id.tv_emoji);
        tvName.setText(name);
        tvUnicode.setText(unicode);
        return convertView;
    }

    public void addData(){
        dataResource.clear();
        dataResource=JsonParseUtil.parseEmojiList(FileUtil.readAssetsFile(activity, "emoji_list.json"));
        this.notifyDataSetChanged();
    }
}
