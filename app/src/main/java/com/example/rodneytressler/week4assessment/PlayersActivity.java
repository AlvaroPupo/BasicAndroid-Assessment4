package com.example.rodneytressler.week4assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.rodneytressler.week4assessment.MainActivity.PLAYER_INFO;

public class PlayersActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private List<Player> playerList;

    private PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);

        recyclerView = findViewById(R.id.recycler_view);

        playerList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        playerList = bundle.getParcelableArrayList(PLAYER_INFO);

        populateRecyclerView();
    }

    private void populateRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        adapter = new PlayerAdapter(playerList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.notifyDataSetChanged();

    }
}
