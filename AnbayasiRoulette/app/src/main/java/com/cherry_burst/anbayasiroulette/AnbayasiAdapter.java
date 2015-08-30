package com.cherry_burst.anbayasiroulette;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by maeshunsuke on 2015/08/30.
 */
public class AnbayasiAdapter extends RecyclerView.Adapter<AnbayasiViewHolder> {
    private ArrayList<AnbayasiData> rouletteDataSet;

    // コンストラクタ
    public AnbayasiAdapter(ArrayList<AnbayasiData> roulette) {
        this.rouletteDataSet = roulette;
    }

    // 新しいViewを作成する
    // レイアウトマネージャにより起動される
    @Override
    public AnbayasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // parentはRecyclerView
        // inflateメソッドでparentにRecyclerViewを指定して、cards_layoutを作成し、ビューを返す
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        // そのビューを引数にViewHolderクラスを継承するAnbayasiViewHolderオブジェクトを生成してreturn
        return new AnbayasiViewHolder(view);
    }

    // Viewの内容を交換する（リサイクルだから）
    // レイアウトマネージャにより起動される
    @Override
    public void onBindViewHolder(final AnbayasiViewHolder holder, final int position) {

        // AnbayasViewHolderの保持するcards_layout上のtextViewNumber、textViewCommentに
        // あたりの本数とコメントをセットする。
        // RecyclerView上のポジションが引数のpositionとして渡ってくる
        holder.textViewNumber.setText(rouletteDataSet.get(position).getNumber()+"本");
        holder.textViewComment.setText(rouletteDataSet.get(position).getComment());
        // holder.base.setOnClickListener()で、holderのbaseつまりCardViewにOnClickListenerをセット
        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // vはcardView
                Toast.makeText(v.getContext(), "おまけ" +
                    rouletteDataSet.get(position).getAddition()+"本", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rouletteDataSet.size();
    }
}
