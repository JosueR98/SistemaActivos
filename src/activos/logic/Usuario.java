/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.logic;


/**
 *
 * @author Josue R
 */
public class Usuario {
    // Usuarios por numero
    public static final int INDEFINIDO = 0;
    public static final int ADMINISTRADOR_DEPENDENCIA = 1;
    public static final int SECRETARIA_OCCB = 2;
    public static final int JEFE_OCCB = 3;
    public static final int REGISTRADOR_BIENES = 4;
    public static final int JEFE_RRH = 5;
    public static final int JEFE_OCBB_RH= 7;
       
    
   // Atributos propios de la clase usuario
    private String id;
    private String clave;
    private int tipo;

    public Usuario() {
        this.id = "root";
        this.clave = "root";
        this.tipo = INDEFINIDO;
    }

    
    public Usuario(String id, String clave, int tipoUsuario) {
        this.id = id;
        this.clave = clave;
        this.tipo = tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipoUsuario() {
        return tipo;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipo = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", clave=" + clave + ", tipo=" + tipo + '}';
    }
    
    
    
}
