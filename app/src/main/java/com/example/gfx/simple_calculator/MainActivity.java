package com.example.gfx.simple_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String var_aux = "";
    private EditText painel;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSoma, btnSub, btnDiv, btnMult, btnEqual, btnPonto, btnCA, btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnMult = findViewById(R.id.buttonMult);
        btnSoma = findViewById(R.id.buttonSoma);
        btnSub = findViewById(R.id.buttonSubtracao);
        btnDiv = findViewById(R.id.buttonDiv);
        btnEqual = findViewById(R.id.buttonIgualdade);
        btnPonto = findViewById(R.id.buttonPonto);
        btnCA = findViewById(R.id.buttonCA);
        btnDelete = findViewById(R.id.buttonDelete);
        painel = findViewById(R.id.editText2);


        onCLickEvent();

    }

    private void onCLickEvent() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSoma.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnCA.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnPonto.setOnClickListener(this);

        painel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 12 && count < 20) {
                    painel.setTextSize(30);
                } else if (count >= 20) {
                    painel.setTextSize(20);
                } else {
                    painel.setTextSize(50);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void conversion(String s) {
        ArrayList<String> expression = new ArrayList();

        for (int i = 0; i < s.length(); ++i) {
            String string = s.substring(i, i + 1);
            if (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("x")) {
                expression.add(String.valueOf(string));
            }
        }

        String[] separador = s.split("[+ |\\ \\- |\\ / |\\ x]");
        ArrayList<String> array = new ArrayList();
        String[] string = separador;

        for (String v : string) {
            array.add(v);
        }

        double total;
        for (int i = 0; expression.size() != 0; array.add(0, String.valueOf(total))) {
            double numero1 = Double.parseDouble((String) array.get(0));
            double numero2 = Double.parseDouble((String) array.get(1));
            String operador = (String) expression.get(0);
            total = 0.0D;
            total = executarOperacao(numero1, numero2, operador);
            array.remove(0);
            expression.remove(0);
            if (i == 0) {
                array.remove(0);
                ++i;
            }
        }

        this.painel.setText((CharSequence) array.get(0));
        this.var_aux = (String) array.get(0);
    }

    private double executarOperacao(double numero1, double numero2, String operador) {
        double resultado = 0.0;
        if (operador.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operador.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operador.equals("/")) {
            resultado = numero1 / numero2;
        } else if (operador.equals("x")) {
            resultado = numero1 * numero2;
        }

        return resultado;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                painel.setText(var_aux + btn0.getText().toString());
                var_aux += "0";
                break;
            case R.id.button1:
                painel.setText(var_aux + btn1.getText().toString());
                var_aux += "1";
                break;
            case R.id.button2:
                painel.setText(var_aux + btn2.getText().toString());
                var_aux += "2";
                break;
            case R.id.button3:
                painel.setText(var_aux + btn3.getText().toString());
                var_aux += "3";
                break;
            case R.id.button4:
                painel.setText(var_aux + btn4.getText().toString());
                var_aux += "4";
                break;
            case R.id.button5:
                painel.setText(var_aux + btn5.getText().toString());
                var_aux += "5";
                break;
            case R.id.button6:
                painel.setText(var_aux + btn6.getText().toString());
                var_aux += "6";
                break;
            case R.id.button7:
                painel.setText(var_aux + btn7.getText().toString());
                var_aux += "7";
                break;
            case R.id.button8:
                painel.setText(var_aux + btn8.getText().toString());
                var_aux += "8";
                break;
            case R.id.button9:
                painel.setText(var_aux + btn9.getText().toString());
                var_aux += "9";
                break;
            case R.id.buttonMult:
                painel.setText(var_aux + btnMult.getText().toString());
                var_aux += "x";
                break;
            case R.id.buttonSoma:
                painel.setText(var_aux + btnSoma.getText().toString());
                var_aux += "+";
                break;
            case R.id.buttonSubtracao:
                painel.setText(var_aux + btnSub.getText().toString());
                var_aux += "-";
                break;
            case R.id.buttonDiv:
                painel.setText(var_aux + btnDiv.getText().toString());
                var_aux += "/";
                break;
            case R.id.buttonPonto:
                painel.setText(var_aux + btnPonto.getText().toString());
                var_aux += ".";
                break;
            case R.id.buttonDelete:
                deletar(1);
                break;
            case R.id.buttonCA:
                deletar(2);
                break;
            case R.id.buttonIgualdade:
                conversion(var_aux);
                break;
        }
    }

    public void deletar(int type) {
        if (type == 1) {
            if (var_aux.length() > 1) {
                var_aux = var_aux.substring(1, var_aux.length());
                painel.setText(var_aux);
            } else {
                painel.setText("");
                var_aux = "";
            }
        } else {
            painel.setText("");
            var_aux = "";
        }
    }
}
