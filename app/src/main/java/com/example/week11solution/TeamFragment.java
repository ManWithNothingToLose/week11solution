package com.example.week11solution;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

public class TeamFragment extends Fragment {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private List<Team> allTeams;
    private TeamRepository repository;

    public TeamFragment() {
        // Required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);

        recyclerView = view.findViewById(R.id.teamRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        allTeams = DataProvider.createSampleTeams();
        repository = new TeamRepository(allTeams);
        adapter = new TeamAdapter(allTeams);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // 🔍 Called by MainActivity during text change
    public void filter(String query) {
        List<Team> filtered = allTeams.stream()
                .filter(team -> team.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateList(filtered);
    }
}
