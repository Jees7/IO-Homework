package com.io.jees.blockchainapp.adapter;


import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.io.jees.blockchainapp.R;
import com.io.jees.blockchainapp.model.Block;

import java.util.List;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.ViewHolder> {

    private final Activity mActivity;
    private final Resources mResources;
    private final String mPackageName;
    private final LayoutInflater mLayoutInflater;
    private List<Block> mBlocks;

    public LatestAdapter(Activity activity) {
        mActivity = activity;
        mResources = mActivity.getResources();
        mPackageName = mActivity.getPackageName();
        mLayoutInflater = LayoutInflater.from(activity.getApplicationContext());
        //mBlocks = blocks;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latest_block, parent, false);
        return new ViewHolder(view);

        /* return new ViewHolder((ItemCategoryBinding) DataBindingUtil
                .inflate(mLayoutInflater, R.layout.item_category, parent, false)); */
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textHeight.setText("10");
        holder.textHash.setText("10xasdf");
        holder.textRelay.setText("KBCard");
    }

    @Override
    public int getItemCount() {
        return mBlocks.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textHeight;
        private TextView textHash;
        private TextView textRelay;

        public ViewHolder(View view) {
            super(view);

            textHeight = (TextView) view.findViewById(R.id.block_height);
            textHash = (TextView) view.findViewById(R.id.block_hash);
            textRelay = (TextView) view.findViewById(R.id.block_from_relay);
        }
    }

}
