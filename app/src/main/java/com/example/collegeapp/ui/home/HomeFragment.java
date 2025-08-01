package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.collegeapp.R;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private ImageView map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


//        setContentView(R.layout.activity_main);

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.logo, "Shri ram college of Engineering and Management", ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel( R.drawable.jobfest,"Job Fest 2024", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.jobfesttwo, "Our HODs with recruiter", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.culturalfest, "Cultural fest 2024", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.trip, "Trip to Rashtrapati Bhavan", ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.independance, "Independence day celebration", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.dance, "Orientation Day celebration", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.techfest, "Tech fest 2024", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.imagesliderfour, "Poster Presentation competition", ScaleTypes.CENTER_CROP));

        imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });



        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Shri ram college of Engineering and Managment, palwal");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


}