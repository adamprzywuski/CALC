package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.String;
import java.util.*;


import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add,
            btn_Sub, btn_Mul, btn_Div, btn_calc, btn_doc, btn_clear,btn_left,btn_right,
            btn_exp,btn_root,btn_c;

    int dot=0;
    int sign=0;
    TextView ed1,ed2;
    
    
    String info="";




         String infixToPostfix(String infix) {

            final String ops = "-+/*^$";

            StringBuilder sb = new StringBuilder();
            Stack<Integer> s = new Stack<>();
            for (String token : infix.split("\\s")) {

                if (token.isEmpty())
                    continue;
                char c = token.charAt(0);
                int idx = ops.indexOf(c);

                if (idx != -1) {
                    if (s.isEmpty()) {
                        s.push(idx);



                    }
                    else {
                        while (!s.isEmpty()) {
                            int prec2 = s.peek() / 2;
                            int prec1 = idx / 2;
                            if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                                sb.append(ops.charAt(s.pop())).append(' ');
                            else break;
                        }
                        s.push(idx);
                    }
                } else if (c == '(') {
                    s.push(-2); // -2 stands for '('
                } else if (c == ')') {
                    // until '(' on stack, pop operators.
                    while (s.peek() != -2)
                        sb.append(ops.charAt(s.pop())).append(' ');
                    s.pop();
                } else {
                    sb.append(token).append(' ');

                }
            }
            while (!s.isEmpty())

                sb.append(ops.charAt(s.pop())).append(' ');

            return sb.toString();
        }


        void compute(String expr) throws
                ArithmeticException,
                EmptyStackException {
            Stack<Double> stack = new Stack<>();

            for (String token : expr.split("\\s+")) {
                System.out.print(token + "\t");
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":

                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":

                        double divisor = stack.pop();
                        if(divisor==0)
                        {
                            ed2.setText("Cant divide by 0");
                            return ;
                        }
                        stack.push(stack.pop() / divisor);
                        break;
                    case "^":
                        double exponent = stack.pop();
                        stack.push(Math.pow(stack.pop(), exponent));
                        break;
                    case"$":
                        double root=stack.pop();
                        stack.push(Math.pow(root, 1 /stack.pop() ));
                        break;
                    default:
                        stack.push(Double.parseDouble(token));
                        break;
                }


            }
            String answer=String.valueOf(stack.pop());
            info=answer;
            ed2.setText( answer);
        }






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
        btn_clear = (Button) findViewById(R.id.del);
        ed1 = (TextView) findViewById(R.id.textView2);
        ed2 = (TextView) findViewById(R.id.textView4);
        btn_left=(Button) findViewById(R.id.left);
        btn_right=(Button) findViewById(R.id.right);
        btn_exp=(Button) findViewById(R.id.exp);
        btn_root=(Button) findViewById(R.id.roots);
        btn_c=(Button) findViewById(R.id.buttonC);

        ed1.setText("");
        ed2.setText("");


        btn_0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "0");

                info+="0";


            }
        });
        btn_left.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "(");
                info+=" ( ";
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + ")");
                info+=" ) ";
            }
        });
        btn_doc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(dot>=1)
                {}
                else {
                    if (sign==1)
                    {
                        info+="0";
                    }
                    info += (".");
                    ed1.setText(ed1.getText() + ".");
                    dot=1;
                    sign=0;
                }
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "1");
                info+="1";
                sign=0;

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "2");
                info+="2";
                sign=0;

            }
        });
        btn_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "3");
                info+="3";
                sign=0;
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "4");
                info+="4";
                sign=0;
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText(ed1.getText() + "5");
                info+="5";
                sign=0;
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                info+="6";
                ed1.setText(ed1.getText() + "6");
                sign=0;
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                info+="7";
                ed1.setText(ed1.getText() + "7");
                sign=0;
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                info+="8";
                ed1.setText(ed1.getText() + "8");
                sign=0;
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){

                info+="9";
                ed1.setText(ed1.getText() + "9");
                sign=0;
                ed2.setText(" ");
            }
        });
        btn_Add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign>=1)
                { }
                else {
                    info += " + ";
                    dot = 0;sign++;


                    ed1.setText(ed1.getText() + "+");
                }
            }
        });
        btn_calc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v) {
                dot=0;

                compute(infixToPostfix(info));
            }
        });

        btn_Mul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign>=1)
                { }
                else{
                ed1.setText(ed1.getText() + "*");
                info+=" * ";
                dot=0;sign++;
            }}
        });
        btn_Div.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign>=1)
                { }
                else{dot=0;sign++;
                ed1.setText(ed1.getText() + "/");
                info+=" / ";
            }}
        });
        btn_Sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign>=1)
                { }
                else{
                dot=0;sign++;
                ed1.setText(ed1.getText() + "-");
                info+=" - ";
            }}
        });
        btn_root.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign>=1)
                { }
                else
                {
                dot=0;sign++;
                info+=" $ ";
                ed1.setText(ed1.getText() + "√");
            }}
        });
        btn_exp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                if(sign>=1)
                { }
                else{
                    info+=" ^ ";
                sign++;
                dot=0;
                ed1.setText(ed1.getText() + "^");
            }}
        });
        btn_clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                ed1.setText("");
                ed2.setText("");
                info="";
                dot=0;
                sign=0;
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
            info=info.substring(0,info.length()-1);
            if(info.charAt(info.length()-2)==' ' )
            {
                info=info.substring(0,info.length()-2);
            }
           String help=ed1.getText().toString();
                help=help.substring(0,help.length()-1);
                if(help.charAt(help.length()-2)==' ' )
                {
                    help=help.substring(0,help.length()-2);
                }
                ed1.setText(help);
                sign=0;
                dot=0;
            }
        });
        
    }
    
}
