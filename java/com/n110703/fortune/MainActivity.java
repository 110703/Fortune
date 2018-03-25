package com.n110703.fortune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String FORTUNE_RESULT = "RESULT";      //おみくじ結果キー
    private final int NUM_RESULT = 3;   //おみくじの結果の数
    public static final int NO_RESULT = -1;    //設定値以外
    public static final int BEST = 0;          //大吉
    public static final int BETTER = 1;        //中吉
    public static final int GOOD = 2;          //吉

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //「開運」ボタンを押下したときの処理
    public void onStartButtonClicked(View view) {
        //現状のデータを格納するためのインテントを作成
        Intent intent = new Intent(this,ResultActivity.class);

        //おみくじの結果をインテントに格納
        setFortuneResult(intent);

        //結果画面に遷移する（インテントをお土産にする）
        startActivity(intent);
    }

    //おみくじの結果をインテントに格納する
    private void setFortuneResult(Intent intent) {

        //おみくじの結果をランダムに決定し、インテントに格納する
        switch ((int)(Math.random() * NUM_RESULT)) {
            //大吉
            case BEST:
                intent.putExtra(FORTUNE_RESULT, BEST);
                break;
            //中吉
            case BETTER:
                intent.putExtra(FORTUNE_RESULT, BETTER);
                break;
            //吉
            case GOOD:
                intent.putExtra(FORTUNE_RESULT, GOOD);
                break;
            //想定外
            default:
                intent.putExtra(FORTUNE_RESULT, NO_RESULT);
                break;
        }
    }
}
