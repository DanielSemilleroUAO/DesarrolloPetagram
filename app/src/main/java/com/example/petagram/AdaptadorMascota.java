package com.example.petagram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMascota  extends  RecyclerView.Adapter<AdaptadorMascota.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public AdaptadorMascota(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRating.setText(String.valueOf(mascota.getRating()));

        if(mascota.getRating()>0){
            mascotaViewHolder.imgLike.setImageResource(R.drawable.icons8_dog_bone_100);
        }

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                int likes = mascota.getRating();
                likes+=1;
                mascotas.get(position).setRating(likes);
                mascotaViewHolder.tvRating.setText(String.valueOf(mascota.getRating()));
                mascotaViewHolder.imgLike.setImageResource(R.drawable.icons8_dog_bone_100);

                boolean favorito_esta = true;

                for(int i = 0; i < MainActivity.favoritos.size(); i++){
                    if(MainActivity.favoritos.get(i).getNombre() == mascota.getNombre()){
                        MainActivity.favoritos.get(i).setRating(likes);
                        favorito_esta = false;
                    }
                }
                if(favorito_esta){
                    MainActivity.cantidad_favoritos+=1;
                    MainActivity.btnFavoritos.setText(String.valueOf(MainActivity.cantidad_favoritos));
                    MainActivity.favoritos.add(new Mascota(mascota.getFoto(),mascota.getNombre(),mascota.getRating()));
                }


            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRating;
        private ImageButton btnLike;
        private ImageView imgLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.ImgMascota);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            btnLike = (ImageButton) itemView.findViewById(R.id.bnLike);
            imgLike = (ImageView) itemView.findViewById(R.id.imageRating);
        }
    }
}
