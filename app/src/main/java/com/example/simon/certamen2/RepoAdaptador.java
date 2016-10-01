package com.example.simon.certamen2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
/**
 * Created by simon on 30-09-2016.
 */

public class RepoAdaptador extends RecyclerView.Adapter<RepoAdaptador.ViewHolder> {

    private List<User> dataSet;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = dataSet.get(position);
        holder.tituloView.setText(user.getName());
        holder.descripView.setText(user.getDescription());
        holder.updatedView.setText(user.getUpdated_at());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tituloView;
        public TextView descripView;
        public TextView updatedView;

        public ViewHolder(View v) {
            super(v);
            tituloView = (TextView) v.findViewById(R.id.textName);
            descripView = (TextView) v.findViewById(R.id.textDescrip);
            updatedView = (TextView)v.findViewById(R.id.textUpdated);
        }

    }

   public RepoAdaptador(List<User> dataSet){this.dataSet = dataSet;}


}
