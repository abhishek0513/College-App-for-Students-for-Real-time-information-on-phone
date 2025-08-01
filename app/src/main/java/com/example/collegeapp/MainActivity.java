package com.example.collegeapp;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.SharedPreferencesKt;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.collegeapp.authentication.LoginActivity;
import com.example.collegeapp.ebook.EBookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private  int checkItem;
    private String selected ;

    private final String CHECKEDITEM = "check_item";

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        sharedPreferences = this.getSharedPreferences("themes", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        switch (getCheckItem()){
            case 0:
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case 2 :
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



        navigationView.setNavigationItemSelectedListener(this);


        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        if (item.getItemId()== R.id.logout){
            auth.signOut();
            openLogin();
        }
        return true;
    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser() == null){
            openLogin();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_video){
            String youtubeChannelUrl = "https://www.youtube.com/@shriramcollege";
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeChannelUrl));
            youtubeIntent.setPackage("com.google.android.youtube");
            try {
                startActivity(youtubeIntent);
            } catch (ActivityNotFoundException e) {
                // If the YouTube app is not installed, open the URL in a web browser
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeChannelUrl)));
            }
        }
        else if (item.getItemId() == R.id.navigation_developer){
            startActivity(new Intent(this, AboutDeveloperActivity.class));
        }
        else if (item.getItemId() == R.id.navigation_instagram){
            String instagramProfileUrl = "https://www.instagram.com/srcem.palwal";
            Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfileUrl));
            instagramIntent.setPackage("com.instagram.android"); // Instagram app package name
            try {
                startActivity(instagramIntent);
            } catch (ActivityNotFoundException e) {
                // If Instagram app is not installed, open URL in web browser
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfileUrl)));
            }
        }
        else if (item.getItemId() == R.id.navigation_website){
            String collegeWebsiteUrl = getString(R.string.college_website_url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(collegeWebsiteUrl));
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.navigation_facebook){
            String facebookPageUrl = "https://www.facebook.com/SRCEM.College";
            Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPageUrl));
            facebookIntent.setPackage("com.facebook.katana"); // Facebook app package name
            try {
                startActivity(facebookIntent);
            } catch (ActivityNotFoundException e) {
                // If Facebook app is not installed, open URL in web browser
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPageUrl)));
            }
        }
        else if (item.getItemId() == R.id.navigation_ebook){
            startActivity(new Intent(this, EBookActivity.class));
        }
        else if (item.getItemId() == R.id.navigation_theme){
                showdialog();
        }
        else if (item.getItemId() == R.id.navigation_university){
            String collegeWebsiteUrl = getString(R.string.university_website_url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(collegeWebsiteUrl));
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.navigation_result){
            String collegeWebsiteUrl = getString(R.string.result_url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(collegeWebsiteUrl));
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.navigation_result_report){
            String collegeWebsiteUrl = getString(R.string.result_report_url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(collegeWebsiteUrl));
            startActivity(intent);
        }



        return true;
    }

    private void showdialog() {

        String[] themes = this.getResources().getStringArray(R.array.theme);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Select Theme ");
        builder.setSingleChoiceItems(R.array.theme, getCheckItem(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                selected = themes[i];
                checkItem  = i;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (selected == null){
                    selected = themes[i];
                    checkItem = i;
                }


                switch (selected){
                    case "System Default" :
                        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM);
                                break;
                    case "Light" :
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                break;
                    case "Dark" :
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                break;
                }
                setCheckItem(checkItem);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private int getCheckItem(){
        return sharedPreferences.getInt(CHECKEDITEM, 0);
    }

    private void setCheckItem(int i){

        editor.putInt(CHECKEDITEM, i);
        editor.apply();
    }


}