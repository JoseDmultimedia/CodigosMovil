package com.example.medsnow;

public class Farmacia {

    private String medName;
    private String codigo;
    private String farmaciaName;
    private double valor;
    private int cantidad;


    public Farmacia() {
    }

    public Farmacia(String medName, String codigo, String farmaciaName, double valor, int cantidad, String fotoUrl) {
        this.medName = medName;
        this.codigo = codigo;
        this.farmaciaName = farmaciaName;
        this.valor = valor;
        this.cantidad = cantidad;

    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFarmaciaName() {
        return farmaciaName;
    }

    public void setFarmaciaName(String farmaciaName) {
        this.farmaciaName = farmaciaName;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Medicamento { ---------" + "\n" +
                "Nombre Medicamento ='" + medName + '\'' + "\n" +
                "Codigo Medicamento ='" + codigo + '\'' + "\n" +
                "Nombre Farmacia ='" + farmaciaName + '\'' + "\n" +
                "Precio =" + valor + "\n" +
                "Cantidad Disponible =" + cantidad + "\n" +
                "-----------" +'}';
    }
}
