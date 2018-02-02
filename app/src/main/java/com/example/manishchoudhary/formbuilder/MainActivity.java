package com.example.manishchoudhary.formbuilder;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.manishchoudhary.formbuilder.Helper.ViewType;
import com.example.manishchoudhary.formbuilder.InterFace.GetResultBack;
import com.example.manishchoudhary.formbuilder.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements GetResultBack {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void getResultBack(HashMap<ViewType, String> map) {
        if (map.get(ViewType.ERROR) != null) {
            Toast.makeText(MainActivity.this, "Error----Here", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, map.get(ViewType.EMAILADDRESS), Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, map.get(ViewType.PASSWORD), Toast.LENGTH_SHORT).show();
        }
    }
}
