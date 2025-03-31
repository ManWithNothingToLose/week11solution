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

public class PlayerFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlayerAdapter adapter;
    private List<Player> allPlayers;
    private PlayerRepository repository;

    public PlayerFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_fragment, container, false);

        recyclerView = view.findViewById(R.id.playerRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        allPlayers = DataProvider.createSamplePlayers();
        repository = new PlayerRepository(allPlayers);
        adapter = new PlayerAdapter(allPlayers);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void filter(String query) {
        List<Player> filtered = allPlayers.stream()
                .filter(player -> player.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
        adapter.updateList(filtered);
    }
}
