package com.example.notifications_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notifications_recyclerview.databinding.CustomUserItemBinding;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder>{

    private ArrayList<User>users; //Array für nutznamen
    private OnUserClickListener listener;
    public UsersAdapter(ArrayList<User> users ,OnUserClickListener listener) {
        this.users = users;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // verknüpfen mit custom_user_item
        return new UserHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_user_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = users.get(position); // position eines nutzers
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserHolder extends RecyclerView.ViewHolder{
       private User user;
        CustomUserItemBinding binding;
        public UserHolder(@NonNull View itemView) {
            super(itemView);

            binding = CustomUserItemBinding.bind(itemView);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onUserclicklistener(user);
                }
            });
        }
        public void bind(User user){
            this.user = user;

            binding.userIv.setImageResource(user.getImage());
            binding.userTvName.setText(user.getName());
            binding.userTvEmail.setText(user.getEmail());
            binding.userTvSalary.setText(user.getSalary() + " $");
        }
    }

    interface OnUserClickListener{
        void onUserclicklistener(User user);
    }
}
