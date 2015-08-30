package com.cherry_burst.myapp1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    // 起動時に実行される
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "onCreate実行されました");

//        MyView v = new MyView(this);
//        setContentView(v);

        setContentView(R.layout.activity_main);

        // Media Playerを利用するための宣言
//        MediaPlayer mPlayer;
//        mPlayer = MediaPlayer.create(this, R.raw.rekishi);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop実行されました");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.stop();
        Log.d("TAG", "onPauseが実行されました");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResumeが実行されました");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "onRestartが実行されました");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStartが実行されました");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy実行されました");
    }

    // activity_main.xmlで設定したonclickイベントのメソッドを実装
    // ボタンに関するメソッドはviewが引数になる
    public void changeLabel(View view) {
        // R.id.XXXでid参照
        TextView tv = (TextView)findViewById(R.id.myTextView);
        tv.setText("Changed!");
    }

    MediaPlayer mPlayer;

    public void pushPlayButton(View view) {
        TextView tv = (TextView)findViewById(R.id.myTextView);
        tv.setText("Play button pushed");
//        MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this, R.raw.rekishi);//
        mPlayer.start();
        Log.d("TAG", "play button pushed");
    }

    // 暗黙的インテント
    // 複数のアプリケーション間で連携を行う
    // 1.移譲したい処理内容を記載するURIを定義する
    // 2.Intentのオブジェクトを定義し、移譲したい処理を記述する
    // 3.処理を移譲する
    public void invisibleIntent(View view) {
        // 例）地図アプリを開く
//        Uri uri = Uri.parse("geo:0,0?q=Shibuya");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        // 例）連絡帳を表示
//        Uri uri = Uri.parse("tel:000-1111-2222");
//        Intent intent = new Intent(Intent.ACTION_DIAL, uri);

        // 例）ブラウザを起動する
        Uri uri = Uri.parse("http://pivot.jp");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        Log.d("TAG", "invisibleIntent実行されました");
        startActivity(intent);
    }

    // 明示的インテント
    public void visibleIntent(View view) {
        // 明示的インテントを行うには、Intentのコンストラクタで、自分自身を示すMainActivity.thisと
        // 起動したActivityであるMyActivityを、MyActivity.classのようにクラスファイル名で指定する
        Intent intent = new Intent(MainActivity.this, MyActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
