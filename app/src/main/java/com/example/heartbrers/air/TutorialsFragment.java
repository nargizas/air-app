package com.example.heartbrers.air;

import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heart<bR>ers on 06.04.2018.
 */

public class TutorialsFragment extends Fragment {
            RecyclerView recyclerView;
            RecyclerView.Adapter adapter;
            LinearLayoutManager layoutManager;
            String[] v_name;
            int[] video_id ={R.drawable.play_button};
            ArrayList<TutorialsInfo> arrayList = new ArrayList<TutorialsInfo>();
    ProgressBar mprogressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorials, container, false);
        mprogressBar = (ProgressBar)view.findViewById(R.id.circular_progress_bar);
        /*ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();anim.end();
        v_name=getResources().getStringArray(R.array.videos_name);
        int i =0;
        for (String name: v_name)
        {
            TutorialsInfo tutorialsInfo = new TutorialsInfo(video_id[0], name);
            arrayList.add(tutorialsInfo);
            i++;
        }
        adapter = new TutAdapter(arrayList);
        recyclerView.setAdapter(adapter);*/
        recyclerView= (RecyclerView)view.findViewById(R.id.recycler_view_tutorials);
        recyclerView.setHasFixedSize(false);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("videos");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("FIREBASE", "DOWNLOAD FINISHED");
                List<TutorialsInfo> info = new ArrayList<>();

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    info.add(new TutorialsInfo(child));
                }

                mprogressBar.setVisibility(View.GONE);

                TutAdapter adapter = new TutAdapter(getContext(), info);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("FIREBASE", "DOWNLOAD ERROR");
            }
        });
        return view;
    }
}