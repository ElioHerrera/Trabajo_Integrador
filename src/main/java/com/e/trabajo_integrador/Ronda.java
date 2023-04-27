package com.e.trabajo_integrador;

//import java.util.ArrayList;

import java.util.List;

public class Ronda {

    private final int numRonda;
    private final List<Partido> listaPartidos;

    public Ronda(int ronda, List<Partido> listaPartidos) {
        this.numRonda = ronda;
        this.listaPartidos = listaPartidos;
    }

    public int getRonda() {
        return numRonda;
    }

}

/**
 * @authors Leiria Gonzalo, Herrera Elio, Ibarra Gisell
 *
 * public class Ronda {
 *
 * private final int numRonda; private List<Partidos> partidos; // private
 * ArrayList<Pronosticos> pronosticos = new ArrayList();;
 *
 *
 * public Ronda(int ronda) { this.numRonda = ronda; //this.partidos =  *
 * }
 *
 * public void AgregarRonda(List<Partidos> partidos) { for (Partido partido :
 * partidos) { this.partidos.add(partido); }
 *
 * }
 *
 * public int getRonda() { return numRonda; }
 *
 *
 * public List<Partido> getPartidos() { return partidos; }
 *
 *
 * }
 */
