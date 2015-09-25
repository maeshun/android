package com.cherry_burst.neverforget;

import android.content.Context;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class MysizeFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static Fragment newInstance(Context context) {
        MysizeFragment f = new MysizeFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_mysize,null);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize", Context.MODE_PRIVATE);
        //プリファレンスから値を取得。第二引数は初期値
        int neck        = prefs.getInt("neck", 0);
        int sleeve      = prefs.getInt("sleeve", 0);
        int waist       = prefs.getInt("waist", 0);
        int insideLeg   = prefs.getInt("insideLeg", 0);
        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        if (neck != 0) {
            editText1.setText(Integer.toString(neck));
        }
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        if (sleeve != 0) {
            editText2.setText(Integer.toString(sleeve));
        }
        EditText editText3 = (EditText)getView().findViewById(R.id.editText3);
        if (waist != 0) {
            editText3.setText(Integer.toString(waist));
        }
        EditText editText4 = (EditText)getView().findViewById(R.id.editText4);
        if (insideLeg != 0) {
            editText4.setText(Integer.toString(insideLeg));
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        EditText editText3 = (EditText)getView().findViewById(R.id.editText3);
        EditText editText4 = (EditText)getView().findViewById(R.id.editText4);

        //ここで例外をキャッチしてキャスト
        int neck;
        try {
            neck = Integer.parseInt(editText1.getText().toString());
        } catch (NumberFormatException e) {
            neck = 0;
        }

        int sleeve;
        try {
            sleeve = Integer.parseInt(editText2.getText().toString());
        } catch (NumberFormatException e) {
            sleeve = 0;
        }

        int waist;
        try {
            waist = Integer.parseInt(editText3.getText().toString());
        } catch (NumberFormatException e) {
            waist = 0;
        }

        int insideLeg;
        try {
            insideLeg = Integer.parseInt(editText4.getText().toString());
        } catch (NumberFormatException e) {
            insideLeg = 0;
        }

        //保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("mysize", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("neck"        , neck);
        editor.putInt("sleeve"      , sleeve);
        editor.putInt("waist"       , waist);
        editor.putInt("insideLeg"   , insideLeg);

        Log.d("tag", "-------------------save mysize");
//        editor.commit();
        editor.apply(); // 非同期commit
    }
}
