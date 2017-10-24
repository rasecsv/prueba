package com.example.hola.appmap;

/**
 * Created by HOLA on 17/10/2017.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class navigation extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setupNavigationView();
    }
    public void setupNavigationView(){
        BottomNavigationView bottomNavigationView =( BottomNavigationView)findViewById(R.id.btmview);
        if(bottomNavigationView !=null){
            Menu menu= bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    setContentView((View) item);
                    return false;
                }
            });
        }
    }
    protected void selectFragment(MenuItem item){
       item.setChecked(true);
        switch (item.getItemId()){
            case R.id.inicio_item:
                pushFragment(new MenuFragment());
                break;

            case R.id.perfil_item:
                pushFragment(new UserFragment());
                break;
        }
    }
    protected void pushFragment(Fragment fragment){
        if (fragment == null)
            return;

        android.app.FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager !=null){
            android.app.FragmentTransaction ft = fragmentManager.beginTransaction();
            if(ft != null){
                ft.replace(R.id.btmview,fragment);
                ft.commit();
            }
        }
    }
}
