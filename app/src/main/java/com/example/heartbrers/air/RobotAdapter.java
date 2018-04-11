package com.example.heartbrers.air;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nrgz on 11.04.2018.
 */

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.RoboViewHolder> {
    private ArrayList<RoboInfo> arrayList = new ArrayList<RoboInfo>();

    public RobotAdapter(ArrayList<RoboInfo> arrayList){
        this.arrayList=arrayList;
    }


    @Override
    public RoboViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_robots, parent,false);
        RoboViewHolder roboViewHolder=new RoboViewHolder(view);
        return roboViewHolder;
    }

    @Override
    public void onBindViewHolder(RoboViewHolder holder, int position) {
        RoboInfo roboInfo = arrayList.get(position);
        holder.robot_icon.setBackgroundResource(roboInfo.getIconId());
        holder.r_name.setText(roboInfo.getTitle());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class RoboViewHolder extends RecyclerView.ViewHolder {

        View robot_icon;
        TextView r_name;
        public RoboViewHolder (View view){
            super(view);
            robot_icon= (View)view.findViewById(R.id.robot_icon);
            r_name= (TextView)view.findViewById(R.id.robot_name);

        }
    }
}
