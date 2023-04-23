package ma.enset.contactlist_api_spring;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Contact> contacts;

    public RecyclerViewAdapter(Context context , ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_layout, parent , false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.baseline_person_24);
        Drawable drawable2 = ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.baseline_call_24);

        holder.nom.setText(contacts.get(position).getNom());
        holder.prenom.setText(contacts.get(position).getPrenom());
        holder.email.setText(contacts.get(position).getEmail());
        holder.tel.setText(contacts.get(position).getTel());
        holder.picView.setImageDrawable(drawable);
        holder.callView.setImageDrawable(drawable2);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView nom;
        TextView prenom;
        TextView email;
        TextView tel;
        ImageView picView;
        ImageView callView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nom = itemView.findViewById(R.id.nom);
            prenom = itemView.findViewById(R.id.prenom);
            email = itemView.findViewById(R.id.email);
            tel = itemView.findViewById(R.id.tel);
            picView = itemView.findViewById(R.id.picView);
            callView = itemView.findViewById(R.id.callView);

        }
    }
}
