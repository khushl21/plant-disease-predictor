package com.example.sih_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CropAdapter extends ArrayAdapter<CropItem>{

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

    private ArrayList<CropItem> cropItemArrayList;
    private Context context;

    CropAdapter(Context context, ArrayList<CropItem> cropItemArrayList){
        super(context, R.layout.activity_crop_item);
        this.cropItemArrayList = cropItemArrayList;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;

            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.activity_crop_item, parent, false);
                holder = new ViewHolder();
                holder.imageView = convertView.findViewById(R.id.imageView);
                holder.textView = convertView.findViewById(R.id.textView);
                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }

            CropItem cropItem = cropItemArrayList.get(position);
            Glide.with(context).load(cropItem.getImages()).into(holder.imageView);
            holder.textView.setText(cropItem.getNames());

            return convertView;
    }

    public int getCount() { return cropItemArrayList.size(); }
    public CropItem getItem(int position) { return cropItemArrayList.get(position); }

}
