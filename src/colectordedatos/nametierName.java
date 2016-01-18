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
public class nametierName {
    private String name;
    private String tierName;
    
    public nametierName(String name, String tierName){
        this.name=name;
        this.tierName=tierName;
    
    }
    public String toString(){
    return name;
    }
    public String getname(){
    return name;
    }
    public void setname(String name){
    this.name=name;
    }
    public String gettierName(){
    return tierName;
    }
    public void settierName(String tierName){
    this.tierName=tierName;
    }
}
