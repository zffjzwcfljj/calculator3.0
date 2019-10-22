package com.example.calculator30;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class asc extends AppCompatActivity implements View.OnClickListener{
    private EditText input,output;
    Button button,button2;
    public String str;
    int flag,flag2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asc_main);

        input = (EditText)findViewById(R.id.input);
        output = (EditText)findViewById(R.id.output);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    public void onRadioButtonClicked(View view) {
        switch(view.getId()) {
            case R.id.two1:
                flag=1;
                break;
            case R.id.eight1:
                flag=2;
                break;
            case R.id.ten1:
                flag=3;
                break;
            case R.id.sixteen1:
                flag=4;
                break;

        }

        switch(view.getId()) {
            case R.id.two2:
                flag2=1;
                break;
            case R.id.eight2:
                flag2=2;
                break;
            case R.id.ten2:
                flag2=3;
                break;
            case R.id.sixteen2:
                flag2=4;
                break;

        }
    }

    @Override
    public void onClick(View v){
        str = input.getText().toString();
        input.setText(str);
        switch(v.getId()) {
            case R.id.button:
                if (flag==1 && flag2==2) output.setText(Integer.toOctalString(Integer.parseInt(str, 2)));
                else if (flag==1 && flag2==3) output.setText(Integer.valueOf(str,2).toString());
                else if (flag==1 && flag2==4) output.setText(Integer.toHexString(Integer.parseInt(str, 2)));

                else if (flag==2 && flag2==1) output.setText(Integer.toBinaryString(Integer.valueOf(str,8)));
                else if (flag==2 && flag2==3) output.setText(Integer.valueOf(str,8).toString());
                else if (flag==2 && flag2==4) output.setText(Integer.toHexString(Integer.valueOf(str,8)));

                else if (flag==3 && flag2==1) output.setText(Integer.toBinaryString(Integer.parseInt(str)));
                else if (flag==3 && flag2==2) output.setText(Integer.toOctalString(Integer.parseInt(str)));
                else if (flag==3 && flag2==4) output.setText(Integer.toHexString(Integer.parseInt(str)));

                else if (flag==4 && flag2==1) output.setText(Integer.toBinaryString(Integer.valueOf(str,16)));
                else if (flag==4 && flag2==2) output.setText(Integer.toOctalString(Integer.valueOf(str,16)));
                else if (flag==4 && flag2==3) output.setText(Integer.valueOf(str,16).toString());
                break;

            case R.id.button2:
                finish();
                break;
        }
    }



}
