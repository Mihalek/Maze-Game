package mihalek.mazegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StatsChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_choose);
    }

    public void button1(View view) {
        Intent leaderboard = new Intent(StatsChoose.this, leaderboard.class);
        leaderboard.putExtra("lvlflag", 1);
        startActivity(leaderboard);

    }
    public void button2(View view) {
        Intent leaderboard = new Intent(StatsChoose.this, leaderboard.class);
        leaderboard.putExtra("lvlflag", 2);
        startActivity(leaderboard);
    }
    public void button3(View view) {
        Intent leaderboard = new Intent(StatsChoose.this, leaderboard.class);
        leaderboard.putExtra("lvlflag", 3);
        startActivity(leaderboard);
    }
    public void button4(View view) {
        Intent leaderboard = new Intent(StatsChoose.this, leaderboard.class);
        leaderboard.putExtra("lvlflag", 4);
        startActivity(leaderboard);
    }

    public void clean(View view) {

        SharedPreferences sharedPreferences1 = getSharedPreferences("PREFS1",0);
        sharedPreferences1.edit().clear().commit();
        SharedPreferences sharedPreferences2 = getSharedPreferences("PREFS2",0);
        sharedPreferences2.edit().clear().commit();
        SharedPreferences sharedPreferences3 = getSharedPreferences("PREFS3",0);
        sharedPreferences3.edit().clear().commit();
        SharedPreferences sharedPreferences4 = getSharedPreferences("PREFS4",0);
        sharedPreferences4.edit().clear().commit();
    }
}
