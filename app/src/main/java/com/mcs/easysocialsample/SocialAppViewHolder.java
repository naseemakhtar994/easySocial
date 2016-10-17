package com.mcs.easysocialsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialAppViewHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.social_app_title) TextView title;

    public SocialAppViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(SocialApp model) {
        title.setText(model.getSocial_title());
    }
}