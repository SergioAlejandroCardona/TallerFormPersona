package com.example.formpersona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    private String Nombre;
    private String Nit;
    List<Empleado> empleadoList = new ArrayList<>();
    List<String> cargosList = new ArrayList<>();

    public Empresa(String nombre, String nit, List<Empleado> empleadoList, List<String> cargosList) {
        Nombre = nombre;
        Nit = nit;
        this.empleadoList = empleadoList;
        this.cargosList = cargosList;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        Nit = nit;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<String> getCargosList() {
        return cargosList;
    }

    public void setCargosList(List<String> cargosList) {
        this.cargosList = cargosList;
    }


    public List<Empleado> empleadoMasJoven(){

        List<Empleado> listEmpleados = new ArrayList<>();
        int EdadMenor;
        Empleado emple = empleadoList.get(0);
        EdadMenor = emple.getEdad();

        for (Empleado emp: empleadoList)
        {
            if (EdadMenor >= emp.getEdad())
            {
                EdadMenor = emp.getEdad();
            }
        }

        for (Empleado emp: empleadoList)
        {
            if (EdadMenor == emp.getEdad())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public List<Empleado> empleadoMasViejo(){

        List<Empleado> listEmpleados = new ArrayList<>();
        int EdadMayor;
        Empleado emple = empleadoList.get(0);
        EdadMayor = emple.getEdad();

        for (Empleado emp: empleadoList)
        {
            if (EdadMayor <= emp.getEdad())
            {
                EdadMayor = emp.getEdad();
            }
        }

        for (Empleado emp: empleadoList)
        {
            if (EdadMayor == emp.getEdad())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public List<Empleado> salarioMasAlto(){

        List<Empleado> listEmpleados = new ArrayList<>();
        double SalarioMayor;
        Empleado emple = empleadoList.get(0);
        SalarioMayor = emple.getSalario();

        for (Empleado emp: empleadoList)
        {
            if (SalarioMayor <= emp.getSalario())
            {
                SalarioMayor = emp.getSalario();
            }
        }

        for (Empleado emp: empleadoList)
        {
            if (SalarioMayor == emp.getSalario())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public List<Empleado> salarioMasBajo(){

        List<Empleado> listEmpleados = new ArrayList<>();
        double SalarioMenor;
        Empleado emple = empleadoList.get(0);
        SalarioMenor = emple.getSalario();

        for (Empleado emp: empleadoList)
        {
            if (SalarioMenor >= emp.getSalario())
            {
                SalarioMenor = emp.getSalario();
            }
        }

        for (Empleado emp: empleadoList)
        {
            if (SalarioMenor == emp.getSalario())
            {
                listEmpleados.add(emp);
            }
        }

        return listEmpleados;
    }

    public double promedioSalarios(){

        int cont = 0;
        double totalSalarios = 0;

        for (Empleado emp: empleadoList)
        {
            totalSalarios = totalSalarios + emp.getSalario();
            cont++;
        }

        double promedio = totalSalarios / cont;

        return promedio;
    }

    public String ponderadoCargos(){

        int cont = 0;
        double promedio = 0;
        double suma = 0;
        String informe = "";

        for (int i = 0; i <= cargosList.size()-1; i++){

            for (int j = 0; j <= empleadoList.size()-1; j++){

                if (cargosList.get(i).equals(empleadoList.get(j).getCargo())){

                    cont = cont + 1;
                    suma = suma + empleadoList.get(j).getSalario();
                }else {

                    suma = suma + 0;
                    cont = cont + 0;
                }
            }

            if (cont == 0){
                promedio = 0;
            }else {
                promedio = suma/cont;
            }

            informe = informe + "\n" + "* Cargo: " + cargosList.get(i) + "\n-- # de empleados cargo: " + cont
                    + "\n-- Promedio Salarios cargo: " + promedio;
            cont = 0;
            suma = 0;
        }

        return informe;
    }

}
