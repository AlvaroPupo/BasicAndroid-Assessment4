package com.example.rodneytressler.week4assessment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodneytressler on 12/17/17.
 */

public class Player implements Parcelable{

    private String playerName;
    private String playerTeam;
    private String playerNumber;

    public Player(String playerName, String playerTeam, String playerNumber) {
        this.playerName = playerName;
        this.playerTeam = playerTeam;
        this.playerNumber = playerNumber;
    }

    protected Player(Parcel in) {
        playerName = in.readString();
        playerTeam = in.readString();
        playerNumber = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(playerName);
        dest.writeString(playerTeam);
        dest.writeString(playerNumber);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
