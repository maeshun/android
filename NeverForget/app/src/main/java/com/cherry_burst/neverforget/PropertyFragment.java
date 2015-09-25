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


public class PropertyFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static Fragment newInstance(Context context) {
        PropertyFragment f = new PropertyFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_property,null);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_PRIVATE);
        //プリファレンスから値を取得。第二引数は初期値
        String carNumber  = prefs.getString("carNumber" , "");
        String phone      = prefs.getString("phone"     , "");
        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        editText1.setText(carNumber);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);
        editText2.setText(phone);
    }

    @Override
    public void onPause() {
        super.onPause();

        EditText editText1 = (EditText)getView().findViewById(R.id.editText1);
        EditText editText2 = (EditText)getView().findViewById(R.id.editText2);

        //ここで例外をキャッチしてキャスト
        String carNumber = editText1.getText().toString();
        String phone     = editText2.getText().toString();

        //保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("carNumber", carNumber);
        editor.putString("phone", phone);
        Log.d("tag", "-------------------save property");
//        editor.commit();
        editor.apply(); // 非同期commit
    }
}
