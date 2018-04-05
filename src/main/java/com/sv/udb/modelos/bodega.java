/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante
 */
public class bodega {
    
    private int codibode;
    private piezas codipiez;
    private proveedores codiprov;
    private int cant;
    private String date;

    public bodega(int codibode, piezas codipiez, proveedores codiprov, int cant, String date) {
        this.codibode = codibode;
        this.codipiez = codipiez;
        this.codiprov = codiprov;
        this.cant = cant;
        this.date = date;
    }

    public int getCodibode() {
        return codibode;
    }

    public void setCodibode(int codibode) {
        this.codibode = codibode;
    }

    public piezas getCodipiez() {
        return codipiez;
    }

    public void setCodipiez(piezas codipiez) {
        this.codipiez = codipiez;
    }

    public proveedores getCodiprov() {
        return codiprov;
    }

    public void setCodiprov(proveedores codiprov) {
        this.codiprov = codiprov;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return codibode + ", codipiez=" + codipiez + ", codiprov=" + codiprov + ", cant=" + cant + ", date=" + date + '}';
    }

    
    
    
    
}
