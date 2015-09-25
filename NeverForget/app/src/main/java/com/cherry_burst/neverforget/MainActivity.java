package com.cherry_burst.neverforget;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    final String[] fragments = {
            "com.cherry_burst.neverforget.MysizeFragment",
            "com.cherry_burst.neverforget.PropertyFragment",
            "com.cherry_burst.neverforget.MemorialFragment",
    };
    private NavigationDrawerFragment mNavigationDrawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag", "-------------------1");
        setContentView(R.layout.activity_main);
        Log.d("tag", "-------------------2");
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        Log.d("tag", "-------------------3");
        // Set up the drawer.
        // 第一引数 アクティビティレイアウトのid
        // 第に引数 フラグメントUIを含むDrawerLayout
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        // FragmentTransaction replace(int containerViewId, Fragment fragment)
        // Fragment instantiate(Context context, String fname)
        fragmentManager.beginTransaction()
                .replace(R.id.container, Fragment.instantiate(MainActivity.this, fragments[position]))
                .commit();
    }
}
