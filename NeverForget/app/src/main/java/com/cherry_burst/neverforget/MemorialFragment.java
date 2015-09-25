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


public class MemorialFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static Fragment newInstance(Context context) {
        MemorialFragment f = new MemorialFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_memorial,null);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("memorial", Context.MODE_PRIVATE);
        //プリファレンスから値を取得。第二引数は初期値
        String birthday    = prefs.getString("birthday" , "");
        String birthday1   = prefs.getString("birthday1", "");
        String birthday2   = prefs.getString("birthday2", "");
        String birthday3   = prefs.getString("birthday3", "");
        String wedding     = prefs.getString("wedding"  , "");

        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        editText1.setText(birthday);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        editText2.setText(birthday1);
        EditText editText3 = (EditText)getView().findViewById(R.id.editText3);
        editText3.setText(birthday2);
        EditText editText4 = (EditText)getView().findViewById(R.id.editText4);
        editText4.setText(birthday3);
        EditText editText5 = (EditText)getView().findViewById(R.id.editText5);
        editText5.setText(wedding);
    }

    @Override
    public void onPause() {
        super.onPause();

        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        EditText editText3 = (EditText)getView().findViewById(R.id.editText3);
        EditText editText4 = (EditText)getView().findViewById(R.id.editText4);
        EditText editText5 = (EditText)getView().findViewById(R.id.editText5);

        String birthday     = editText1.getText().toString();
        String birthday1    = editText2.getText().toString();
        String birthday2    = editText3.getText().toString();
        String birthday3    = editText4.getText().toString();
        String wedding      = editText5.getText().toString();


        //保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("memorial", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("birthday" , birthday);
        editor.putString("birthday1", birthday1);
        editor.putString("birthday2", birthday2);
        editor.putString("birthday3", birthday3);
        editor.putString("wedding"  , wedding);
        Log.d("tag", "-------------------save memorial");
//        editor.commit();
        editor.apply(); // 非同期commit
    }
}
