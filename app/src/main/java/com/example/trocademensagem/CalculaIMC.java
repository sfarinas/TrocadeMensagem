package com.example.trocademensagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CalculaIMC extends AppCompatActivity {
    EditText editTextPeso, editTextAltura, editTextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_imc);
        editTextNome = findViewById(R.id.editTextNome);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);

        String nome = getIntent().getExtras().getString("nome");
        editTextNome.setText(nome);
    }

    public void calcularVoltar(View view){
        double peso, altura, imc;

        peso = Double.parseDouble(editTextPeso.getText().toString());
        altura = Double.parseDouble(editTextAltura.getText().toString());

        imc = peso / Math.pow(altura,2);
        Toast.makeText(getApplicationContext(), "IMC ="+String.valueOf(imc),
                Toast.LENGTH_LONG).show();

        Intent returnIntent = new Intent();

        returnIntent.putExtra("imc", imc);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}










