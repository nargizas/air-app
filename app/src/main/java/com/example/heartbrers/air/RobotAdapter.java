package com.example.heartbrers.air;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.setListeners();
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }



    public class RoboViewHolder extends RecyclerView.ViewHolder {

        View robot_icon, delete_icon, copy_icon, wrench_icon;
        TextView r_name;
        int position;
        RoboInfo currentObject;
        public RoboViewHolder (View view){
            super(view);
            robot_icon= (View)view.findViewById(R.id.robot_icon);
            r_name= (TextView)view.findViewById(R.id.robot_name);


        }

        public void setListeners() {
            delete_icon.setOnClickListener((View.OnClickListener) RoboViewHolder.this);
            copy_icon.setOnClickListener((View.OnClickListener) RoboViewHolder.this);
            wrench_icon.setOnClickListener((View.OnClickListener) RoboViewHolder.this);
        }

        public void onClick(View view){
            switch (view.getId()){
                case R.id.delete_icon:
                    removeItem(position);
                    break;
                case R.id.copy_icon:
                    addItem(position, currentObject);
                    break;
            }

        }

    }

    public void removeItem(int position) {
        arrayList.remove(position);
        notifyItemInserted(position);
        notifyItemChanged(position, arrayList.size());
    }

    public void addItem(int position, RoboInfo currentObject) {
        arrayList.add(position, currentObject);
        notifyItemInserted(position);
        notifyItemChanged(position, arrayList.size());
    }


}
