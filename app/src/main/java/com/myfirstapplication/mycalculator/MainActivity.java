package com.myfirstapplication.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private double myresult = 0;
    private String operator;
    private boolean isequal = false;
    public void AddCharacter(View view) {
        TextView number = findViewById(R.id.result);
        Button btn = (Button)view;
        String btn_text = btn.getText().toString();
        String res = number.getText().toString();
        String Result = "";
        if(res.equals("0"))
        {
            Result = btn_text;
        }
        else
        {
            Result = res + btn_text;
        }
        number.setText(Result);
    }

    public void PerformOperation(View view) {
        Button btn = (Button)view;
        String oper = btn.getText().toString();
        TextView val = findViewById(R.id.result);
        String value = val.getText().toString();
        TextView sub = findViewById(R.id.sub_result);

        if(value.equals("0"))
        {
            operator = oper;
            String Sub = sub.getText().toString();
            sub.setText(Sub.substring(0,Sub.length()-1)+oper.charAt(0));
            return;
        }
        if(myresult == 0)
        {
            myresult = Double.parseDouble(value);
            operator = oper;
            sub.setText(myresult + " " + operator);
            val.setText("0");
            return;
        }
        else if(isequal == true)
        {
            isequal = false;
            operator = oper;
            sub.setText(myresult + " " + operator);
            val.setText("0");
            return;
        }
        else
        {
            val.setText("0");
            if(operator.equals("+"))
            {
                myresult = myresult + Double.parseDouble(value);
                operator = oper;
            }
            else if(operator.equals("-"))
            {
                myresult = myresult - Double.parseDouble(value);
                operator = oper;
            }
            else if(operator.equals("x"))
            {
                myresult = myresult * Double.parseDouble(value);
                operator = oper;
            }
            else if(operator.equals("÷"))
            {
                myresult = myresult / Double.parseDouble(value);
                operator = oper;
            }
            else if(operator.equals("%"))
            {
                myresult = myresult % Double.parseDouble(value);
                operator = oper;
            }
            sub.setText(myresult + " " + operator);
        }

    }

    public void ClearData(View view) {
        myresult = 0;
        operator = "";
        TextView res = findViewById(R.id.result);
        TextView sub_res = findViewById(R.id.sub_result);
        sub_res.setText("");
        res.setText("0");
    }

    public void CreateBackspace(View view) {
        TextView res = findViewById(R.id.result);
        String Text = res.getText().toString();
        if(res.length()==1)
        {
            res.setText("0");
        }
        else
        {
            res.setText(Text.substring(0,Text.length()-1));
        }
    }

    public void PerformEqualOperation(View view) {
        TextView res = findViewById(R.id.result);
        TextView sub_res = findViewById(R.id.sub_result);
        String Text = res.getText().toString();
        if(myresult==0 && Text.equals("0"))
        {
            sub_res.setText("");
            res.setText("0");
        }
        else if(myresult == 0) {
            sub_res.setText("");
            res.setText(Text);
        }
        else
        {
            sub_res.setText("");
            if(operator.equals("+"))
            {
                myresult = myresult + Double.parseDouble(Text);
            }
            else if(operator.equals("-"))
            {
                myresult = myresult - Double.parseDouble(Text);
            }
            else if(operator.equals("x"))
            {
                myresult = myresult * Double.parseDouble(Text);
            }
            else if(operator.equals("÷"))
            {
                myresult = myresult / Double.parseDouble(Text);
            }
            else if(operator.equals("%"))
            {
                myresult = myresult % Double.parseDouble(Text);
            }
            res.setText(String.valueOf(myresult));
        }
        isequal = true;
    }
}