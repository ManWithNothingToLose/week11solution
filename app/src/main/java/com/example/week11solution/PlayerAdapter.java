package com.example.week11solution;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> playerList;

    public PlayerAdapter(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void updateList(List<Player> newList) {
        playerList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.name.setText(player.getName());
        holder.position.setText(player.getPosition());
        holder.age.setText(String.valueOf(player.getAge()));
        holder.country.setText(player.getCountry());
        holder.team.setText(player.getTeam());
        holder.number.setText(String.valueOf(player.getNumber()));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, country, position, team, number;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.playerName);
            position = itemView.findViewById(R.id.playerPosition);
            age = itemView.findViewById(R.id.playerAge);
            country = itemView.findViewById(R.id.playerCountry);
            team = itemView.findViewById(R.id.playerTeam);
            number = itemView.findViewById(R.id.playerNumber);

        }
    }
}
