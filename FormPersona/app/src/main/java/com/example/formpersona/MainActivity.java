package com.example.formpersona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btNuevoEmpleado;
    private Button btConsultas;

    private List<Empleado> empleadoList = new ArrayList<>();
    private List<String> cargosList = new ArrayList<>();

    private Empresa empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargosList.add("Gerente");
        cargosList.add("Desarrollador");
        cargosList.add("Soporte");
        cargosList.add("QA");
        cargosList.add("Secretaria");
        cargosList.add("Vigilante");

        Intent intent = getIntent();
        empleadoList = (List<Empleado>) intent.getSerializableExtra("lista_empleados");

        empresa = new Empresa("Future Asociados", "123456789", empleadoList, cargosList);

        btNuevoEmpleado = findViewById(R.id.btnNuevoEmpleado);
        btConsultas = findViewById(R.id.btnConsultas);

        btNuevoEmpleado.setOnClickListener(this);
        btConsultas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNuevoEmpleado)
        {
            Intent myIntentEmpleados = new Intent(this, Empleados.class);
            myIntentEmpleados.putExtra("empresa", (Serializable) empresa);
            startActivity(myIntentEmpleados);
        }
        if (v.getId() == R.id.btnConsultas)
        {
            Intent myIntentConsultas = new Intent(this, Consultas.class);
            myIntentConsultas.putExtra("empresa", (Serializable) empresa);
            startActivity(myIntentConsultas);
        }
    }
}