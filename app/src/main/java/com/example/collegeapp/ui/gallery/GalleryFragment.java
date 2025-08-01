package com.example.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    GalleryAdapter adapter;
    DatabaseReference reference;

    RecyclerView otherRecycler, independenceRecycler, webinarRecycler, jobRecycler, culturalRecycler,
            classesRecycler, danceRecycler, festivalRecycler, announcementRecycler, seminarsRecycler,
            sportsRecycler, healthRecycler, guestRecycler, contestRecycler, socialRecycler, communityRecycler,
            careerRecycler, musicRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        otherRecycler = view.findViewById(R.id.otherRecycler);
        independenceRecycler = view.findViewById(R.id.independenceRecycler);
        webinarRecycler = view.findViewById(R.id.webinarRecycler);
        jobRecycler = view.findViewById(R.id.jobRecycler);
        culturalRecycler = view.findViewById(R.id.culturalRecycler);
        classesRecycler = view.findViewById(R.id.classesRecycler);
        danceRecycler = view.findViewById(R.id.danceRecycler);
        festivalRecycler = view.findViewById(R.id.festivalRecycler);
        announcementRecycler = view.findViewById(R.id.announcementRecycler);
        seminarsRecycler = view.findViewById(R.id.seminarsRecycler);
        sportsRecycler = view.findViewById(R.id.sportsRecycler);
        healthRecycler = view.findViewById(R.id.healthRecycler);
        contestRecycler = view.findViewById(R.id.contestRecycler);
        guestRecycler = view.findViewById(R.id.guestRecycler);
        socialRecycler = view.findViewById(R.id.socialRecycler);
        communityRecycler = view.findViewById(R.id.communityRecycler);
        careerRecycler = view.findViewById(R.id.careerRecycler);
        musicRecycler = view.findViewById(R.id.musicRecycler);


        reference = FirebaseDatabase.getInstance().getReference().child("gallery");
        getOtherImage();
        getIndImage();
        webinars();
        jobs();
        cultural();
        classes();
        dance();
        festival();
        announcement();
        seminar();
        sports();
        health();
        contest();
        guest();
        social();
        community();
        carrer();
        music();


        return view;
    }

    private void music() {
        reference.child("Music Events").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                musicRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                musicRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void carrer() {
        reference.child("Career Development").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                careerRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                careerRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void community() {
        reference.child("Community Service").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                communityRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                communityRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void social() {
        reference.child("Social Gatherings").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                socialRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                socialRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void guest() {
        reference.child("Guest Lectures").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                guestRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                guestRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void contest() {
        reference.child("Contests").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                contestRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                contestRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void health() {

        reference.child("Health and Wellness").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                healthRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                healthRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sports() {
        reference.child("Sports Event").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                sportsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                sportsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void seminar() {
        reference.child("Seminars").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                seminarsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                seminarsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void announcement() {
        reference.child("Announcement").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                announcementRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                announcementRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void festival() {
        reference.child("Festivals").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                festivalRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                festivalRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dance() {
        reference.child("Dance").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                danceRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                danceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void classes() {
        reference.child("Classes").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                classesRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                classesRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cultural() {
        reference.child("Cultural fest").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                culturalRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                culturalRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void jobs() {
        reference.child("Job Fair").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                jobRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                jobRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void webinars() {
        reference.child("Webinars").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                webinarRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                webinarRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getOtherImage() {
        reference.child("Others").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIndImage() {
        reference.child("Independence day").addValueEventListener(new ValueEventListener() {
            List<String> imagesList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.getValue() instanceof String) {
                        String data = (String) snapshot.getValue();
                        imagesList.add(data);
                    } else {

                        Log.d("GalleryFragment", "Unexpected data type: " + snapshot.getValue().getClass().getSimpleName());
                    }
                }
                adapter = new GalleryAdapter(getContext(), imagesList);
                independenceRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                independenceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}