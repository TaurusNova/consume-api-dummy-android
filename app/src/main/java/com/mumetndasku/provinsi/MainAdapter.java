package com.mumetndasku.provinsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context context;
    public ArrayList<UserItem> listUser;

    public MainAdapter(Context context, ArrayList<UserItem> listUser){
        this.context = context;
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, final int position) {
        holder.txtName.setText(listUser.get(position).getName());
        holder.txtUsername.setText(listUser.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView txtName;
        @BindView(R.id.username)
        TextView txtUsername;

        public MainViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
