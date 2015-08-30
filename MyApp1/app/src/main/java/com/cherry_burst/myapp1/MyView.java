package com.cherry_burst.myapp1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by maeshunsuke on 2015/08/10.
 */
public class MyView extends View {
    // 円を動かす
    int mX = 100;
    int mY = 100;
    int mVX = 10;
    int mVY = 10;

    // Viewはコンストラクタが必要
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.argb(50, 100, 100, 100));

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawCircle(mX, mY, 100, paint);
        // Viewの端で跳ね返る
        if (mX > this.getWidth()) {
            mVX = -mVX;
        } else if (mX < 0) {
            mVX = -mVX;
        }

        if (mY > this.getHeight()) {
            mVY = -mVY;
        } else if (mY < 0) {
            mVY = -mVY;
        }

        mX += mVX;
        mY += mVY;
        // 強制的に再描画
        invalidate();
    }
}
