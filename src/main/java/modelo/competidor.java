/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Daniel Alejandro
 */
public class competidor extends atleta {
    private int ranking;
    private double estatura;
    private double peso;
    
    public competidor (String nombre, int edad, String pais, int ranking, double estatura, double peso){
        super (nombre, edad, pais);
        this.ranking= ranking;
        this.estatura = estatura;
        this.peso= peso;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", Raking: "+ ranking + ", Estatura: " + estatura+ ", Peso: " + peso;
    }
    public void actualizarRanking (int puntosObtenidos){
        this.ranking +=puntosObtenidos;
    }
    
    public void actualizarRanking (int puntosObtenidos, boolean ganoMedalla){
        int bonificacion = 0;
        
        if (ganoMedalla){
            if (puntosObtenidos >50){
                bonificacion = 30;
            }else{
                bonificacion = 15;
            }
        }
        
        this.ranking +=(puntosObtenidos + bonificacion);
    }
    
}
