package com.example.kotlintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.kotlintest.kotlin.DataEvent;
import com.example.kotlintest.kotlin.RxSchedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);

        //construct
        DataEvent dataEvent = new DataEvent("jacklove");

        //val-getter、setter
        textView.setText(dataEvent.getName());

        //var-getter
        dataEvent.getIdentityNum();

        //invoke method
        dataEvent.getDoubleAge(10);

        //invoke static method
        DataEvent.Companion.getDouble(2);

        //协程
        dataEvent.main();

        //static final
        String  sex = DataEvent.sex;

        //调用顶层函数
        RxSchedulers.getSystemModel();
    }
}
