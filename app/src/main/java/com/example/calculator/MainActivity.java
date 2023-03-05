package com.example.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import java.math.BigDecimal;
import androidx.appcompat.app.AppCompatActivity;

public class    MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_one;     //1
    Button btn_two;     //2
    Button btn_three;   //3
    Button btn_four;    //4
    Button btn_five;    //5
    Button btn_six;     //6
    Button btn_seven;   //7
    Button btn_eight;   //8
    Button btn_nine;    //9
    Button btn_zero;    //0
    Button btn_divide;  //除號
    Button btn_multiply;//x
    Button btn_subtract;//-
    Button btn_add;     //+
    Button btn_dot;   //.
    Button btn_equal;   //=
    Button btn_back;
    Button btn_clear;
    private EditText edt;
    private int intial_s=0;
    private int operate=0;
    private  double result=0;
    private  String num_1,num2;
    private static final int DEF_DIV_SCALE = 10;
    private BigDecimal b1,b2;
    private Double v1,v2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        btn_one = findViewById(R.id.button_1);
        btn_two = findViewById(R.id.button_2);
        btn_three = findViewById(R.id.button_3);
        btn_four = findViewById(R.id.button_4);
        btn_five = findViewById(R.id.button_5);
        btn_six = findViewById(R.id.button_6);
        btn_seven = findViewById(R.id.button_7);
        btn_eight = findViewById(R.id.button_8);
        btn_nine = findViewById(R.id.button_9);
        btn_zero = findViewById(R.id.button_zero);
        btn_divide = findViewById(R.id.button_didive);
        btn_multiply = findViewById(R.id.button_multiply);
        btn_subtract = findViewById(R.id.button_subtract);
        btn_add = findViewById(R.id.button_add);
        btn_dot = findViewById(R.id.button_dot);
        btn_equal = findViewById(R.id.button_equal);
        btn_clear=findViewById(R.id.button_clear);
        btn_back=findViewById(R.id.button_back);
        edt = findViewById(R.id.edt);
        edt.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        edt.setText("0");

    }
    public static  BigDecimal Ch(String a1)
    {
        double w1;
        w1=Double.valueOf(a1);
        BigDecimal b1 = new BigDecimal(Double.toString(w1));
        return b1;
    }
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences appSharedParefs= getSharedPreferences("pre_value",MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = appSharedParefs.edit();
        prefsEditor.putString("newItem",(new Double(result)).toString());
        prefsEditor.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences appSharePrefs =getSharedPreferences("pre_value",MODE_PRIVATE);
        result=
                (new Double(appSharePrefs.getString("newItem","0"))).doubleValue();
    }
    public void onWindowFocusChanged(boolean hasFocus) {
        GridLayout keysGL = (GridLayout) findViewById(R.id.keys);

        int kbHeight = (int) (keysGL.getHeight() / keysGL.getRowCount());
        int kbWidth = (int) (keysGL.getWidth() / keysGL.getColumnCount());

        Button btn;

        for (int i = 0; i < keysGL.getChildCount(); i++) {
            btn = (Button) keysGL.getChildAt(i);
            btn.setHeight(kbHeight);
            btn.setWidth(kbWidth);
            btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }
        EditText edt=(EditText) findViewById(R.id.edt);
        edt.setText(String.valueOf(result));
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_zero:
                    if(intial_s==0){
                        edt.setText(btn_zero.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_zero.getText().toString());
                    }
                    break;
                case R.id.button_1:
                    if(intial_s==0){
                        edt.setText(btn_one.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_one.getText().toString());
                    }
                    break;
                case R.id.button_2:
                    if(intial_s==0){
                        edt.setText(btn_two.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_two.getText().toString());
                    }
                    break;
                case R.id.button_3:
                    if(intial_s==0){
                        edt.setText(btn_three.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_three.getText().toString());
                    }
                    break;
                case R.id.button_4:
                    if(intial_s==0){
                        edt.setText(btn_four.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_four.getText().toString());
                    }
                    break;
                case R.id.button_5:
                    if(intial_s==0){
                        edt.setText(btn_five.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_five.getText().toString());
                    }
                    break;
                case R.id.button_6:
                    if(intial_s==0){
                        edt.setText(btn_six.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_six.getText().toString());
                    }
                    break;
                case R.id.button_7:
                    if(intial_s==0){
                        edt.setText(btn_seven.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_seven.getText().toString());
                    }
                    break;
                case R.id.button_8:
                    if(intial_s==0){
                        edt.setText(btn_eight.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_eight.getText().toString());
                    }
                    break;
                case R.id.button_9:
                    if(intial_s==0){
                        edt.setText(btn_nine.getText().toString());
                        intial_s=1;
                    }
                    else{
                        edt.setText(edt.getText()+btn_nine.getText().toString());
                    }
                    break;
                case R.id.button_dot:
                    if(intial_s==0){
                        edt.setText("0");
                        intial_s=0;
                    }
                    else{
                        edt.setText(edt.getText()+btn_dot.getText().toString());
                    }
                    break;
                case R.id.button_add:
                    num_1=edt.getText().toString();
                    operate=1;
                    intial_s=0;
                    break;
                case R.id.button_subtract:
                    if(intial_s==0){
                        edt.setText(btn_subtract.getText().toString());
                        intial_s=1;
                    }else
                    {
                    num_1=edt.getText().toString();
                    operate=2;
                    intial_s=0;
                    }
                    break;
                case R.id.button_multiply:
                    num_1=edt.getText().toString();
                    operate=3;
                    intial_s=0;
                    break;
                case R.id.button_didive:
                    num_1=edt.getText().toString();
                    operate=4;
                    intial_s=0;
                    break;
                case R.id.button_clear:
                    num_1="";
                    num2="";
                    operate=0;
                    intial_s=0;
                    result=0;
                    edt.setText("0");
                    break;
                case R.id.button_back:
                    num_1=edt.getText().toString();
                    edt.setText(num_1.substring(0,num_1.length()-1));
                    break;
                case R.id.button_equal:
                    num2=edt.getText().toString();
                    if (operate == 1) {
                        b1=Ch(num_1);
                        b2=Ch(num2);
                        result=b1.add(b2).doubleValue();
                        edt.setText(String.valueOf(result));
                        operate=0;
                    }else if(operate==2){
                        b1=Ch(num_1);
                        b2=Ch(num2);
                        result=b1.subtract(b2).doubleValue();
                        edt.setText(String.valueOf(result));
                    }else if(operate==3){
                        b1=Ch(num_1);
                        b2=Ch(num2);
                        result=b1.multiply(b2).doubleValue();
                        edt.setText(String.valueOf(result));
                    }else if(operate==4){
                        v1=Double.valueOf(num_1);
                        v2=Double.valueOf(num2);
                        result=div(v1,v2,DEF_DIV_SCALE);
                        edt.setText(String.valueOf(result));
                    }
                    intial_s=0;
                    break;
            }

        }

    }





