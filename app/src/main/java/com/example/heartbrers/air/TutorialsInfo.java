package com.example.heartbrers.air;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by nrgz on 12.04.2018.
 */

public class TutorialsInfo {
    private String placeholderURL;
    private String videoURL;
    private String videoName;


    public String getPlaceholderURL() {
        return placeholderURL;
    }

    public void setPlaceholderURL(String placeholderURL) {
        this.placeholderURL = placeholderURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public TutorialsInfo(DataSnapshot ref) {
        videoName = ref.child("videoName").getValue().toString();
        placeholderURL = ref.child("videoPlaceholder").getValue().toString();
        videoURL = ref.child("videoURL").getValue().toString();
    }


}
