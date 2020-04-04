package com.example.lab6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class fragment_up extends androidx.fragment.app.Fragment {
    AppDatabase db;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = MyApplication.getInstance().getDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_up, container, false);
        Button button = view.findViewById(R.id.up);
        final EditText id = view.findViewById(R.id.id);
        final EditText title = view.findViewById(R.id.title);
        final EditText duration = view.findViewById(R.id.duration);
        final EditText description = view.findViewById(R.id.description);
        final EditText status = view.findViewById(R.id.status);
        final EditText category = view.findViewById(R.id.category);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss = id.getText().toString();
                int aidi=Integer.parseInt(ss);
                Contact contact = db.contactDao().getContactById(aidi);

                String titleStr = title.getText().toString();
                String durationStr = duration.getText().toString();
                String descriptionStr = description.getText().toString();
                String statusStr = status.getText().toString();
                String categoryStr = category.getText().toString();

                contact.title=titleStr;
                contact.duration=durationStr;
                contact.category=categoryStr;
                contact.status=statusStr;
                contact.description=descriptionStr;

                db.contactDao().Update(contact);
                Toast.makeText(((secondActivity)getContext()), "Task updated", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}