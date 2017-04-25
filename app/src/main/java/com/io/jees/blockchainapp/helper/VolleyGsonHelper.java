package com.io.jees.blockchainapp.helper;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.io.jees.blockchainapp.model.BlockchainData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Based on input streaming web, JSON parsing helper class used Gson, Volley
 * It is singleton class for volley-network need to one context
 */

public class VolleyGsonHelper {
    private static final String TAG = "VolleyGsonHelper";

    private static VolleyGsonHelper mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    public static final String urlSingleBlockApi = "https://blockchain.info/ko/rawblock/";                        // https://blockchain.info/ko/rawblock/$block_hash
    public static final String urlSingleTransactionApi = "https://blockchain.info/ko/rawtx/";                     // https://blockchain.info/ko/rawtx/$tx_hash

    private VolleyGsonHelper(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyGsonHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyGsonHelper(context);
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


    /**
     * Stored and parse model used Gson from web(JSON) with Volley
     *
     * @param hash The string of Hash value
     */
    public void getSingleBlock(String hash) {
        RequestQueue queue = Volley.newRequestQueue(mContext);

        String url = urlSingleBlockApi + hash;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d(TAG, "Response " + response);

                // JSON parsing used GSON
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                List<BlockchainData> datas = new ArrayList<BlockchainData>();
                datas = Arrays.asList(mGson.fromJson(response, BlockchainData.class));

                //Log.d(TAG, "size " + posts.get(0).getSize());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
