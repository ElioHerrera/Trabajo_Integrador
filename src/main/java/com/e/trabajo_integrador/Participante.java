package com.e.trabajo_integrador;

import java.util.List;

public class Participante {

    
    private final String nombreParticipante;
    private final List<Pronostico> listaPronostico;
    private final int puntaje;
    private final int numeroAciertos;
    

    //contructor
    public Participante(String nombreParticipante, List<Pronostico> listaPronostico) {
        this.nombreParticipante = nombreParticipante;
        this.listaPronostico = listaPronostico;
        this.puntaje = 0;
        this.numeroAciertos =0;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }
    
    public int PuntosExtra(){
    
        
        return 0;
    }

}
