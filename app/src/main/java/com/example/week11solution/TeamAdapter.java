package com.example.week11solution;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder>


 {


    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    public void updateList(List<Team> newList) {
        this.teamList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.name.setText(team.getName());
        holder.league.setText(team.getLeague());
        holder.stadium.setText(team.getStadium());
        holder.foundedYear.setText(String.valueOf(team.getFoundedYear()));
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView name, league, stadium, foundedYear;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teamName);
            league = itemView.findViewById(R.id.teamLeague);
            stadium = itemView.findViewById(R.id.teamStadium);
            foundedYear = itemView.findViewById(R.id.teamFoundedYear);
        }
    }
}
