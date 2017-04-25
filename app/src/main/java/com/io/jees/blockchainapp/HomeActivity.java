package com.io.jees.blockchainapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import com.io.jees.blockchainapp.fragment.HomeFragment;
import com.io.jees.blockchainapp.helper.VolleyGsonHelper;

/**
 * It is new layout activity used fragment
 */
public class HomeActivity extends AppCompatActivity {

    private static final String EXTRA_EDIT = "EDIT";

    final Context mContext = this;

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
        String hash = "0000000000000bae09a7a393a8acded75aa67e46cb81f7acaa5ad94f9eacd103";

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_container, HomeFragment.newInstance(string, string)).commit();

        VolleyGsonHelper.getInstance(mContext).getSingleBlock(hash);
    }
}
