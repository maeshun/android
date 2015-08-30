package com.cherry_burst.myapp1;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by maeshunsuke on 2015/08/10.
 */
public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        setContentView(v);
    }
}
