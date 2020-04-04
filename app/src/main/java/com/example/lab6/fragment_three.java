package com.example.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_three extends Fragment {
    AppDatabase db;
    int id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
        id=((secondActivity)getActivity()).idiwka();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        Contact contact = db.contactDao().getContactById(id);
         TextView utitle;
         TextView udescription;
         TextView ustatus;
         TextView ucategory;
         TextView uduration;

        utitle = view.findViewById(R.id.ttitle);
        udescription = view.findViewById(R.id.tdescription);
        ustatus = view.findViewById(R.id.tstatus);
        ucategory = view.findViewById(R.id.tcategory);
        uduration = view.findViewById(R.id.tduration);

        utitle.setText(contact.title);
        udescription.setText(contact.description);
        ustatus.setText(contact.status);
        ucategory.setText(contact.category);
        uduration.setText(contact.duration);
        return view;
    }
}
