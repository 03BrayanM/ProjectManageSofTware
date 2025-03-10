/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.infra;

import java.time.LocalDate;

/**
 *
 * @author Yisus
 */
public class CalcularFecha {
    public String calcular(int tiempoMeses){
    LocalDate fechaActual = LocalDate.now();
    LocalDate fechaEntrega = fechaActual.plusMonths(tiempoMeses);
    return fechaEntrega.toString(); // Devuelve la fecha en formato "YYYY-MM-DD"
    }
}
