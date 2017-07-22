package com.example.administrator.llab.fragment.fragmentData;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FragDiff1 extends Fragment{


    private titleSelectInterface tinterface;

    private ListView lv;

    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try
        {
            tinterface = (titleSelectInterface)activity;
        }
        catch (Exception e)
        {
            throw new ClassCastException(activity.toString() + "must implement OnArticleSelectedListener");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.frag_diff1,container,false);
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lv = (ListView) getView().findViewById(R.id.list);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),R.layout.frag_diff1_item,mStrings);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = mStrings[position];
                tinterface.setTitle(str);
            }
        });
    }

    public interface titleSelectInterface
    {
        public void setTitle(String str);
    }
}
