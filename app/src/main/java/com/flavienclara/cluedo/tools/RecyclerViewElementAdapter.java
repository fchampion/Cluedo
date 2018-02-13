package com.flavienclara.cluedo.tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.flavienclara.cluedo.R;
import com.flavienclara.cluedo.classes.Element;


public class RecyclerViewElementAdapter extends RecyclerView.Adapter<RecyclerViewElementAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(Element item);
    }

    private final ArrayList<Element> items;
    private final OnItemClickListener listener;

    public RecyclerViewElementAdapter(ArrayList<Element> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_element, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        //private TextView categorie;
        private TextView elem;

        public ViewHolder(View itemView) {
            super(itemView);
            //categorie = (TextView) itemView.findViewById(R.id.libelle_categorie);
            elem = (TextView) itemView.findViewById(R.id.libelle_element);
        }

        public void bind(final Element item, final OnItemClickListener listener) {
            //categorie.setText(String.valueOf(item.getCategorieId()));
            elem.setText(item.getNom());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}