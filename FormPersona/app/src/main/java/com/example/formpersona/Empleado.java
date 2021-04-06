package com.example.formpersona;

import java.io.Serializable;

public class Empleado implements Serializable {

    private String Nombres;
    private String Apellidos;
    private int Edad;
    private String Email;
    private String Cargo;
    private double Salario;

    public Empleado(String nombres, String apellidos, int edad, String email, String cargo, double salario) {
        Nombres = nombres;
        Apellidos = apellidos;
        Edad = edad;
        Email = email;
        Cargo = cargo;
        Salario = salario;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }


}
