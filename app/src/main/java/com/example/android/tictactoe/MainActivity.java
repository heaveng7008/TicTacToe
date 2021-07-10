package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gameState = {0,0,0,0,0,0,0,0,0,0};
    boolean gameActive = true;
//    0 - Blank
//    1 - 0
//    2 - X
    int counted = 0;
    int[][] winPosition = {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    int turn = 1;
    @SuppressLint("SetTextI18n")
    private void checkWinner()
    {
        if(counted==9)
        {
            ((TextView)findViewById(R.id.message)).setText("The Game has Drawn");
            gameActive = false;
        }
        for(int i=0;i<8;i++)
        {
            if(gameState[winPosition[i][0]]==1 && gameState[winPosition[i][0]]==gameState[winPosition[i][1]] && gameState[winPosition[i][1]]==gameState[winPosition[i][2]])
            {
                ((TextView)findViewById(R.id.message)).setText("Player 1 has won");
                gameActive = false;
            }
            else if(gameState[winPosition[i][0]]==2 && gameState[winPosition[i][0]]==gameState[winPosition[i][1]] && gameState[winPosition[i][1]]==gameState[winPosition[i][2]])
            {
                ((TextView)findViewById(R.id.message)).setText("Player 2 has won");
                gameActive = false;
            }
        }
    }
    public void taptap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage] == 0 && gameActive)
        {
            gameState[tappedImage] = turn;
            img.setTranslationY(-15f);
            if(turn == 1)
            {
                img.setImageResource(R.drawable.zero);
                turn = 2;
                counted++;
            }
            else
            {
                img.setImageResource(R.drawable.ximg);
                turn = 1;
                counted++;
            }
            img.animate().translationY(15f).setDuration(500);
            checkWinner();
        }

    }
    public void reset(View view){
        turn = 1;
        for(int i=0;i<9;i++)
            gameState[i]=0;
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        gameActive = true;
        counted = 0;
        ((TextView)findViewById(R.id.message)).setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}