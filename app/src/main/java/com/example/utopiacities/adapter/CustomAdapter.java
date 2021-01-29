package com.example.utopiacities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.utopiacities.R;
import com.example.utopiacities.model.Utopia;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Utopia>list;
    public CustomAdapter(@NonNull Context context, int resource,@NonNull List<Utopia>objects) {
        super(context, resource,objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txtName = convertView.findViewById(R.id.tv_name);
            viewHolder.txtSub = convertView.findViewById(R.id.tv_sub);
            viewHolder.txtNum = convertView.findViewById(R.id.tv_num);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Utopia utopia = list.get(position);
        viewHolder.txtName.setText(String.valueOf(utopia.getName()));
        viewHolder.txtSub.setText(String.valueOf(utopia.getSubTitles()));
        viewHolder.txtNum.setText(String.valueOf(utopia.getNumber()));


        return convertView;
    }

    public class ViewHolder{
        private TextView txtId,txtName,txtSub,txtNum;
    }
}
