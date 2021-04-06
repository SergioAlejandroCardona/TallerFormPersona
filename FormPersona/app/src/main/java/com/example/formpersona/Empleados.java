package com.example.formpersona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Empleados extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombres;
    private EditText etApellidos;
    private EditText etEdad;
    private EditText etEmail;
    private Spinner spCargo;
    private EditText etSalario;
    private Button btAgregar;
    private Button btAtras1;

    static List<Empleado> empleadoList = new ArrayList<>();

    private Empresa empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        etNombres = findViewById(R.id.txtNombres);
        etApellidos = findViewById(R.id.txtApellidos);
        etEdad = findViewById(R.id.etnEdad);
        etEmail = findViewById(R.id.eteEmail);
        spCargo = findViewById(R.id.spCargo);
        etSalario = findViewById(R.id.eddSalario);
        btAgregar = findViewById(R.id.btnAgregar);
        btAtras1 = findViewById(R.id.btnAtras1);

        btAgregar.setOnClickListener(this);
        btAtras1.setOnClickListener(this);

        Intent intent = getIntent();
        empresa = (Empresa) intent.getSerializableExtra("empresa");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,empresa.getCargosList());
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spCargo.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar)
        {

            String nombres = etNombres.getText().toString();
            String apellidos = etApellidos.getText().toString();
            String edad = etEdad.getText().toString();
            String email = etEmail.getText().toString();
            String salario = etSalario.getText().toString();

            if(nombres.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar los Nombres", R.layout.custom_toast).show();
                return;
            }
            if(apellidos.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar los Apellidos", R.layout.custom_toast).show();
                return;
            }
            if(edad.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar la Edad", R.layout.custom_toast).show();
                return;
            }
            if(!isValidEmail(email)){
                CustomToastView.makeInfoToast(this, "Error al validar el Email", R.layout.custom_toast).show();
                return;
            }
            if(salario.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar el Salario", R.layout.custom_toast).show();
                return;
            }

            AgregarEmpleado();
            LimpiarCampos();
            CustomToastView.makeSuccessToast(this, "Empleado agregado correctamente",R.layout.custom_toast).show();
        }

        if (v.getId() == R.id.btnAtras1)
        {
            Intent myIntentPrincipal = new Intent(this, MainActivity.class);
            myIntentPrincipal.putExtra("lista_empleados", (Serializable) empleadoList);
            startActivity(myIntentPrincipal);
        }

    }

    private void AgregarEmpleado() {

        Empleado empleado = new Empleado(etNombres.getText().toString(),etApellidos.getText().toString(),
                Integer.parseInt(etEdad.getText().toString()),etEmail.getText().toString(),spCargo.getSelectedItem().toString(),
                Double.parseDouble(etSalario.getText().toString()));

        empleadoList.add(empleado);
    }

    private void LimpiarCampos(){

        etNombres.setText("");
        etApellidos.setText("");
        etEdad.setText("");
        etEmail.setText("");
        spCargo.setSelection(0);
        etSalario.setText("");
    }

    private boolean isValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


}