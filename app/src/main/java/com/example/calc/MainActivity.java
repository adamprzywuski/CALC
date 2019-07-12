package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import java.lang.*;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add,
            btn_Sub, btn_Mul, btn_Div, btn_calc, btn_doc, btn_clear,btn_left,btn_right,
            btn_exp,btn_log;
    private void getValue()
    {
        number2=Double.parseDouble(ed1.getText()+"");
        if(sign=="+")
        {
            score=number1+number2;
        }
        else if(sign=="-")
        {
            score=number1-number2;
        }
        else if(sign=="*")
        {
            score=number1*number2;
        }
        else if(sign=="/")
        {
            score=number1/number2;
            if(number2==0)
            {
                ed1.setText("Cant divide by 0");
            }
        }
        else if(sign=="^")
        {
            score=Math.pow(number1,number2);
        }
        else if(sign=="&")
        {
            score=Math.log(number1)/Math.log(number2);
        }

        String assis=ed2.getText().toString();
        ed2.setText(assis+ed1.getText());
        ed2.setText(inf);
        ed1.setText(String.valueOf(score));
    }
    TextView ed1,ed2;
    double number1;
    double number2,score;
    String sign = "";
    String inf="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.button0);
        btn_1 = (Button) findViewById(R.id.button1);
        btn_2 = (Button) findViewById(R.id.button2);
        btn_3 = (Button) findViewById(R.id.button3);
        btn_4 = (Button) findViewById(R.id.button4);
        btn_5 = (Button) findViewById(R.id.button5);
        btn_6 = (Button) findViewById(R.id.button6);
        btn_7 = (Button) findViewById(R.id.button7);
        btn_8 = (Button) findViewById(R.id.button8);
        btn_9 = (Button) findViewById(R.id.button9);
        btn_Add = (Button) findViewById(R.id.buttonadd);
        btn_Div = (Button) findViewById(R.id.buttondiv);
        btn_Sub = (Button) findViewById(R.id.buttonsub);
        btn_Mul = (Button) findViewById(R.id.buttonmul);
        btn_calc = (Button) findViewById(R.id.buttoneql);
        btn_doc = (Button) findViewById(R.id.button10);
        btn_clear = (Button) findViewById(R.id.buttonC);
        ed1 = (TextView) findViewById(R.id.textView2);
        ed2 = (TextView) findViewById(R.id.textView4);
        btn_left=(Button) findViewById(R.id.left);
        btn_right=(Button) findViewById(R.id.right);
        btn_exp=(Button) findViewById(R.id.exp);
        btn_log=(Button) findViewById(R.id.Logarthm);

        ed1.setText("");
        ed2.setText("");

        btn_0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "0");
                inf+="0";

            }
        });
        btn_left.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "(");
                inf+="(";
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + ")");
                inf+=")";
            }
        });
        btn_doc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + ".");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "1");
                inf+="1";

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "2");
                inf+="2";

            }
        });
        btn_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "3");
                inf+="3";
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "4");
                inf+="4";
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "5");
                inf+="5";
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                inf+="6";
                ed1.setText(ed1.getText() + "6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                inf+="7";
                ed1.setText(ed1.getText() + "7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
            inf+="8";
                ed1.setText(ed1.getText() + "8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                inf+="9";
                ed1.setText(ed1.getText() + "9");
            }
        });
        btn_Add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign!="")
                {
                    getValue();
                }
                if(number1==0)
                    number1 = Double.parseDouble(ed1.getText() + "");
                inf+="+";
                sign="+";
                ed2.setText(ed1.getText() + "+");
                ed1.setText("");
            }
        });
        btn_calc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
               getValue();
            }
        });

        btn_Mul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign!="")
                {
                    getValue();
                }
                if(number1==0)
                    number1=Float.parseFloat(ed1.getText()+"");
                sign="*";
                ed2.setText(ed1.getText() + "*");
                ed1.setText("");
                inf+="*";
            }
        });
        btn_Div.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign!="")
                {
                    getValue();
                }
                if(number1==0)
                    number1=Float.parseFloat(ed1.getText()+"");
                sign="/";
                ed2.setText(ed1.getText() + "/");
                ed1.setText("");
                inf+="/";
            }
        });
        btn_Sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign!="")
                {
                    getValue();
                }
                if(number1==0)
                    number1=Float.parseFloat(ed1.getText()+"");
                sign="-";
                ed2.setText(ed1.getText() + "-");
                ed1.setText("");
                inf+="-";
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign!="")
                {
                    getValue();
                }
                if(number1==0)
                    number1=Float.parseFloat(ed1.getText()+"");
                sign="&";
                inf+="&";
                ed2.setText(ed1.getText() + "Logarithm");
                ed1.setText("");

            }
        });
        btn_exp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign!="")
                {
                    getValue();
                }
                if (number1 == 0)
                    number1 = Float.parseFloat(ed1.getText() + "");

                sign="^";
                inf+="^";
                ed2.setText(ed1.getText() + "^");
                ed1.setText("");

            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText("");
                ed2.setText("");
                number2=0;
                number1=0;
                sign="";
                inf="";
            }
        });































    }





}
