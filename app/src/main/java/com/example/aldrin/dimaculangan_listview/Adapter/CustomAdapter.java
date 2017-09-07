package com.example.aldrin.dimaculangan_listview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aldrin.dimaculangan_listview.Activity.MainActivity;
import com.example.aldrin.dimaculangan_listview.Model.College;
import com.example.aldrin.dimaculangan_listview.R;

import java.util.List;

/**
 * Created by Aldrin on 07/09/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context myContext;
    private List<College> colleges;
    ImageView iv_Logo;
    TextView tv_Name, tv_Year;

    public CustomAdapter(Context myContext, List<College> listVersions) {
        this.myContext = myContext;
        this.colleges = listVersions;
    }

    @Override
    public int getCount() {
        return colleges.size();
    }

    @Override
    public Object getItem(int position) {
        return colleges.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(myContext, R.layout.row_layout, null);
        iv_Logo = (ImageView) view.findViewById(R.id.ivLogo);
        tv_Name = (TextView) view.findViewById(R.id.tvCollege);
        tv_Year = (TextView) view.findViewById(R.id.tvYear);
        iv_Logo.setImageResource(colleges.get(position).getLogo());
        tv_Name.setText(colleges.get(position).getName());
        tv_Year.setText(colleges.get(position).getYear());
        return view;
    }
}
