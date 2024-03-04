package com.example.trocademensagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent intent1, intent2;
    EditText etNome, etSeuIMC, etSituacao;
    static final int ACTIVITY_REQUEST_IMC = 1;
    static final int ACTIVITY_REQUEST_SITUACAO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNome = findViewById(R.id.etNome);
        etSeuIMC = findViewById(R.id.etSeuIMC);
        etSituacao = findViewById(R.id.etSituacao);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST_IMC) {
            if (resultCode == RESULT_OK) {
                double imc = data.getDoubleExtra("imc", 0);
                etSeuIMC.setText(String.format("%.2f", imc));
            }
        }
        if (requestCode == ACTIVITY_REQUEST_SITUACAO) {
            if (resultCode == RESULT_OK) {
                String situacao = data.getStringExtra("situacao");
                etSituacao.setText(situacao);
            }
        }
    }

    public void chamarCalcularIMC(View view){
        intent1 = new Intent(getApplicationContext(), CalculaIMC.class);
        intent1.putExtra("nome", etNome.getText().toString());
        startActivityForResult(intent1, ACTIVITY_REQUEST_IMC);
    }

    public void chamarVerificarSituacao(View view){
        intent2 = new Intent(getApplicationContext(), Situacao.class);
        intent2.putExtra("nome", etSituacao.getText().toString());
        intent2.putExtra("imc", Double.parseDouble(etSeuIMC.getText().toString()));
        startActivityForResult(intent2, ACTIVITY_REQUEST_SITUACAO);
    }
}












