package com.example.lab6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_two extends Fragment  {
    AppDatabase db;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        Button button = view.findViewById(R.id.add);
        final EditText title = view.findViewById(R.id.title);
        final EditText duration = view.findViewById(R.id.duration);
        final EditText description = view.findViewById(R.id.description);
        final EditText status = view.findViewById(R.id.status);
        final EditText category = view.findViewById(R.id.category);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleStr = title.getText().toString();
                String durationStr = duration.getText().toString();
                String descriptionStr = description.getText().toString();
                String statusStr = status.getText().toString();
                String categoryStr = category.getText().toString();
                Contact contact  = new Contact();
                contact.title=titleStr;
                contact.duration=durationStr;
                contact.category=categoryStr;
                contact.status=statusStr;
                contact.description=descriptionStr;
                db.contactDao().Insert(contact);
                Toast.makeText(((MainActivity)getContext()), "New task added", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).Refresh();
                 EditText title = v.findViewById(R.id.title);
                 EditText duration = v.findViewById(R.id.duration);
                 EditText description = v.findViewById(R.id.description);
                 EditText status = v.findViewById(R.id.status);
                 EditText category = v.findViewById(R.id.category);
                title=null;
                duration=null;
                description=null;
                status=null;
            }  });
        return view;
    }
}
