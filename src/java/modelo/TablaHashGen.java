/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class TablaHashGen<K, V>  
{
    private class Nodo
    {
        K clave;
        V valor;
        Nodo siguiente;
        
        public Nodo(K clave, V valor)
        {
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }
    
    private Object[] tabla;
    private int tamanio;
    
    public TablaHashGen(int tamanio)
    {
        this.tamanio = tamanio;
        tabla = new Object[tamanio];
    }
    
    private int hash(K clave)
    {
        int valor = Integer.parseInt(clave.toString());
        return valor % tamanio;
    }
    
    public void insertar(K clave, V valor)
    {
        int indice = hash(clave);
        
        Nodo nuevo = new Nodo(clave, valor);
        Nodo inicio = (Nodo) tabla[indice];
        
        if (inicio == null)
        {
            tabla[indice] = nuevo;
        }
        else
        {
            Nodo actual = inicio;
            
            while (actual.siguiente != null)
            {
                if (actual.clave.equals(clave))
                {
                    actual.valor = valor;
                    return;
                }
                
                actual = actual.siguiente;
            }
            
            if (actual.clave.equals(clave))
            {
                actual.valor= valor;
            }
            else
            {
                actual.siguiente = nuevo;
            }
        }
    }
    
    public V obtener(K clave)
    {
        int indice = hash(clave);
        
        Nodo actual = (Nodo) tabla[indice];
        
        while (actual != null)
        {
            if (actual.clave.equals(clave))
            {
                return actual.valor;
            }
            
            actual = actual.siguiente;
        }
        
        return null;
    }
    
    public void eliminar(K clave)
    {
        int indice = hash(clave);
        
        Nodo actual = (Nodo) tabla[indice];
        Nodo anterior = null;
        
        while (actual != null)
        {
            if (actual.clave.equals(clave))
            {
                if (anterior == null)
                {
                    tabla[indice] = actual.siguiente;
                }
                else
                {
                    anterior.siguiente = actual.siguiente;
                }
                
                return;
            }
            
            anterior = actual;
            actual = actual.siguiente;
        }
    }
    
    public void mostrar()
    {
        for (int i = 0; i < tamanio; i++)
        {
            System.out.println("Posicion " + i + ": ");
            
            Nodo actual = (Nodo) tabla[i];
            
            while (actual != null)
            {
                System.out.println("[" + actual.clave + "] -> ");
                
                actual = actual.siguiente;
            }
            
            System.out.println("null");
        }
    }
}
