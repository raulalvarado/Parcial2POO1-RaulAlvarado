/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.piezas;
import com.sv.udb.modelos.proveedores;
import com.sv.udb.modelos.bodega;
import com.sv.udb.recursos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class controlBodega {
    
    private final Connection conect;

    public controlBodega() {
        this.conect = new conexion().getConn();
    }
    
     public boolean guardar(piezas codigoPiez, proveedores codigoProv, int cant)
    {
        boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("INSERT INTO bodega VALUES(NULL,?,?,?,'2018/04/04')");
            cmd.setInt(1, codigoPiez.getCodipiez());
            cmd.setInt(2, codigoProv.getCodiprov());
            cmd.setInt(3, cant);
            
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al guardar bodega: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
        }
    
     public List<bodega> consTodo()
    {
       List<bodega> resp = new ArrayList<>();
        try
        {
            PreparedStatement cmd = conect.prepareStatement("SELECT codi_bode, piezas.nomb_piez,proveedores.nomb_prov,cant,DATE_FORMAT(fech_comp,'%d/%m/%Y') FROM bodega INNER JOIN piezas ON bodega.codi_piez = piezas.codi_piez INNER JOIN proveedores ON bodega.codi_prov = proveedores.codi_prov");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new bodega(
                        rs.getInt(1),
                        new piezas(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)),
                        new proveedores(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)),
                        rs.getInt(10),
                        rs.getString(11))); // <----- Hay que llenar con los objetos
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar bodega: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
     
     public boolean actualizar(int codigoBode,piezas codigoPiez, proveedores codigoProv, int cant)
    {
        boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("UPDATE bodega SET codi_piez = ?, codi_prov = ?, cant=? WHERE codi_bode = ?");
            cmd.setInt(1, codigoPiez.getCodipiez());
            cmd.setInt(1, codigoProv.getCodiprov());
            cmd.setInt(3, cant);
            cmd.setInt(4, codigoBode);
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al actualizar bodega: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
        }
     
      public boolean eliminar (int codiJuga) {
        boolean resp = false;
        try {
            PreparedStatement cmd = conect.prepareStatement("DELETE FROM bodega WHERE codi_bode = ?");
            cmd.setInt(1, codiJuga);
            cmd.executeUpdate();
            resp = true;
        }
        catch (Exception e) {
            System.err.println("Error al eliminar bodega: " + e.getMessage());
        }
        finally {
            try {
                if (conect != null)
                    if (!conect.isClosed())
                        conect.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;       
    }
    }
    
    
    
    
   
