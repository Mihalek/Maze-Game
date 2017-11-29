package mihalek.mazegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void startGame(View view) {
        Intent selectLevel = new Intent(MainActivity.this, LevelSelection.class);
        startActivity(selectLevel);
    }

    public void showStats(View view) {
        Intent statschoose = new Intent(MainActivity.this, StatsChoose.class);
        startActivity(statschoose);

    }

    public void quitApp(View view) {
        finish();
    }
}
