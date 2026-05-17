/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
    
public class NodoArbol {
    
    int idUsuario;
    int posicionHash;
    
    ArrayList<NodoArbol> hijos;
    
    public NodoArbol(int idUsuario, int posicionHash)
    {
        this.idUsuario = idUsuario;
        this.posicionHash = posicionHash;
        hijos = new ArrayList<>();
    }
}
