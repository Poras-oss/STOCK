package com.example.stock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // startActivity(new Intent(this,ShareDetailActivity.class));


        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Dashboard);
    }

    Dashboard dashboard = new Dashboard();
    Community community = new Community();
    Watchlist watchlist = new Watchlist();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Dashboard:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, dashboard)
                        .commit();
                return true;

            case R.id.Community:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, community)
                        .commit();
                return true;

            case R.id.Watchlist:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, watchlist)
                        .commit();
                return true;
        }
        return false;
    }
}