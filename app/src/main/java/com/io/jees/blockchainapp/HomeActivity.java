package com.io.jees.blockchainapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import com.io.jees.blockchainapp.fragment.HomeFragment;

/**
 * It is new layout activity used fragment
 */
public class HomeActivity extends AppCompatActivity {

    private static final String EXTRA_EDIT = "EDIT";

    public static void start(Activity activity, Boolean edit) {
        Intent starter = new Intent(activity, HomeActivity.class);
        starter.putExtra(EXTRA_EDIT, edit);

        ActivityCompat.startActivity(activity, starter, ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle());               // animation of material design
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String string = "The test fragment for new layout";

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_container, HomeFragment.newInstance(string, string)).commit();
    }
}
