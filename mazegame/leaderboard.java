package mihalek.mazegame;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class leaderboard extends AppCompatActivity {

    TextView wynik1;
    int lvlvalue;
    int lvlflag;

    float best1,best2,best3, lastscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        lvlflag = 0;
        wynik1 = (TextView) findViewById(R.id.wynik1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lvlvalue = extras.getInt("lvlvalue");
            lvlflag = extras.getInt("lvlflag");
        }
        if (lvlvalue == 1 || lvlflag ==1) {
            SharedPreferences sharedPreferences1 = getSharedPreferences("PREFS1", 0);
            lastscore = sharedPreferences1.getFloat("LastScore1", 0);
            best1 = sharedPreferences1.getFloat("best1", 9999);
            best2 = sharedPreferences1.getFloat("best2", 9999);
            best3 = sharedPreferences1.getFloat("best3", 9999);
            if (lvlflag == 0) {
                if (lastscore < best3) {
                    best3 = lastscore;
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putFloat("best3", best3);
                    editor.apply();
                }
                if (lastscore < best2) {
                    float temp = best2;
                    best2 = lastscore;
                    best3 = temp;
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putFloat("best3", best3);
                    editor.putFloat("best2", best2);
                    editor.apply();
                }
                if (lastscore < best1) {
                    float temp = best1;
                    best1 = lastscore;
                    best2 = temp;
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.putFloat("best2", best2);
                    editor.putFloat("best1", best1);
                    editor.apply();
                }
            }
            if (best1 == 9999) {
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + 0.0 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best2 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best3 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + 0.0);
            }
            else{
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + best3);
            }
        }

        if (lvlvalue == 2 || lvlflag ==2) {
            SharedPreferences sharedPreferences2 = getSharedPreferences("PREFS2", 0);
            lastscore = sharedPreferences2.getFloat("LastScore2", 0);
            best1 = sharedPreferences2.getFloat("best1", 9999);
            best2 = sharedPreferences2.getFloat("best2", 9999);
            best3 = sharedPreferences2.getFloat("best3", 9999);
            if(lvlflag == 0) {
                if (lastscore < best3) {
                    best3 = lastscore;
                    SharedPreferences.Editor editor = sharedPreferences2.edit();
                    editor.putFloat("best3", best3);
                    editor.apply();
                }
                if (lastscore < best2) {
                    float temp = best2;
                    best2 = lastscore;
                    best3 = temp;
                    SharedPreferences.Editor editor = sharedPreferences2.edit();
                    editor.putFloat("best3", best3);
                    editor.putFloat("best2", best2);
                    editor.apply();
                }
                if (lastscore < best1) {
                    float temp = best1;
                    best1 = lastscore;
                    best2 = temp;
                    SharedPreferences.Editor editor = sharedPreferences2.edit();
                    editor.putFloat("best2", best2);
                    editor.putFloat("best1", best1);
                    editor.apply();
                }
            }

            if (best1 == 9999) {
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + 0.0 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best2 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best3 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + 0.0);
            }
            else{
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + best3);
            }
        }

        if (lvlvalue == 3 || lvlflag ==3) {
            SharedPreferences sharedPreferences3 = getSharedPreferences("PREFS3", 0);
            lastscore = sharedPreferences3.getFloat("LastScore3", 0);
            best1 = sharedPreferences3.getFloat("best1", 9999);
            best2 = sharedPreferences3.getFloat("best2", 9999);
            best3 = sharedPreferences3.getFloat("best3", 9999);
            if(lvlflag == 0) {
                if (lastscore < best3) {
                    best3 = lastscore;
                    SharedPreferences.Editor editor = sharedPreferences3.edit();
                    editor.putFloat("best3", best3);
                    editor.apply();
                }
                if (lastscore < best2) {
                    float temp = best2;
                    best2 = lastscore;
                    best3 = temp;
                    SharedPreferences.Editor editor = sharedPreferences3.edit();
                    editor.putFloat("best3", best3);
                    editor.putFloat("best2", best2);
                    editor.apply();
                }
                if (lastscore < best1) {
                    float temp = best1;
                    best1 = lastscore;
                    best2 = temp;
                    SharedPreferences.Editor editor = sharedPreferences3.edit();
                    editor.putFloat("best2", best2);
                    editor.putFloat("best1", best1);
                    editor.apply();
                }
            }

            if (best1 == 9999) {
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + 0.0 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best2 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best3 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + 0.0);
            }
            else{
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + best3);
            }
        }


        if (lvlvalue == 4 || lvlflag ==4) {
            SharedPreferences sharedPreferences4 = getSharedPreferences("PREFS4", 0);
            lastscore = sharedPreferences4.getFloat("LastScore4", 0);
            best1 = sharedPreferences4.getFloat("best1", 9999);
            best2 = sharedPreferences4.getFloat("best2", 9999);
            best3 = sharedPreferences4.getFloat("best3", 9999);
            if(lvlflag == 0) {
                if (lastscore < best3) {
                    best3 = lastscore;
                    SharedPreferences.Editor editor = sharedPreferences4.edit();
                    editor.putFloat("best3", best3);
                    editor.apply();
                }
                if (lastscore < best2) {
                    float temp = best2;
                    best2 = lastscore;
                    best3 = temp;
                    SharedPreferences.Editor editor = sharedPreferences4.edit();
                    editor.putFloat("best3", best3);
                    editor.putFloat("best2", best2);
                    editor.apply();
                }
                if (lastscore < best1) {
                    float temp = best1;
                    best1 = lastscore;
                    best2 = temp;
                    SharedPreferences.Editor editor = sharedPreferences4.edit();
                    editor.putFloat("best2", best2);
                    editor.putFloat("best1", best1);
                    editor.apply();
                }

                if (best1 == 9999) {
                    wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                            "BEST1: " + 0.0 + "\n" +
                            "BEST2: " + 0.0 + "\n" +
                            "BEST3: " + 0.0);
                }
                else if (best2 == 9999){
                    wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                            "BEST1: " + best1 + "\n" +
                            "BEST2: " + 0.0 + "\n" +
                            "BEST3: " + 0.0);
                }
                else if (best3 == 9999){
                    wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                            "BEST1: " + best1 + "\n" +
                            "BEST2: " + best2 + "\n" +
                            "BEST3: " + 0.0);
                }
                else{
                    wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                            "BEST1: " + best1 + "\n" +
                            "BEST2: " + best2 + "\n" +
                            "BEST3: " + best3);
                }




            }

            if (best1 == 9999) {
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + 0.0 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best2 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + 0.0 + "\n" +
                        "BEST3: " + 0.0);
            }
            else if (best3 == 9999){
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + 0.0);
            }
            else{
                wynik1.setText("LAST SCORE: " + lastscore + "\n" +
                        "BEST1: " + best1 + "\n" +
                        "BEST2: " + best2 + "\n" +
                        "BEST3: " + best3);
            }
        }



    }

    public void Click(View view) {
        Intent mainactivity = new Intent(leaderboard.this, MainActivity.class);
        startActivity(mainactivity);
    }
}
