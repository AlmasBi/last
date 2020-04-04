package com.example.lab6;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class secondActivity extends AppCompatActivity {
    public int id;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        id=getIntent().getExtras().getInt("ID",0);
        db=MyApplication.getInstance().getDatabase();
        Contact contact = db.contactDao().getContactById(id);
        Fragment f1 = new fragment_three();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_3,f1).commitAllowingStateLoss();


    }
    public void Del(View view){

        Fragment fragment=null;


        fragment=new fragment_del();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_4,fragment).commit();

    }
    public void Up(View view){

        Fragment fragment=null;


        fragment=new fragment_up();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_4,fragment).commit();

    }

    public int idiwka(){
        return id;
    }
}
