package com.n110703.fortune;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //おみくじの結果を踏まえた画像とテキストを表示する
        Intent intent = getIntent();
        showFortuneResult(intent);
    }

    //「戻る」ボタンを押下したときの処理
    public void onBackButtonClicked(View view) {
        //最初の画面に戻る
        finish();
    }

    //おみじくの結果を表示する処理
    private void showFortuneResult(Intent intent) {
        ImageView resultImage = (ImageView) findViewById(R.id.result_image);
        TextView textView = (TextView) findViewById(R.id.result_text);

        //インテントが保持している値によって分岐
        switch (intent.getIntExtra(MainActivity.FORTUNE_RESULT, MainActivity.NO_RESULT)) {
            //「大吉」
            case MainActivity.BEST:
                resultImage.setImageResource(R.drawable.omikuji_daikichi);
                textView.setText(R.string.result_best);
                break;
            //「中吉」
            case MainActivity.BETTER:
                resultImage.setImageResource(R.drawable.omikuji_chuukichi);
                textView.setText(R.string.result_better);
                break;
            //「吉」
            case MainActivity.GOOD:
                resultImage.setImageResource(R.drawable.omikuji_kichi);
                textView.setText(R.string.result_good);
                break;
            //想定外
            default:
                textView.setText(R.string.no_result);
                break;
        }
    }
}
