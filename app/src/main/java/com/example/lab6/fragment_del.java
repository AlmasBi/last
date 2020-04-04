package com.example.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class fragment_del extends androidx.fragment.app.Fragment {
    AppDatabase db;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = MyApplication.getInstance().getDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_del, container, false);
        Button button = view.findViewById(R.id.del);
        final EditText id = view.findViewById(R.id.EditDel);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss = id.getText().toString();
                int aidi=Integer.parseInt(ss);
                Contact contact = db.contactDao().getContactById(aidi);
                db.contactDao().Delete(contact);
                Toast.makeText(((secondActivity)getContext()), "Task Delated", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}