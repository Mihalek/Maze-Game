package mihalek.mazegame;


import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;



public class GameView extends View {

    private Activity mActivity;
    private Ball mBall;
    private Level currLevel;
    long tStart;
    private Canvas mCanvas;
    private Paint mPaint;
    private boolean mWarning = true;
    private int mCanvasWidth = 0;
    private int mCanvasHeight = 0;

    private int currentLevel = 1;

    private SensorManager mSensorManager;
    private float mAccelX = 0;
    private float mAccelY = 0;

    private float mSensorBuffer = 0;

    private final SensorListener mSensorAccelerometer = new SensorListener() {
        @Override
        public void onSensorChanged(int sensor, float[] values) {
            mAccelX = values[0];
            mAccelY = values[1];
        }


        @Override
        public void onAccuracyChanged(int sensor, int accuracy) {

        }
    };

    public GameView(Context context, Activity activity,int level) {
        super(context);
        currentLevel = level;
        mActivity = activity;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        tStart= System.currentTimeMillis();
        mSensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorAccelerometer, SensorManager.SENSOR_ACCELEROMETER,SensorManager.SENSOR_DELAY_GAME);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCanvasHeight = h;
        mCanvasWidth = w;
        currLevel = new Level(mActivity,mCanvasHeight,mCanvasWidth);
        currLevel.setLevel(mActivity,currentLevel);
        mBall = new Ball(this);
        mBall.start();
    }

    @Override
    public void onDraw(Canvas canvas) {
        mCanvas = canvas;
        mPaint.setColor(Color.WHITE);
        mCanvas.drawRect(0,0,mCanvasWidth,mCanvasHeight,mPaint);
        currLevel.drawLevel(mCanvas,mPaint);
        if(mWarning) {
            mBall.draw(mCanvas,mPaint);
            moveBall();
        }
        invalidate();
    }

    public void moveBall() {

        if(mAccelX > mSensorBuffer || mAccelX < -mSensorBuffer)
            mBall.updateX(mAccelX);
        if(mAccelY > mSensorBuffer || mAccelY < -mSensorBuffer)
            mBall.updateY(mAccelY);

        if(currLevel.getWallType(mBall.getX(),mBall.getY()) == currLevel.wall){
            if(mBall.getLives() > 0) {
                mBall.setLives(mBall.getLives() - 1);
                mBall.start();
                //wait = true;
            }
            else {
                mWarning = false;
                Toast.makeText(mActivity.getApplicationContext(),"GAME OVER", Toast.LENGTH_LONG).show();
            }
        }
        else if(currLevel.getWallType(mBall.getX(),mBall.getY()) == currLevel.exit) {
            mWarning = false;
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            float elapsedSeconds = (float) (tDelta / 1000.0);

            if(currentLevel==1) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("PREFS1", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("LastScore1", elapsedSeconds);
                editor.apply();
                Intent intent = new Intent(getContext(), leaderboard.class);
                intent.putExtra("lvlvalue", currentLevel);
                intent.putExtra("lvlflag", 0);
                mActivity.startActivity(intent);
            }
            if(currentLevel==2) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("PREFS2", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("LastScore2", elapsedSeconds);
                editor.apply();
                Intent intent = new Intent(getContext(), leaderboard.class);
                intent.putExtra("lvlvalue", currentLevel);
                intent.putExtra("lvlflag", 0);
                mActivity.startActivity(intent);
            }
            if(currentLevel==3) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("PREFS3", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("LastScore3", elapsedSeconds);
                editor.apply();
                Intent intent = new Intent(getContext(), leaderboard.class);
                intent.putExtra("lvlvalue", currentLevel);
                intent.putExtra("lvlflag", 0);
                mActivity.startActivity(intent);
            }
            if(currentLevel==4) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("PREFS4", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("LastScore4", elapsedSeconds);
                editor.apply();
                Intent intent = new Intent(getContext(), leaderboard.class);
                intent.putExtra("lvlvalue", currentLevel);
                intent.putExtra("lvlflag", 0);
                mActivity.startActivity(intent);
            }

            Toast.makeText(mActivity.getApplicationContext(),"CONGRATULATIONS", Toast.LENGTH_LONG).show();

        }
    }

    public void registerListener() {
        mSensorManager.registerListener(mSensorAccelerometer, SensorManager.SENSOR_ACCELEROMETER,SensorManager.SENSOR_DELAY_GAME);

    }

    public void unregisterListener() {
        mSensorManager.unregisterListener(mSensorAccelerometer);
    }

    public void setmWarning(boolean warn) {
        mWarning = warn;

    }
}
