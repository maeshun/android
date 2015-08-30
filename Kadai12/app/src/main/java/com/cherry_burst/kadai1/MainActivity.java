package com.cherry_burst.kadai1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGo = (Button)findViewById(R.id.goButton);
        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = (EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        // activityに値渡す
        intent.putExtra("TEXT", text);
//        startActivity(intent);
        // 起動先アクティビティからデータを渡してもらう場合は
        // startActivityForResult(intent, requestCode)を利用する。
        // 第二引数のrequestCodeはonActivityResultの
        // 第一引数に渡される値で、条件分岐のための数値
        // requestCodeが0未満の場合はstartActivit(intent)と等価
        int requestCode = 123;
        startActivityForResult(intent, requestCode);
    }

    // startActivityで起動させたアクティビティが
    // finish()によって吐きされたときにコールされる
    // requestCode：startActivityForResultの第二引数で指定した値が渡される
    // resultCode ：起動先のActivity.setResultの第一引数が渡される
    // Intent data：起動先Activityから送られてくるintent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        Bundle bundle = data.getExtras();
        TextView tv = (TextView)findViewById(R.id.textView2);

        switch (requestCode) {
            case 123:
                if (resultCode == RESULT_OK) {
                    tv.setText("returnText:" + data.getStringExtra("RETURN_TEXT"));
                    // toast widget
                    // ユーザに通知するウィジェット
                    // 画面中央下にテキストを表示して消える
                    Toast.makeText(this, "もどったよ", Toast.LENGTH_SHORT).show();
                } else if (resultCode == RESULT_CANCELED) {

                }
                break;
            default:
                break;
        }
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
