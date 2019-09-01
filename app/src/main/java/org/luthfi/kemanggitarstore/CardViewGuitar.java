package org.luthfi.kemanggitarstore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewGuitar extends RecyclerView.Adapter<CardViewGuitar.ViewHolder>{
    private ArrayList<Guitar> listGuitar;

    public CardViewGuitar (ArrayList<Guitar> listGuitar){
        this.listGuitar = listGuitar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_info, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {

        final Guitar guitar = listGuitar.get(i);
        Glide.with(holder.itemView.getContext())
                .load(guitar.getPhoto())
                .apply(new RequestOptions().override(800,800))
                .into(holder.imgPhoto);

        holder.tvBrand.setText(guitar.getInfo());
        holder.tvPrice.setText((guitar.getPrice()));
        holder.tvDeskripsi.setText(guitar.getDeskripsi());

        holder.card_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Detail.class);
                Detail detail = new Detail();
                intent.putExtra(detail.EXTRA_GAMBAR, guitar.getPhoto());
                intent.putExtra(detail.EXTRA_INFO, guitar.getInfo());
                intent.putExtra(detail.EXTRA_PRICE, guitar.getPrice());
                intent.putExtra(detail.EXTRA_DESKRIPSI, guitar.getDeskripsi());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listGuitar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_View;
        ImageView imgPhoto;
        TextView tvBrand, tvPrice, tvDeskripsi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_foto);
            tvBrand = itemView.findViewById(R.id.tv_item_name);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
            tvDeskripsi = itemView.findViewById(R.id.tv_item_desc);
            card_View = itemView.findViewById(R.id.card_view);
        }
    }
}
