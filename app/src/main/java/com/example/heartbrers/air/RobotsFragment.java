package com.example.heartbrers.air;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by nrgz on 06.04.2018.
 */
public class RobotsFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] r_name;
    int[] icon_id ={R.drawable.industrial_robot};
    int[] delete ={R.drawable.delete};
    int[] copy ={R.drawable.content_copy};
    ArrayList<RoboInfo> arrayList = new ArrayList<RoboInfo>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_robots, container, false);
        recyclerView= (RecyclerView)view.findViewById(R.id.recycler_view_robots);


        r_name=getResources().getStringArray(R.array.robots_name);
        int i =0;
        for (String name: r_name)
        {
            RoboInfo roboInfo = new RoboInfo(icon_id[0], name, delete[0], copy[0]);
            arrayList.add(roboInfo);
            i++;
        }
        adapter = new RobotAdapter(arrayList);
        recyclerView.setHasFixedSize(false);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;


    }



}
