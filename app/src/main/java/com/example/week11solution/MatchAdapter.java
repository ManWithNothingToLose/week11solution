package com.example.week11solution;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList;

    public MatchAdapter(List<Match> matchList) {
        this.matchList = matchList;
    }

    public void updateList(List<Match> newList) {
        this.matchList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchList.get(position);
        holder.home.setText(match.getHomeTeam());
        holder.away.setText(match.getAwayTeam());
        holder.score.setText(match.getScore());
        holder.league.setText(match.getLeague());
        holder.stadium.setText(match.getStadium());
        holder.date.setText(match.getDate());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView home, away, score, league, stadium, date;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            home = itemView.findViewById(R.id.matchHome);
            away = itemView.findViewById(R.id.matchAway);
            score = itemView.findViewById(R.id.matchScore);
            league = itemView.findViewById(R.id.matchLeague);
            stadium = itemView.findViewById(R.id.matchStadium);
            date = itemView.findViewById(R.id.matchDate);
        }
    }
}
