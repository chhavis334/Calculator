package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bDot,bMultiply,bPlus,bEquals,bMinus,bDivide;
    EditText newNumber;
    EditText result;
    TextView displayOperation;
    private static final String TAG = "MainActivity";
    // Variables to hold the operands and type of calculations
    Double operand1 = null;
    Double operand2 = null;
    String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        b0=findViewById(R.id.b0);
//        b1=findViewById(R.id.b1);
//        b2=findViewById(R.id.b2);
//        b3=findViewById(R.id.b3);
//        b4=findViewById(R.id.b4);
//        b5=findViewById(R.id.b5);
//        b6=findViewById(R.id.b6);
//        b7=findViewById(R.id.b7);
//        b8=findViewById(R.id.b8);
//        b9=findViewById(R.id.b9);
//        bEquals=findViewById(R.id.bequals);
//        bDivide=findViewById(R.id.bdivide);
//        bPlus=findViewById(R.id.bplus);
//        bMinus=findViewById(R.id.bminus);
//        bMultiply=findViewById(R.id.bmultiply);
//        bDot=findViewById(R.id.bdot);
        result=findViewById(R.id.result);
        newNumber=findViewById(R.id.newNumber);
        displayOperation=findViewById(R.id.displayOperation);

    }
    //onclick for numbers
    public void click(View view) {
        Button b=(Button)view;
        newNumber.append(b.getText().toString());
        //Log.d(TAG,"button clicked : "+ b.getText());
        // Log.d(TAG,"new number : "+newNumber);

    }
    //onclick for symbols ie operation to perform
    public void clickOperation(View view) {
        Button b=(Button)view;
        String op=b.getText().toString();
        String value = newNumber.getText().toString();
        if(value.length()!=0)
            performOperation(value, op);
        pendingOperation=op;
        displayOperation.setText(pendingOperation);




    }

    private void performOperation(String value, String operation) {
        if(null==operand1)
            operand1 = Double.valueOf(value);
        else{
            operand2=Double.valueOf(value);
            if(pendingOperation.equals("=")){
                pendingOperation=operation;
            }
            switch(pendingOperation){
                case "=":
                    operand1=operand2;
                    break;
                case "/":
                    if(operand2==0)
                        operand1=0.0;
                    else
                        operand1/=operand2;
                    break;
                case "+":
                    operand1+=operand2;
                    break;
                case "-":
                    operand1-=operand2;
                    break;
                case"*":
                    operand1*=operand2;
                    break;
            }
        }
        result.setText(operand1.toString());
        newNumber.setText("");

    }
}

