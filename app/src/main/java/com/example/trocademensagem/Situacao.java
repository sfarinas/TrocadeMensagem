package com.example.trocademensagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Situacao extends AppCompatActivity {
    EditText etIdade, etNomeSitu, etIMCSitu;
    RadioButton rbFeminino, rbMasculino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situacao);
        etNomeSitu = findViewById(R.id.etNomeSitu);
        etIdade = findViewById(R.id.etIdade);
        etIMCSitu = findViewById(R.id.etIMCSitu);
        rbFeminino = findViewById(R.id.rbFeminino);
        rbMasculino = findViewById(R.id.rbMasculino);

        etNomeSitu.setText(getIntent().getExtras().getString("nome"));
        etIMCSitu.setText(String.format("%.2f", getIntent().getExtras().getDouble("imc")));
    }

    public void verificarVoltar(View view){
        String situacao = "";
        double imc = Double.parseDouble(etIMCSitu.getText().toString());
        int idade = Integer.parseInt(etIdade.getText().toString());
        int sexo = 0;
        if (rbFeminino.isChecked()){
            sexo = 1;
        }
        if (rbMasculino.isChecked()){
            sexo = 2;
        }
        if (idade == 1) {
            situacao = "Idade fora da faixa. Situacao nao determinada";
        } else {
            if (sexo == 1){
                if (imc < 19.1){
                    situacao = "Abaixo do peso";
                } else {
                    if (imc < 25.8){
                        situacao = "No peso Normal";
                    } else {
                        if (imc < 27.3){
                            situacao = "Marginalmente acima do peso";
                        } else {
                            if (imc < 32.3){
                                situacao = "Acima do peso";
                            }else {
                                situacao = "Obesa";
                            }
                        }
                    }
                }
            } else {
                if (imc < 20.7){
                    situacao = "Abaixo do peso";
                } else {
                    if (imc < 26.4){
                        situacao = "No peso Normal";
                    } else {
                        if (imc < 27.8){
                            situacao = "Marginalmente acima do peso";
                        } else {
                            if (imc < 31.1){
                                situacao = "Acima do peso";
                            }else {
                                situacao = "Obeso";
                            }
                        }
                    }
                }

            }
        }
        Intent returnIntent = new Intent();
        returnIntent.putExtra("situacao", situacao);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}










