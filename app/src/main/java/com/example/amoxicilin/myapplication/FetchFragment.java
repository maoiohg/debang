package com.example.amoxicilin.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FetchFragment extends Fragment {

    private ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_fetch, container, false);
        ListView list= (ListView) rootview.findViewById(R.id.listView_information);
        String[] ListData={"测试1","测试2","测试3","测试4","测试5","测试6","测试7","测试8","测试9","测试10",
                "测试11","测试12","测试13","测试14","测试15","测试16","测试17","测试18","测试19"};
        ArrayAdapter adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ListData);
        list.setAdapter(adapter);
        return rootview;
    }

}
