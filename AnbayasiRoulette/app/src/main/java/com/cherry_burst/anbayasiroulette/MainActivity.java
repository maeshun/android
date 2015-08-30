package com.cherry_burst.anbayasiroulette;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // RecyclerViewのオブジェクトを取得
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cardList);

        // RecyclerViewのサイズが変わらない場合にパフォーマンス向上させるため
        recyclerView.setHasFixedSize(true);

        // RecyclerViewにはそのレイアウトを決めるレイアウトマネージャが必要
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        // 縦スクロール
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        // 表示するAnbayasiDataクラスのArrayListを作る
        ArrayList<AnbayasiData> anbayasi = new ArrayList<AnbayasiData>();

        // MyDataクラスの配列のデータでAnbayasiDataのオブジェクトを生成
        for (int i = 0; i < MyData.commentArray.length; i++) {
            anbayasi.add(new AnbayasiData(
                MyData.numberArray[i],
                MyData.additionArray[i],
                MyData.commentArray[i]
            ));
        }

        RecyclerView.Adapter adapter = new AnbayasiAdapter(anbayasi);
        recyclerView.setAdapter(adapter);
        // 起動時に最後までスクロールする
        recyclerView.smoothScrollToPosition(anbayasi.size() -1);
    }

}
