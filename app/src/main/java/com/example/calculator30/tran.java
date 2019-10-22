package com.example.calculator30;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.PopupMenu;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class tran  extends AppCompatActivity implements View.OnClickListener{
    private EditText input,output;
    Button button,button2;
    public String str;
    int flag,flag2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tran_main);

        input = (EditText)findViewById(R.id.input);
        output = (EditText)findViewById(R.id.output);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    public void onRadioButtonClicked(View view) {
        switch(view.getId()) {
            case R.id.cm11:
                flag=1;
                break;
            case R.id.dm11:
                flag=2;
                break;
            case R.id.m11:
                flag=3;
                break;
            case R.id.cm22:
                flag=4;
                break;
            case R.id.dm22:
                flag=5;
                break;
            case R.id.m22:
                flag=6;
                break;

        }

        switch(view.getId()) {
            case R.id.cm:
                flag2=1;
                break;
            case R.id.dm:
                flag2=2;
                break;
            case R.id.m:
                flag2=3;
                break;
            case R.id.cm2:
                flag2=4;
                break;
            case R.id.dm2:
                flag2=5;
                break;
            case R.id.m2:
                flag2=6;
                break;

        }
    }

    @Override
    public void onClick(View v) {
        str = input.getText().toString();
        input.setText(str);
        switch(v.getId()) {
            case R.id.button:
                if (flag==1 && flag2==2) output.setText(String.valueOf(Double.parseDouble(str)/10));
                else if (flag==1 && flag2==3) output.setText(String.valueOf(Double.parseDouble(str)/100));
                else if (flag==2 && flag2==1) output.setText(String.valueOf(Double.parseDouble(str)*10));
                else if (flag==2 && flag2==3) output.setText(String.valueOf(Double.parseDouble(str)/10));
                else if (flag==3 && flag2==1) output.setText(String.valueOf(Double.parseDouble(str)*100));
                else if (flag==3 && flag2==2) output.setText(String.valueOf(Double.parseDouble(str)*10));

                else if (flag==4 && flag2==5) output.setText(String.valueOf(Double.parseDouble(str)/100));
                else if (flag==4 && flag2==6) output.setText(String.valueOf(Double.parseDouble(str)/10000));
                else if (flag==5 && flag2==4) output.setText(String.valueOf(Double.parseDouble(str)*100));
                else if (flag==5 && flag2==6) output.setText(String.valueOf(Double.parseDouble(str)/100));
                else if (flag==6 && flag2==4) output.setText(String.valueOf(Double.parseDouble(str)*10000));
                else if (flag==6 && flag2==5) output.setText(String.valueOf(Double.parseDouble(str)*100));
                break;

            case R.id.button2:
                finish();
                break;
        }
    }


}
