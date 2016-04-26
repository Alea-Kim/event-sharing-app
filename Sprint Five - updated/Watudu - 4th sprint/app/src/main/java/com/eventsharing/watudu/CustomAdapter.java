package com.eventsharing.watudu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private List<ItemObject> listStorage;

    public CustomAdapter(Context context, List<ItemObject> customizedListView) {
        lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = lInflater.inflate(R.layout.list, parent, false);

            listViewHolder.title = (TextView)convertView.findViewById(R.id.textView);
            listViewHolder.description = (TextView)convertView.findViewById(R.id.textView2);
            listViewHolder.picture = (TextView)convertView.findViewById(R.id.textView3);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.title.setText("Event Title: " + listStorage.get(position).getTitle());
        listViewHolder.description.setText("Description: " + listStorage.get(position).getDescription());
        listViewHolder.picture.setText("Picture: " + listStorage.get(position).getPicture());

        return convertView;
    }
    static class ViewHolder{

        TextView title;
        TextView description;
        TextView picture;
    }
}



