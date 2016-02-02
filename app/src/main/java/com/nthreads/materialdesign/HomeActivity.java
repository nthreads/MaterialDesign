package com.nthreads.materialdesign;

import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Drawerlayout switch indicator that the icon leftmost Toolbar
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.lbl_open, R.string.lbl_close);
        mActionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);

        // Set navigation item selected listener
        navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                String msgString = "";

                switch (menuItem.getItemId()) {
                    case R.id.navItemHome:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.navItemProfile:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.navItemInBox:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.navItemSetting:
                        msgString = (String) menuItem.getTitle();
                        break;
                    case R.id.navItemLogout:
                        msgString = (String) menuItem.getTitle();
                        break;
                }

                // Menu item clicked on, and close Drawerlayout
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                Toast.makeText(getApplicationContext(), msgString, Toast.LENGTH_LONG).show();

                return true;
            }
        });


        float scale =  getApplicationContext().getResources().getDisplayMetrics().density;
        Toast.makeText(getApplicationContext(), getDensity(scale), Toast.LENGTH_LONG).show();
    }


    private String getDensity(float scale) {
        if (scale == 0.75f)
            return "Low Density : ldpi";
        if (scale == 1.0f)
            return "Medium Density : mdpi";
        if (scale == 1.5f)
            return "High Density : hdpi";
        if (scale == 2.0f)
            return "Extra High Density : xhpi";
        if (scale == 3.0f)
            return "Double Extra High Density : xxhpi";
        if (scale == 4.0f)
            return "Triple Extra High Density : xxxhpi";

        else
            return "Not detected :  scale : " + scale;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_sort) {
            Toast.makeText(this, "You clicked on sort", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_search) {
            Toast.makeText(this, "You clicked on search", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

