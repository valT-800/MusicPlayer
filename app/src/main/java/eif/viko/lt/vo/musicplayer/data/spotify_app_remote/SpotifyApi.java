package eif.viko.lt.vo.musicplayer.data.spotify_app_remote;

import android.content.Context;
import android.util.Log;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

public class SpotifyApi {

    private final String CLIENT_ID = "c56af55b9a38455684e6e706dbbcdb0a";
    private final String REDIRECT_URI = "http://localhost:8080/callback";
    private SpotifyAppRemote mySpotifyAppRemote;
    private Context context;

    public SpotifyApi(Context context) {
        this.context = context;
    }

    public SpotifyAppRemote connect() {
        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();

        SpotifyAppRemote.connect(context, connectionParams,
                new Connector.ConnectionListener() {

                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mySpotifyAppRemote = spotifyAppRemote;
                        Log.d("MainActivity", "Connected! Yay!");

                    }

                    public void onFailure(Throwable throwable) {
                        Log.e("MyActivity", throwable.getMessage(), throwable);

                        // Something went wrong when attempting to connect! Handle errors here
                    }
                });
        return mySpotifyAppRemote;
    }
}

