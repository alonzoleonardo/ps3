package com.miempresa.tareamodulo3petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReciclerViewAdaptador extends RecyclerView.Adapter<ReciclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView likes, nombre;
        private ImageView img, Like;

        public ViewHolder(View itemView) {
            super(itemView);
            likes = itemView.findViewById(R.id.tvLikes);
            nombre = itemView.findViewById(R.id.tvNombre);
            img = itemView.findViewById(R.id.ivMascota);

            Like = itemView.findViewById(R.id.imgLike);
        }
    }

    public List<MascotaModelo> mascotaLista;

    public ReciclerViewAdaptador(List<MascotaModelo> mascotaLista) {
        this.mascotaLista = mascotaLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(mascotaLista.get(position).getNombre());
        holder.likes.setText(String.valueOf(mascotaLista.get(position).getLikes()));
        holder.img.setImageResource(mascotaLista.get(position).getFotoMascota());

        holder.Like.setOnClickListener(v -> {
            int nl = mascotaLista.get(position).getLikes() + 1;
            mascotaLista.get(position).setLikes(nl);
            holder.likes.setText(String.valueOf(nl));
        });
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }
}
