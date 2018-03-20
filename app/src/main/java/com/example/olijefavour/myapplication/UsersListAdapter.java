package com.example.olijefavour.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Olije favour on 3/13/2018.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

    public List<Users> usersList;

    public UsersListAdapter(List<Users> usersList){

        this.usersList= usersList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       final Context context =holder.mView.getContext();
       final String userName=usersList.get(position).getName();
        final String userId=usersList.get(position).userId;
                holder.nameText.setText(userName);
        holder.mView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                Intent sendIntent =new Intent(context,SendActivity.class);
                 sendIntent.putExtra("Username",userName );
                sendIntent.putExtra("UserId",userId );
                context.startActivity(sendIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();

    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
       View mView;
        public TextView nameText;
        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;

            nameText=(TextView)mView.findViewById(R.id.all_userss);




        }
    }
}
