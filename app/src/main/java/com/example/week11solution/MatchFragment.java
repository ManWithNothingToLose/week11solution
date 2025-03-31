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

public class MatchFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchAdapter adapter;
    private List<Match> allMatches;
    private MatchRepository repository;

    public MatchFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_fragment, container, false);

        recyclerView = view.findViewById(R.id.matchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        allMatches = DataProvider.createSampleMatches();
        repository = new MatchRepository(allMatches);
        adapter = new MatchAdapter(allMatches);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void filter(String query) {
        List<Match> filtered = allMatches.stream()
                .filter(match -> match.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateList(filtered);
    }
}
