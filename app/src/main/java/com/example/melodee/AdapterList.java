package com.example.melodee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.LayoutInflaterCompat;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<Chat> {
    private Context cont;
    private int res;

    public AdapterList(@NonNull Context context, int resource, @NonNull ArrayList<Chat> objects) {
        super(context, resource, objects);
        cont = context;
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getImages();
        String title = getItem(position).getTitle();
        String name = getItem(position).getName();
        String category = getItem(position).getCategory();
        String price = getItem(position).getPrice();
        String sold = getItem(position).getSold();

        LayoutInflater lay = LayoutInflater.from(cont);

        convertView = lay.inflate(res, parent, false);

        ImageView vimg = convertView.findViewById(R.id.img);
        TextView ttitle = convertView.findViewById(R.id.albumTtl);
        TextView tname = convertView.findViewById(R.id.artist);
        TextView tcat = convertView.findViewById(R.id.category);
        TextView tprice = convertView.findViewById(R.id.price);
        TextView tsold = convertView.findViewById(R.id.totalSold);


        vimg.setImageResource(image);
        ttitle.setText(title);
        tname.setText(name);
        tcat.setText(category);
        tprice.setText(price);
        tsold.setText(sold);

        return convertView;
    }
}
