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

        } 
        else 
        {
            raiz.hijos.add(nuevo);
        }
    }

    public void mostrar(NodoArbol nodo) 
    {

        if (nodo == null) 
        {
            return;
        }

        System.out.println("Usuario: " + nodo.idUsuario);

        for (NodoArbol hijo : nodo.hijos) 
        {
            mostrar(hijo);
        }
    }    
}
