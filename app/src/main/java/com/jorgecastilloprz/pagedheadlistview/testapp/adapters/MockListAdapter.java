package com.jorgecastilloprz.pagedheadlistview.testapp.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jorgecastilloprz.pagedheadlistview.testapp.R;

import java.util.ArrayList;

/**
 * Created by jorge on 4/08/14.
 */
public class MockListAdapter extends ArrayAdapter<String> {

    private ArrayList<String> mockItems;
    private LayoutInflater inflater = null;
    private int layoutResourceId;
    private Context context;
    Typeface typefaceRobotoLight;
    Typeface typefaceRobotoThin;

    public MockListAdapter(Context context, int resource, ArrayList<String> items) {

        super(context, resource, items);
        this.mockItems = items;
        this.layoutResourceId = resource;
        this.context = context;

        //Roboto font
        typefaceRobotoThin = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");
        typefaceRobotoLight = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceId, null);

            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.text.setTypeface(typefaceRobotoLight);
        holder.text.setText(mockItems.get(position));

        return convertView;
    }

    public static class ViewHolder {
        public TextView text;
    }
}