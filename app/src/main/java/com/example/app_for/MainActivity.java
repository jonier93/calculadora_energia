package com.example.app_for;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText horas;
    private EditText bombilla;
    private EditText led;
    private TextView energia_bombilla;
    private TextView energia_led;
    private Button btnCalcular;
    private int horas_transcurridas;
    private double kwh_bombilla;
    private double kwh_led;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar_componentes();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                establecerDatos();
                double resultado_energia_bombilla = calcular_bombilla(horas_transcurridas, kwh_bombilla);
                double resultado_energia_led = calcular_led(horas_transcurridas, kwh_led);
                imprimirDatos(resultado_energia_bombilla, resultado_energia_led);
            }
        });
    }

    private void inicializar_componentes (){
        horas = (EditText) findViewById(R.id.txtHoras);
        bombilla = (EditText) findViewById(R.id.txtBombilla);
        led = (EditText) findViewById(R.id.txtLed);
        energia_bombilla = (TextView) findViewById(R.id.txtEnergiaBombilla);
        energia_led = (TextView) findViewById(R.id.txtEnergiaLed);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }

    private double calcular_bombilla(int horas_transcurridas, double kwh_bombilla){
        double resultado_energia_bombilla = 0;
        for (int i=1; i<=horas_transcurridas; i++){
            resultado_energia_bombilla += kwh_bombilla;
        }
        return resultado_energia_bombilla;
    }
    private double calcular_led(int horas_transcurridas, double kwh_led) {
        double resultado_energia_led = 0;
        for (int i=1; i<=horas_transcurridas; i++){
            resultado_energia_led += kwh_led;
        }
        return resultado_energia_led;
    }
    private void establecerDatos(){
        horas_transcurridas = Integer.parseInt(horas.getText().toString());
        kwh_bombilla = Double.parseDouble(bombilla.getText().toString());
        kwh_led = Double.parseDouble(led.getText().toString());
    }

    private void imprimirDatos(double resultado_energia_bombilla, double resultado_energia_led){
        energia_bombilla.setText(String.valueOf(resultado_energia_bombilla));
        energia_led.setText(String.valueOf(resultado_energia_led));
    }

}