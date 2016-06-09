package com.example.amoxicilin.myapplication.main;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.amoxicilin.myapplication.R;


public class CallFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview=inflater.inflate(R.layout.fragment_call, container, false);

        Button bt1= (Button) rootview.findViewById(R.id.button_submit);
        Spinner LabelSpinner= (Spinner) rootview.findViewById(R.id.spinner_label);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("系统消息")
                        .setMessage("确定要提交吗？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}})
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}})
                        .show();
            }
        });
        String[] res={"美化","设计","生活","教育"};
        ArrayAdapter adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,res);
        LabelSpinner.setAdapter(adapter);



        return rootview;
    }

}
