package com.olegsagenadatrytwo.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_GALLERY = 1;
    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WebBrowersFragment webFragment = new WebBrowersFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main_view, webFragment, "home")
                .addToBackStack("home")
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(getSupportFragmentManager().getBackStackEntryCount()==1)
            finish();
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String who = "";
        Fragment new_fragment = null;

        if (id == R.id.nav_camera) {

            Intent gallery = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(gallery, REQUEST_GALLERY);

        } else if (id == R.id.nav_gallery) {

            Intent gallery = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallery, REQUEST_GALLERY);

        } else if (id == R.id.nav_calculator) {
            who = "calculator";
            new_fragment = new CalculatorFragment();

        } else if (id == R.id.nav_browser_home) {
            who = "home";
            new_fragment = new WebBrowersFragment();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            for(int i=0;i<getSupportFragmentManager().getBackStackEntryCount();i++)
                Log.d(TAG, "onNavigationItemSelected: "+getSupportFragmentManager().getBackStackEntryAt(i).getName());
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fTransaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(who);

        if (fragment == null) {
            fTransaction.replace(R.id.content_main_view, new_fragment, who).addToBackStack(who).commit();
            Toast.makeText(this, "Brand New", Toast.LENGTH_SHORT).show();
        } else {
            if (!fragment.isAdded()) {
                ArrayList<String> list = new ArrayList<>();

                for (int i = 0; i < manager.getBackStackEntryCount(); i++) {
                    Log.d(TAG, "onNavigationItemSelected: " + manager.getBackStackEntryAt(i).getName());
                    list.add(manager.getBackStackEntryAt(i).getName());
                    //                if(manager.getBackStackEntryAt(i).getName().equals("2"))
                    //                    list.add("2");
                    //                else
                    //                    list.add("1");
                }

                while (manager.getBackStackEntryCount() > 0) {
                    manager.popBackStackImmediate();
                }
                Log.d(TAG, "onNavigationItemSelected: SIZEEEEEEEEE " + list.size());
                for (int i = 0; i < list.size(); i++) {
                    Fragment ft = null;
                    switch (list.get(i)) {
                        case "home":
                            ft = new WebBrowersFragment();
                            break;
                        case "calculator":
                            ft = new CalculatorFragment();
                            break;
                    }

                    if (!list.get(i).equals(who)) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main_view, ft, list.get(i)).addToBackStack(list.get(i)).commit();
                    }
                }
                fTransaction.replace(R.id.content_main_view, fragment, who).addToBackStack(who).commit();
                Toast.makeText(this, "adding existing", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "already on the Screen", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
