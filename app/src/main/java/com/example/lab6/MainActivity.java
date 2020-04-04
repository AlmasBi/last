package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=MyApplication.getInstance().getDatabase();
        Fragment f1 = new fragment_one();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_1,f1).commitAllowingStateLoss();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Refresh();
    }

    public void Change(View view){

        Fragment fragment=null;


        fragment=new fragment_two();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_2,fragment).commit();

    }
    public void Refresh(){
        Fragment f1 = new fragment_one();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_1,f1).commitAllowingStateLoss();
        List<Contact> contacts= db.contactDao().getContact();
        for(Contact contact:contacts){
            Log.e("Contact",contact.id+" "+contact.title);
        }
    }

    public void Second(int iid) {

        int idd;
        idd=iid;

        Intent intent = new Intent(MainActivity.this, secondActivity.class);
        intent.putExtra("ID", idd);
        startActivity(intent);
    }
}
