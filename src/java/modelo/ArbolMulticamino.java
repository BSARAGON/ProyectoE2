/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author berna
 */

public class ArbolMulticamino 
{
    NodoArbol raiz;

    public void insertar(int idUsuario,int posicionHash) 
    {
        NodoArbol nuevo = new NodoArbol(idUsuario, posicionHash);

        if (raiz == null) 
        {
            raiz = nuevo;
            return;
        } 
        
        insertarRecursivo(raiz, nuevo);
    }

    private void insertarRecursivo(NodoArbol actual, NodoArbol nuevo)
    {
        if (nuevo.idUsuario < actual.idUsuario)
        {
            if (actual.hijos.size() == 0)
            {
                actual.hijos.add(nuevo);
            }
            else
            {
                insertarRecursivo(actual.hijos.get(0), nuevo);
            }
        } 
        else
        {
            if (actual.hijos.size() < 2)
            {
                actual.hijos.add(nuevo);
            }
            else
            {
                insertarRecursivo(actual.hijos.get(1), nuevo);
            }
        }
    }
}
