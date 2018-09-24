package com.example.administrator.calculadora;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {

    String input;
    TextView result1;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        input="";
        result1 = findViewById(R.id.aresult1);
        result2 = findViewById(R.id.aresult2);
        Button jia = findViewById(R.id.ajia);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="+";
                result1.setText(input);
            }
        });
        Button jian = findViewById(R.id.ajian);
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="-";
                result1.setText(input);
            }

        });
        Button shen = findViewById(R.id.ashen);
        shen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="*";
                result1.setText(input);
            }

        });
        Button chu = findViewById(R.id.achu);
        chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="/";
                result1.setText(input);
            }

        });
        Button shu0 = findViewById(R.id.ashu0);
        shu0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="0";
                result1.setText(input);
            }

        });
        Button shu1 = findViewById(R.id.ashu1);
        shu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="1";
                result1.setText(input);
            }
        });
        Button shu2 = findViewById(R.id.ashu2);
        shu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="2";
                result1.setText(input);
            }

        });
        Button shu3 = findViewById(R.id.ashu3);
        shu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="3";
                result1.setText(input);
            }

        });
        Button shu4 = findViewById(R.id.ashu4);
        shu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="4";
                result1.setText(input);
            }

        });
        Button shu5 = findViewById(R.id.ashu5);
        shu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="5";
                result1.setText(input);
            }

        });
        Button shu6 = findViewById(R.id.ashu6);
        shu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                result1.setText(input);

            }

        });
        Button shu7 = findViewById(R.id.ashu7);
        shu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                result1.setText(input);
            }

        });
        Button shu8 = findViewById(R.id.ashu8);
        shu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                result1.setText(input);
            }

        });
        Button shu9 = findViewById(R.id.ashu9);
        shu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                result1.setText(input);
            }

        });
        Button zuo = findViewById(R.id.zuo);
        zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="(";
                result1.setText(input);
            }

        });
        Button dian = findViewById(R.id.adian);
        dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+=".";
                result1.setText(input);
            }

        });
        final Button result = findViewById(R.id.aresult);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute compute=new Compute();
                String ss;
                ss=compute.encodeing(input);
                if(ss.length()>20)
                  ss=ss.substring(0,20);
                result2.setText(ss);
            }
        });
        Button c = findViewById(R.id.ac);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input="";
                result1.setText(input);
                result2.setText(input);
            }
        });
        Button delete = findViewById(R.id.adelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=input.substring(0,input.length()-1);
                result1.setText(input);
            }
        });
        Button you = findViewById(R.id.you);
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+=")";
                result1.setText(input);
            }
        });
        Button sin = findViewById(R.id.sin);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="sin";
                result1.setText(input);
            }
        });
        Button cos = findViewById(R.id.cos);
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="cos";
                result1.setText(input);
            }
        });
        Button tan = findViewById(R.id.tan);
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="tan";
                result1.setText(input);
            }
        });
        Button pai = findViewById(R.id.pai);
        pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="π";
                result1.setText(input);
            }
        });
        Button sqrt = findViewById(R.id.sqrt);
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="√";
                result1.setText(input);
            }
        });
        Button index = findViewById(R.id.index);
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="^";
                result1.setText(input);
            }
        });
        Button square = findViewById(R.id.square);
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="[^2";
                result1.setText(input);
            }
        });
        Button log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="log";
                result1.setText(input);
            }
        });
    }
}
