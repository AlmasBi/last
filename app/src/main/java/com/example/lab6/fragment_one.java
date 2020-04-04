package com.example.lab6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;

import java.util.ArrayList;
import java.util.List;


public class fragment_one extends Fragment implements ExampleAdapter.onBtnClick {
    AppDatabase db;
    private ArrayList<ExampleItem> exampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }


    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        exampleList = new ArrayList<>();
        List<Contact> contacts= db.contactDao().getContact();
         int iid;
         String ititle;
         String idescription;
         String istatus;
         String icategory;
         String iduration;
        for(Contact contact:contacts){

            iid=contact.id;
            ititle=contact.title;
            idescription=contact.description;
            istatus=contact.status;
            icategory=contact.category;
            iduration=contact.duration;
            exampleList.add(new ExampleItem(iid,ititle,idescription,istatus,icategory,iduration));
        }
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(exampleList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);





        return view;
    }

    @Override
    public void onClick(int position) {

        int iid;
        ExampleItem item =exampleList.get(position);
        iid= item.getId();
        ((MainActivity)getActivity()).Second(iid);

//
//
//       .
//        Intent intent = new Intent(MainActivity.class, secondActivity.class);
//        intent.putExtra("ID", iid);
//        startActivity(intent);
    }
}
