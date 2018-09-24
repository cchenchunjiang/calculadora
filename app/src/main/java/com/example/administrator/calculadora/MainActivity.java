package com.example.administrator.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String input;//输入框内容
    private List<BigDecimal> number1;//存放每次进过运算符计算后的结果
    private String temp;//当前输入的算数
    private BigDecimal outnumber;//每次计算的结果,临时结果
    private boolean error;//计算报错
    private List<Integer> com;//记录没次计算符的位置，与number1对应
    private List<String> coy;//记录每次计算符
    private List<Boolean> point;//记录没次运算数是否包含小数点
    private boolean charcheck;   //为false，数字未输入，不可以输入算数符
    private boolean pointcheck2; //为false，小数点未在数字输入后，不能输入 .。
    private boolean getnumber;//为fasle，计算未开始，用户位输入任何运算符。

    //
    TextView result1;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = "";
        temp = "";
        error = false;
        number1 = new ArrayList<>();
        com = new ArrayList<>();
        coy = new ArrayList<>();
        point = new ArrayList<>();
        point.add(false);
        charcheck = false;//为false，数字未输入，不可以输入算数符
        pointcheck2 = false;//为false，小数点未在数字输入后，不能输入 .。
        getnumber = false;//为fasle，计算未开始，用户位输入任何运算符。
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        Button jia = findViewById(R.id.jia);
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (charcheck == true) {
                    input += "+";
                    coy.add("+");
                    charclick();
                }
            }
        });
        Button jian = findViewById(R.id.jian);
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if (input.length() > 1)
                    s = input.substring(input.length() - 1, input.length());
                if (input.length() == 0 || s.equals("*") || s.equals("/")) {
                    input += "-";
                    temp += "-";
                    result1.setText(input);
                } else if (s.equals("+")) {
                    input = input.substring(0, input.length() - 1) +"-";
                    coy.set(coy.size()-1,"-");
                    result1.setText(input);
                } else if (charcheck == true) {
                    input += "-";
                    coy.add("-");
                    charclick();
                }
            }

        });
        Button shen = findViewById(R.id.shen);
        shen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (charcheck == true) {
                    input += "*";
                    coy.add("*");
                    charclick();
                }
            }

        });
        Button chu = findViewById(R.id.chu);
        chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (charcheck == true) {
                    input += "/";
                    coy.add("/");
                    charclick();
                }
            }

        });
        Button shu0 = findViewById(R.id.shu0);
        shu0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                temp += "0";
                numberonclick();
            }

        });
        Button shu1 = findViewById(R.id.shu1);
        shu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                temp += "1";
                numberonclick();
            }
        });
        Button shu2 = findViewById(R.id.shu2);
        shu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "2";
                temp += "2";
                numberonclick();
            }

        });
        Button shu3 = findViewById(R.id.shu3);
        shu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "3";
                temp += "3";
                numberonclick();
            }

        });
        Button shu4 = findViewById(R.id.shu4);
        shu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "4";
                temp += "4";
                numberonclick();

            }

        });
        Button shu5 = findViewById(R.id.shu5);
        shu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "5";
                temp += "5";
                numberonclick();
            }

        });
        Button shu6 = findViewById(R.id.shu6);
        shu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                temp += "6";
                numberonclick();
            }

        });
        Button shu7 = findViewById(R.id.shu7);
        shu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                temp += "7";
                numberonclick();
            }

        });
        Button shu8 = findViewById(R.id.shu8);
        shu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                temp += "8";
                numberonclick();
            }

        });
        Button shu9 = findViewById(R.id.shu9);
        shu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                temp += "9";
                numberonclick();
            }

        });
        Button to2 = findViewById(R.id.to2);
        to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.length()>0){
                    input=Integer.toBinaryString(Integer.parseInt(input));
                    result2.setText(input);
                    input="";
                    temp="";
                }
            }

        });
        Button to10 = findViewById(R.id.to10);
        to10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.length()>0){
                    input=String.valueOf(Integer.parseInt(input,2));
                    result2.setText(input);
                    input="";
                    temp="";
                }
            }

        });
        Button to16 = findViewById(R.id.to16);
        to16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.length()>0){
                    input=Integer.toHexString(Integer.parseInt(input));
                    result2.setText(input);
                    input="";
                    temp="";
                }
            }

        });
        Button to11 = findViewById(R.id.to11);
        to11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.length()>0){
                    input= input=String.valueOf(Integer.parseInt(input,16));
                    result2.setText(input);
                    input="";
                    temp="";
                }
            }

        });
        Button bai = findViewById(R.id.bai);
        bai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";
                if (input.length() >= 1) {
                    s = input.substring(input.length() - 1, input.length());
                    if ((!s.equals("*") && !s.equals("/") && !s.equals("+") && !s.equals("-")) || getnumber == false) {
                        input += "%";
                        number1.add(outnumber);
                        coy.add("%");
                        com.add(input.length());
                        outnumber = compute(outnumber, "100", "/");
                        temp = "";
                        point.add(false);
                        pointcheck2 = false;
                        getnumber = true;
                        result1.setText(input);
                        result2.setText(outnumber.toString());
                    }
                }
            }

        });
        Button dian = findViewById(R.id.dian);
        dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointcheck2 == true && point.get(point.size() - 1) == false) {
                    input += ".";
                    temp += ".";
                    result1.setText(input);
                    point.set(point.size() - 1, true);
                }
            }

        });
        final Button result = findViewById(R.id.result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.equals("-")) {
                    result1.setText(outnumber.toString());
                    result2.setText("");
                    input = outnumber.toString();
                    temp = outnumber.toString();
                    number1 = new ArrayList<>();
                    com = new ArrayList<>();
                    coy = new ArrayList<>();
                    point = new ArrayList<>();
                    if (temp.split("\\.").length > 1)
                        point.add(true);
                    else
                        point.add(false);
                    charcheck = true;
                    pointcheck2 = true;
                    getnumber = false;
                }
            }
        });
        Button c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = "";
                temp = "";
                error = false;
                number1 = new ArrayList<>();
                charcheck = false;
                point = new ArrayList<>();
                point.add(false);
                pointcheck2 = false;
                getnumber = false;
                com = new ArrayList<>();
                coy = new ArrayList<>();
                result1.setText("");
                result2.setText("");
            }

        });
        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() > 0) {
                    String s = input.substring(input.length() - 1, input.length());
                    input = input.substring(0, input.length() - 1);
                    if (coy.size() == 0) {
                        if (s.equals("."))
                            point.set(point.size() - 1, false);
                        if (input.equals("-") || input.equals(""))
                            pointcheck2 = false;
                        if (!input.equals("-") && !input.equals(""))
                            outnumber = new BigDecimal(input);
                        result1.setText(input);
                        result2.setText("");
                    } else if ((input.length() + 1) == com.get(coy.size() - 1) && !coy.isEmpty()) {
                        if (coy.size() == 1)
                            getnumber = false;
                        outnumber = number1.get(number1.size() - 1);
                        number1.remove(number1.size() - 1);
                        com.remove(com.size() - 1);
                        coy.remove(coy.size() - 1);
                        point.remove(point.size() - 1);
                        result1.setText(input);
                        temp = "";
                        charcheck = true;
                        result2.setText(outnumber.toString());
                    } else if ((input.length() + 1) > com.get(coy.size() - 1) && coy.size() > 0) {
                        if (s.equals(".")) {
                            point.set(point.size() - 1, false);
                        }
                        temp = input.substring(com.get(com.size() - 1), input.length());
                        if (temp.equals("-") || temp.equals("")) {
                            pointcheck2 = false;
                            outnumber = number1.get(number1.size() - 1);
                        }
                        if (!temp.equals("-") && !temp.equals("")) {
                            outnumber = compute(number1.get(number1.size() - 1), temp, coy.get(coy.size() - 1));
                        }
                        result1.setText(input);
                        result2.setText(outnumber.toString());
                    }
                }
            }
        });
    }

    //运算符相同操作
    public void charclick() {
        charcheck = false;
        point.add(false);
        pointcheck2 = false;
        getnumber = true;
        com.add(input.length());
        number1.add(outnumber);
        temp = "";
        result1.setText(input);
    }

    //数字键相同操作
    public void numberonclick() {
        charcheck = true;
        pointcheck2 = true;
        if (getnumber == false) {
            outnumber = new BigDecimal(input);
            result1.setText(input);
        } else {
            result1.setText(input);
            outnumber = compute(number1.get(number1.size() - 1), temp, coy.get(coy.size() - 1));
            Log.v("asd",outnumber.toString());
            if (error == true) {
                result2.setText("错误");
                error = false;
            } else
                result2.setText(outnumber.toString());
        }
    }



    //运算
    public BigDecimal compute(BigDecimal out, String s, String symbol) {
        BigDecimal num = new BigDecimal(s);
        switch (symbol) {
            case "%":
                return new BigDecimal(out.divideAndRemainder(num)[1].toString());
            case "+":
                return out.add(num);
            case "-":
                return out.subtract(num);
            case "*":
                return out.multiply(num);
            case "/":
                if (num.toString().equals("0")) {
                    error = true;
                    return out;
                } else
                    return out.divide(num, 10, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.ok:
                Intent intent=new Intent(MainActivity.this,Main2.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
