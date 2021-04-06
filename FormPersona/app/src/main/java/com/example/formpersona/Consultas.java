package com.example.formpersona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Consultas extends AppCompatActivity implements View.OnClickListener {

    private Spinner spTiposConsultas;
    private Button btConsultar;
    private TextView tvResultadoConsulta;
    private Button btAtras2;

    private Empresa empresa;
    private List<Empleado> empleadosResultado = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        Intent intent = getIntent();
        empresa = (Empresa) intent.getSerializableExtra("empresa");

        spTiposConsultas = findViewById(R.id.spTiposConsultas);
        btConsultar = findViewById(R.id.btnConsultar);
        tvResultadoConsulta = findViewById(R.id.tvResultadoConsulta);
        btAtras2 = findViewById(R.id.btnAtras2);

        btConsultar.setOnClickListener(this);
        btAtras2.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options_array,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spTiposConsultas.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConsultar)
        {
            int IdSeleccion = (int)spTiposConsultas.getSelectedItemId();

            switch (IdSeleccion)
            {
                case 0:
                    String ResultadoLista = "El empleado mas joven es: \n";
                    empleadosResultado = empresa.empleadoMasJoven();
                    for (int i = 0; i <= empleadosResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ empleadosResultado.get(i).getNombres()
                                + " " + empleadosResultado.get(i).getApellidos()
                                + "\nEdad: " + empleadosResultado.get(i).getEdad();
                    }
                    tvResultadoConsulta.setText(ResultadoLista);

                    break;
                case 1:
                    ResultadoLista = "El empleado mas viejo es: \n";
                    empleadosResultado = empresa.empleadoMasViejo();
                    for (int i = 0; i <= empleadosResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ empleadosResultado.get(i).getNombres()
                                + " " + empleadosResultado.get(i).getApellidos()
                                + "\nEdad: " + empleadosResultado.get(i).getEdad();
                    }
                    tvResultadoConsulta.setText(ResultadoLista);

                    break;
                case 2:
                    ResultadoLista = "El empleado con salario mas alto es: \n";
                    empleadosResultado = empresa.salarioMasAlto();
                    for (int i = 0; i <= empleadosResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ empleadosResultado.get(i).getNombres()
                                + " " + empleadosResultado.get(i).getApellidos()
                                + "\nSalario: " + empleadosResultado.get(i).getSalario();
                    }
                    tvResultadoConsulta.setText(ResultadoLista);

                    break;
                case 3:
                    ResultadoLista = "El empleado con salario mas bajo es: \n";
                    empleadosResultado = empresa.salarioMasBajo();
                    for (int i = 0; i <= empleadosResultado.size()-1; i++){
                        ResultadoLista = ResultadoLista + "\n" + "Nombre: "+ empleadosResultado.get(i).getNombres()
                                + " " + empleadosResultado.get(i).getApellidos()
                                + "\nSalario: " + empleadosResultado.get(i).getSalario();
                    }
                    tvResultadoConsulta.setText(ResultadoLista);

                    break;
                case 4:
                    ResultadoLista = "El promedio de los salarios es: \n";

                    double promedio = empresa.promedioSalarios();

                    tvResultadoConsulta.setText(ResultadoLista + "\n" + promedio);

                    break;
                case 5:
                    String informe = "";
                    informe = empresa.ponderadoCargos();
                    tvResultadoConsulta.setText(informe);

                    break;
            }
        }

        if (v.getId() == R.id.btnAtras2)
        {
            Intent myIntentPrincipal = new Intent(this, MainActivity.class);
            startActivity(myIntentPrincipal);
        }

    }
}