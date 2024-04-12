package P_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_cardview.InfoActivity;
import com.example.recycler_cardview.R;

import java.util.List;

import P_Model.Listitem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Listitem> listItems;

    // Konstrukteur
    public MyAdapter(Context context, List<Listitem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // verknüpfung mit xml layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent ,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Listitem listitem = listItems.get(position);
        holder.name.setText(listitem.getName());
        holder.descripion.setText(listitem.getDescription());
        holder.age.setText(listitem.getAge());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    // initialisieren von viewholder
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView descripion;
        private TextView age;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            descripion = itemView.findViewById(R.id.myinfo);
            age = itemView.findViewById(R.id.age);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Listitem item = listItems.get(position);

                    // Die daten mit intent in InfoActivity.class übertragen
                    Intent intent = new Intent(context, InfoActivity.class);
                    intent.putExtra("Name",item.getName());
                    intent.putExtra("Age",item.getAge());
                    intent.putExtra("Des",item.getDescription());
                    context.startActivity(intent);
                }
            });
        }
    }
}
