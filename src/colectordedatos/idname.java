/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colectordedatos;

/**
 *
 * @author Administrador
 */
public class idname {
    private String id;
    private String name;
    
    
    public idname(String id,String name){
    this.id=id;
    this.name=name;
    }
    public String toString(){
    return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
