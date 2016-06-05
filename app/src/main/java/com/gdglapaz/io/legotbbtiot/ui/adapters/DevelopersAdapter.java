package com.gdglapaz.io.legotbbtiot.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gdglapaz.io.legotbbtiot.R;
import com.gdglapaz.io.legotbbtiot.model.Developer;

import java.util.List;

/**
 * Created by andresvasquez on 4/6/16.
 */
public class DevelopersAdapter extends BaseAdapter{

    private Context context;
    private List<Developer> items;

    public DevelopersAdapter(Context context, List<Developer> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Developer getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    static class ViewHolder{
        /* UI components of adapter */
        TextView txtName;
        TextView txtEmail;
        TextView txtOrganization;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder=new ViewHolder();
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_developer, null);

            holder.txtName = (TextView)convertView.findViewById(R.id.txtName);
            holder.txtEmail = (TextView)convertView.findViewById(R.id.txtEmail);
            holder.txtOrganization = (TextView)convertView.findViewById(R.id.txtOrganization);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder)convertView.getTag();
        }

        /* Fill TextViews with developers info */
        Developer dev=items.get(position);
        holder.txtName.setText(dev.getName());
        holder.txtEmail.setText(dev.getEmail());
        holder.txtOrganization.setText(dev.getOrganitation());
        return convertView;
    }
}
