package com.cherry_burst.anbayasiroulette;

/**
 * Created by maeshunsuke on 2015/08/30.
 */
public class AnbayasiData {
    // あんばやしの本数
    private int number;
    // おまけの本数
    private int addition;
    // あたり、はずれ、まあまあ
    private String comment;

    // コンストラクタ
    public AnbayasiData(int number, int addition, String comment) {
        this.number     = number;
        this.addition   = addition;
        this.comment    = comment;
    }

    public int getNumber() {
        return number;
    }

    public int getAddition() {
        return addition;
    }

    public String getComment() {
        return comment;
    }
}
