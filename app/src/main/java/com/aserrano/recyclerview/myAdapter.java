package com.aserrano.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>{

    ArrayList<String> listDatos;

    public myAdapter(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView dato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.idDato);
            itemView.setOnClickListener(this);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }

        @Override
        public void onClick(View view) {
            dato.setText("Clicked! " + dato.getText());
        }
    }
}
