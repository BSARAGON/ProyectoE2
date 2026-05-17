/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author berna
 */
public class Pedido 
{
    
    private int id;
    private int clienteId;
    private String descripcion;
    private String prioridad;
    private String estado;
    private int repartidorId;

    public Pedido(){}
    
    public Pedido(int id, int clienteId, String descripcion, String prioridad, String estado, int repartidorId) 
    {
        this.id = id;
        this.clienteId = clienteId;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.repartidorId = repartidorId;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getClienteId() 
    {
        return clienteId;
    }

    public void setClienteId(int clienteId) 
    {
        this.clienteId = clienteId;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public String getPrioridad() 
    {
        return prioridad;
    }

    public void setPrioridad(String prioridad) 
    {
        this.prioridad = prioridad;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public int getRepartidorId() 
    {
        return repartidorId;
    }

    public void setRepartidorId(int repartidorId) 
    {
        this.repartidorId = repartidorId;
    }
}
