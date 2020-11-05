package com.example.fragmentapp.Model;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentapp.EditData;
import com.example.fragmentapp.MainActivity;
import com.example.fragmentapp.R;
import com.example.fragmentapp.RegisterActivityLab5;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserModel> itemList1;
    private Context context;

    public UserAdapter(List<UserModel> itemList,Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, final int position) {

        // holder.itemImage.setImageResource(itemList1.get(position).getImage());
        holder.itemtxt.setText(itemList1.get(position).getEmail());
        holder.itemUsername.setText(itemList1.get(position).getUsername());
        holder.itemtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToLogin = new Intent(context, EditData.class);
                moveToLogin.putExtra("IDedit",itemList1.get(position).getEmail());
                context.startActivity(moveToLogin);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemtxt,itemUsername;
        LinearLayout linearLayout;
        Button itemtBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemtxt=itemView.findViewById(R.id.itemName);
            itemtBtn=itemView.findViewById(R.id.EditBtn);
            itemUsername=itemView.findViewById(R.id.itemUsername);
            linearLayout=itemView.findViewById(R.id.layout_id);

        }
    }
}