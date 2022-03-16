package ma.emsi.recycle1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import ma.emsi.recycle1.R;
import ma.emsi.recycle1.beans.Fruit;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitHolder> {
    private List<Fruit> fruits;
    private LayoutInflater inflater;
    private Context cxt;

    public FruitAdapter(Context cxt, List<Fruit> fruits) {
        this.fruits = fruits;
        this.cxt = cxt;
        this.inflater = LayoutInflater.from(cxt);
    }

    @NonNull
    @Override
    public FruitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item, parent, false);
        return new FruitHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitHolder holder, int position) {
        holder.id.setText(fruits.get(position).getId()+"");
        holder.nom.setText(fruits.get(position).getNom());
        holder.prix.setText(fruits.get(position).getPrix()+"");
        Glide.with(cxt)
                .load(fruits.get(position).getImage())
                .centerCrop()
                .apply(new RequestOptions().override(100, 100))
                .into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class FruitHolder extends RecyclerView.ViewHolder {
        TextView id, nom, prix;
        ImageView photo;
        public FruitHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            nom = itemView.findViewById(R.id.nom);
            prix = itemView.findViewById(R.id.prix);
            photo = itemView.findViewById(R.id.photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(cxt, id.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
