package com.mcs.easysocialsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SocialAppAdapter extends RecyclerView.Adapter<SocialAppViewHolder>
{

    private List<SocialApp> list;
    private final List<SocialApp> filteredList;
    private Context mContext;

    public SocialAppAdapter(Context context, List<SocialApp> list) {
        this.list = list;
        this.mContext = context;
        this.filteredList = new ArrayList<>();
    }

    @Override
    public SocialAppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_social_apps, null);
        SocialAppViewHolder mh = new SocialAppViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SocialAppViewHolder ViewHolder, int i) {
        SocialApp model = list.get(i);
        ViewHolder.icon.setImageDrawable(model.getSocial_icon());
        ViewHolder.title.setText(model.getSocial_title());
        ViewHolder.installed.setText(model.getSocial_installed());
        ViewHolder.version.setText(model.getSocial_version());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void remove(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }
    public void clearData() {
        int size = this.list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.list.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }
    public void add(SocialApp model, int position) {
        list.add(position, model);
        notifyItemInserted(position);
    }
    public void animateTo(List<SocialApp> model) {
        applyAndAnimateRemovals(model);
        applyAndAnimateAdditions(model);
        applyAndAnimateMovedItems(model);
    }

    private void applyAndAnimateRemovals(List<SocialApp> newModel) {
        for (int i = list.size() - 1; i >= 0; i--) {
            final SocialApp model = list.get(i);
            if (!newModel.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<SocialApp> newModel) {
        for (int i = 0, count = newModel.size(); i < count; i++) {
            final SocialApp model = newModel.get(i);
            if (!list.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<SocialApp> newModel) {
        for (int toPosition = newModel.size() - 1; toPosition >= 0; toPosition--) {
            final SocialApp model = newModel.get(toPosition);
            final int fromPosition = list.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public SocialApp removeItem(int position) {
        final SocialApp model = list.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, SocialApp model) {
        list.add(position, model);
        notifyItemInserted(position);

    }

    public void moveItem(int fromPosition, int toPosition) {
        final SocialApp model = list.remove(fromPosition);
        list.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
}