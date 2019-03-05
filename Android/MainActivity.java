package com.beanfactory.yp.ibms;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView mNavigationView = findViewById(R.id.navigation_view);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar_main);

        collapsingToolbarLayout.setExpandedTitleColor(getColor(R.color.color_white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getColor(R.color.color_white));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_main));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here
                switch (item.getItemId()) {
                    case R.id.aboutMenuId:
                        Toast.makeText(getApplicationContext(), "Form", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, RequirementForm.class));

                }

                return true;

            }
        });
    }
}
