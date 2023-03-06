package com.example.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonCanal = findViewById(R.id.cambiar);
        EditText etCanal = findViewById(R.id.Canal);
        TextView texto = findViewById(R.id.canaltexto);
        Spinner spinner = findViewById(R.id.SpinnerProgramas);
        imageView = findViewById(R.id.imagen);

        spinner.setOnItemSelectedListener(this);
        buttonCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etCanal.getText().toString();
                Toast.makeText(MainActivity.this, "El valor era " + text, Toast.LENGTH_LONG).show();
                texto.setText(text);
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Nada
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int valor, long l) {
        String item = adapterView.getItemAtPosition(valor).toString();
        Snackbar.make(adapterView, "Se eligio el programa:  " + item, Snackbar.LENGTH_LONG).show();

        if (valor == 0){
            imageView.setImageResource(R.drawable.continuea);
        } else if (valor == 1){
            imageView.setImageResource(R.drawable.continueb);
        } else {
            imageView.setImageResource(R.drawable.continuec);
        }
    }


}