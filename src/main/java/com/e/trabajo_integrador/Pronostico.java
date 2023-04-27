package com.e.trabajo_integrador;

public class Pronostico {

    //Atributos
    
    private final Partido partido;
    ResultadoEnum resultado;
    private final Participante participante;

    //Constructor
    public Pronostico(Partido partido, ResultadoEnum resultado, Participante nombrePraticipante) {
        this.participante = nombrePraticipante;
        this.partido = partido;
        this.resultado = resultado;
        
    }

    public int puntajePronostico() {
        ResultadoEnum resultadoPartido = this.partido.resultadoPartido();

        if (resultadoPartido == this.resultado) {
            return 3;
        } else {
            return 0;
        }
    }
}
