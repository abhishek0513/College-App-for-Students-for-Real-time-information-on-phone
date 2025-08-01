package com.example.collegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.icon_computer, "Computer Science", "Computer science delves into algorithms, programming, and system design, fostering problem-solving skills crucial for the digital era's demands."));
        list.add(new BranchModel(R.drawable.icon_mechanical, "Mechanical", "Mechanical engineering entails mastering thermodynamics, mechanics, and materials science, pivotal for designing and innovating machinery and mechanical systems."));
        list.add(new BranchModel(R.drawable.icon_electrical, "Electrical", "Electrical engineering involves understanding circuits, electromagnetism, and power systems, essential for designing and optimizing electrical devices and systems."));
        list.add(new BranchModel(R.drawable.icon_civil, "Civil", "Civil engineering encompasses structural design, transportation systems, and environmental engineering, crucial for creating sustainable infrastructure and shaping our built environment."));
        list.add(new BranchModel(R.drawable.icon_bca, "BCA/MCA", "BCA/MCA programs delve into software development, database management, and IT systems, equipping students for careers in technology and information management."));
        list.add(new BranchModel(R.drawable.icon_managment, "BBA/MBA", "BBA/MBA programs focus on business administration, strategic management, and organizational leadership, preparing graduates for diverse roles in corporate management and entrepreneurship."));
        list.add(new BranchModel(R.drawable.icon_diploma, "Diploma", "Diploma programs offer specialized training in various fields, providing practical skills and knowledge essential for entry-level positions and career advancement."));
        list.add(new BranchModel(R.drawable.icon_bmlt, "BMLT/DMLT", "BMLT/DMLT programs specialize in laboratory technology, diagnostics, and medical procedures, preparing graduates for roles in healthcare and clinical laboratory settings."));


        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);


        return view;
    }
}