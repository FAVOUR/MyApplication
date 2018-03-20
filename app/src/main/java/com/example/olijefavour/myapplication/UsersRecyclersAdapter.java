package com.example.olijefavour.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Olije favour on 3/11/2018.
 */

public class UsersRecyclersAdapter extends RecyclerView.Adapter<UsersRecyclersAdapter.ViewHolder> {
    private List<Users> usersList;
    private Context context;
    public UsersRecyclersAdapter(Context context, List<Users>usersList){
        this.usersList=usersList;
        this.context=context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      holder.user_name_view.setText(usersList.get(position).getName());
    }

    @Override
    public int getItemCount() {

        return usersList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private TextView user_name_view;
        public ViewHolder(View itemView) {
            super(itemView);

            user_name_view=(TextView)mView.findViewById(R.id.all_userss);
        }
    }


}
