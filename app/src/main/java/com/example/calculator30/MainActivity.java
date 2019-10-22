package com.example.calculator30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView resultView;
    private EditText input;

    Button n0,n1,n2,n3,n4,n5,n6,n7,n8,n9,add,sub,mul,div,dot,ac,back,equal,left,right;
    Button pai,zs,lg,x2,e,sin,cos,tan,gh;
    OptrStack optrStack = new OptrStack(); //操作符栈
    OpndStack opndStack = new OpndStack(); //操作数栈

    public int[] ss1 = {3,3,5,5,1,6,0};                           //栈内元素优先级
    public int[] ss2 = {2,2,4,4,6,1,0};                           //栈外元素优先级
    public String str;
    public double Math_PI=Math.PI;



        public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.help:

                Toast.makeText(MainActivity.this,"这是帮助区",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ascii:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, asc.class);
                startActivity(intent);
                break;
            case R.id.trans:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, tran.class);
                startActivity(intent1);
                break;
        }
        return true;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        input = (EditText)findViewById(R.id.input);
        n0 =(Button)findViewById(R.id.Num_0);
        n1 = (Button)findViewById(R.id.Num_1);
        n2 = (Button)findViewById(R.id.Num_2);
        n3 = (Button)findViewById(R.id.Num_3);
        n4 = (Button)findViewById(R.id.Num_4);
        n5 = (Button)findViewById(R.id.Num_5);
        n6 = (Button)findViewById(R.id.Num_6);
        n7 = (Button)findViewById(R.id.Num_7);
        n8 = (Button)findViewById(R.id.Num_8);
        n9 = (Button)findViewById(R.id.Num_9);
        add = (Button)findViewById(R.id.Num_add);
        sub = (Button)findViewById(R.id.Num_sub);
        mul = (Button)findViewById(R.id.Num_mul);
        div = (Button)findViewById(R.id.divide);
        dot = (Button)findViewById(R.id.Num_dot);
        ac = (Button)findViewById(R.id.ac);
        back = (Button)findViewById(R.id.Num_back);
        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        equal = (Button)findViewById(R.id.Num_equal);

        zs = (Button)findViewById(R.id.zs);
        gh = (Button)findViewById(R.id.gh);
        lg = (Button)findViewById(R.id.lg);
        x2 = (Button)findViewById(R.id.x2);
        e = (Button)findViewById(R.id.e);
        pai = (Button)findViewById(R.id.pai);
        sin = (Button)findViewById(R.id.sin);
        cos = (Button)findViewById(R.id.cos);
        tan = (Button)findViewById(R.id.tan);
        if (zs != null) zs.setOnClickListener(this);
        if (gh != null) gh.setOnClickListener(this);
        if (lg != null) lg.setOnClickListener(this);
        if (x2 != null) x2.setOnClickListener(this);
        if (e != null) e.setOnClickListener(this);
        if (pai != null) pai.setOnClickListener(this);
        if (sin != null) sin.setOnClickListener(this);
        if (cos != null) cos.setOnClickListener(this);
        if (tan != null) tan.setOnClickListener(this);

        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        right.setOnClickListener(this);
        left.setOnClickListener(this);
        if (back != null) back.setOnClickListener(this);
        ac.setOnClickListener(this);

        this.resultView = (TextView) this.findViewById(R.id.resultView);


    }
    @Override
    public void onClick(View v){
        str = input.getText().toString();
        switch(v.getId()){
            case R.id.sin:
                str = str+'s';
                input.setText(str);
                break;
            case R.id.cos:
                str = str+'c';
                input.setText(str);
                break;
            case R.id.tan:
                str = str+'t';
                input.setText(str);
                break;
            case R.id.e:
                str = str+'e';
                input.setText(str);
                break;
            case R.id.gh:
                str = str+'√';
                input.setText(str);
                break;
            case R.id.zs:
                str = str+'z';
                input.setText(str);
                break;
            case R.id.lg:
                str = str+'l';
                input.setText(str);
                break;
            case R.id.x2:
                str = str+'^';
                input.setText(str);
                break;
            case R.id.pai:
                str = str+'π';
                input.setText(str);
                break;
            case R.id.Num_add:
            case R.id.Num_sub:
            case R.id.Num_mul:
            case R.id.divide:
            case R.id.left:
            case R.id.right:
            case R.id.Num_dot:
            case R.id.Num_0:
            case R.id.Num_1:
            case R.id.Num_2:
            case R.id.Num_3:
            case R.id.Num_4:
            case R.id.Num_5:
            case R.id.Num_6:
            case R.id.Num_7:
            case R.id.Num_8:
            case R.id.Num_9:
                str = str+((Button)v).getText();
                input.setText(str);
                break;
            case R.id.ac:
                str="";
                input.setText(str);
                resultView.setText(str);
                break;
            case R.id.Num_back:
                str=str.substring(0,str.length()-1);
                input.setText(str);
                break;
            case R.id.Num_equal:
                str = str+((Button)v).getText();
                input.setText(str);
                String result = String.valueOf(evaluate());
                resultView.setText(result);
                break;

        }
    }

    int converse(char c)                                //把字符数字化
    {
        switch(c){
            case '+':  return 0;
            case '-':  return 1;
            case '*':  return 2;
            case '/':  return 3;
            case '(':  return 4;
            case ')':  return 5;
            default:   return 6;
        }
    }


    char comp(char r1,char r2) {                      //字符优先级比较
        int i1=converse(r1);                          //把字符1变成数字
        int i2=converse(r2);                          //把字符2变成数字
        if(ss1[i1]>ss2[i2]) return '>';                 //通过原来的设定找到优先级
        else if(ss1[i1]<ss2[i2]) return '<';
        else return '=';
    }

    double operate(double a,int t,double b){         //加减乘除的运算操作
        double sum=0;
        switch(t){
            case 0: sum=a+b; break;
            case 1: sum=a-b; break;
            case 2: sum=a*b; break;
            case 3: if(b!=0){sum=a/b;break;}else exit(1);
        }
        return sum;
    }


    double evaluate(){                      //表达式函数
        char c;
        int i=0;
        double sum,q;
        boolean k=true,flag=false;                       //flag标志区分是否带小数点
        double a,b;
        char t;
        optrStack.push('=');            //将‘=’压入栈
        c = str.charAt(i);
        i++;
        while (c != '=' || !(optrStack.peek() == '=')) {    //没有输入结束符'='或者栈顶不是结束符'='则一直循环
            if (isdigit(c) || c == '.') {            //isdigit(c)判断c是否为数字
                sum = 0;                           //sum是储存一个完整的数
                q = 10;                            //用来记录小数点后几位
                while (isdigit(c) || c == '.') {
                    if (isdigit(c) && flag == false)     //是数字且暂无出现小数点
                        sum = sum * 10 + (c - '0');
                    else if (c == '.')
                        flag = true;                  //记录数出现小数点
                    else if (isdigit(c) && flag == true) {      //记录出现小数点后一个完整的数sum
                        sum = sum + (c - '0') / q;
                        q = q * 10;
                    }

                    c = str.charAt(i);
                    i++;

                }
                flag = false;
                opndStack.push(sum);

                switch (c){
                    case 's':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.sin(a/180 * Math_PI));
                        c = str.charAt(i);
                        i++;
                        break;
                    case 'c':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.cos(a/180 * Math_PI));
                        c = str.charAt(i);
                        i++;
                        break;
                    case 't':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.tan(a/180 * Math_PI));
                        c = str.charAt(i);
                        i++;
                        break;
                    case 'e':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.exp(a));
                        c = str.charAt(i);
                        i++;
                        break;
                    case '√':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.sqrt(a));
                        c = str.charAt(i);
                        i++;
                        break;
                    case 'l':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.log10(a));
                        c = str.charAt(i);
                        i++;
                        break;
                    case 'z':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(Math.pow(10,a));
                        c = str.charAt(i);
                        i++;
                        break;
                    case '^':
                        a = opndStack.peek();
                        opndStack.pop();
                        opndStack.push(a*a);
                        c = str.charAt(i);
                        i++;
                        break;
                }
            }

            else if ( c == 'π') {
                opndStack.push(Math_PI);
                c = str.charAt(i);
                i++;
            }

            else if(k){
                switch (comp(optrStack.peek(), c)) {
                    case '<':
                        optrStack.push(c);  //把字符整型化，然后压入操作符栈
                        c = str.charAt(i);
                        i++;
                        break;
                    case '=':
                        optrStack.pop();                      //操作符栈顶元素出栈
                        c = str.charAt(i);
                        i++;
                        break;
                    case '>':
                        t = optrStack.peek();
                        optrStack.pop();        //操作符栈顶元素出栈
                        b = opndStack.peek();
                        opndStack.pop();              //操作数栈顶元素出栈
                        a = opndStack.peek();
                        opndStack.pop();              //操作数栈顶元素出栈
                        opndStack.push(operate(a, converse(t), b)); //两个运算数及一个运算符的运算结果入栈
                        break;
                }
            }
        }

        return (opndStack.peek());

    }

    private boolean isdigit(char c) {
        return c >='0' && c <= '9';
    }

}


class OptrStack {
    private char[] value=new char[100];
    private int top;

    OptrStack(){
        top=-1;
    }

    public char peek() {
        return value[top];
    }

    public void push(char c){
        value[++top]=c;
    }
    public void pop(){
        top--;
    }

}

class OpndStack {
    private double[] value=new double[100];
    private int top;

    OpndStack(){
        top=-1;
    }

    public double peek() {
        return value[top];
    }

    public void push(double c){
        value[++top]=c;
    }
    public void pop(){
        top--;
    }

}
