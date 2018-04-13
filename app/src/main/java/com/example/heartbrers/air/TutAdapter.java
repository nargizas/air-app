package com.example.heartbrers.air;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nrgz on 12.04.2018.
 */


public class TutAdapter extends RecyclerView.Adapter<TutAdapter.TutViewHolder> {
    private List<TutorialsInfo> arrayList;
    private Context context;

    public TutAdapter(Context ctx, List<TutorialsInfo> arrayList){
        this.context = ctx;
        this.arrayList=arrayList;
    }


    @Override
    public TutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_tutorials, parent,false);
        TutViewHolder tutViewHolder=new TutViewHolder(view);
        return tutViewHolder;
    }

    @Override
    public void onBindViewHolder(TutViewHolder holder, int position) {
        final TutorialsInfo tutorialsInfo = arrayList.get(position);
        holder.v_name.setText(tutorialsInfo.getVideoName());
        holder.tutorialsBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = tutorialsInfo.getVideoURL();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });
        Picasso.get().load(tutorialsInfo.getPlaceholderURL()).into(holder.video);
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class TutViewHolder extends RecyclerView.ViewHolder {
        View tutorialsBackground;
        ImageView video;
        TextView v_name;
        public TutViewHolder (View view){
            super(view);
            tutorialsBackground = view.findViewById(R.id.layout_tutorials_holder);
            v_name= (TextView)view.findViewById(R.id.video_name);
            video=(ImageView)view.findViewById(R.id.video);

        }
    }
}

