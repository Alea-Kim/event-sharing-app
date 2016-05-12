package com.eventsharing.watudu;

/**
 * Created by mikalenon on 4/27/2016.
 */
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{

    String [] result;
    String [] desc;
    Context context;
    String [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(EVENTS events, String[] prgmNameList, String[] prgmImages, String[] prgmDesc) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        desc = prgmDesc;
        context = events;
        imageId = prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.programlist, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);

        Uri uri;
        uri= Uri.parse(imageId[position]);
        holder.img.setImageURI(uri);
        
        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, desc[position], Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

}