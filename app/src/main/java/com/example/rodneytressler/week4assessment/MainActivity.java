package com.example.rodneytressler.week4assessment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    private List<Player> playerList;

    public static final String PLAYER_INFO = "player_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        playerList = new ArrayList<>();
    }

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {

    try {
        if (TextUtils.isEmpty(nameInput.getText()) || TextUtils.isEmpty(teamInput.getText()) || TextUtils.isEmpty(numberInput.getText())) {
            Toast.makeText(this, "failed to register, please enter all the information", Toast.LENGTH_SHORT).show();

        } else {
            String nameInputString = nameInput.getText().toString();
            String teamInputString = teamInput.getText().toString();
            String numberInputString = numberInput.getText().toString();

            Player player = new Player(nameInputString, teamInputString, numberInputString);
            playerList.add(player);
            Toast.makeText(this, "player successfully added to the list", Toast.LENGTH_SHORT).show();
            nameInput.setText("");
            numberInput.setText("");
            teamInput.setText("");
        }
    }catch (Exception e){
        Toast.makeText(this, "There was an error, please try again", Toast.LENGTH_SHORT).show();
    }
    }

    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {

        if(playerList.isEmpty()){
            Toast.makeText(this, "please add a player before you watch the list", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, PlayersActivity.class);
            intent.putParcelableArrayListExtra(PLAYER_INFO, (ArrayList<? extends Parcelable>) playerList);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you would like to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
    }
}
