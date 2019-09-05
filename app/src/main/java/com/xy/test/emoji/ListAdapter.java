package com.xy.test.emoji;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ouyang on 2019/9/5.
 */

public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private List<String> dataResource=new ArrayList<>();
    private ListView listView;;

    public ListAdapter(Activity activity){
        this.activity=activity;
        listView=activity.findViewById(R.id.lv_emoji);
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
        String unicode=dataResource.get(position);
        if(convertView==null)
            convertView=activity.getLayoutInflater().inflate(R.layout.list_item,null);
        TextView textView=convertView.findViewById(R.id.tv_emoji);
        textView.setText(unicode);
        return convertView;
    }

    public void addData(String unicode){
        if(!TextUtils.isEmpty(unicode)){
            dataResource.add(unicode);
            this.notifyDataSetChanged();
            listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        }
    }
}
