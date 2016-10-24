package com.mcs.easysocialsample;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialAppViewHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.social_app_icon) ImageView icon;
    public @BindView(R.id.social_app_title) TextView title;
    public @BindView(R.id.social_app_installed) TextView installed;
    public @BindView(R.id.social_app_version) TextView version;

    public SocialAppViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(SocialApp model) {
        icon.setImageDrawable(model.getSocial_icon());
        title.setText(model.getSocial_title());
        installed.setText(model.getSocial_installed());
        version.setText(model.getSocial_version());
    }
}