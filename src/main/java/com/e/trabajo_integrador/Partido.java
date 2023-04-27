package com.e.trabajo_integrador;

public class Partido {

    //Atributos del objeto
    private final Equipo equipoLocal;
    private final Equipo equipoVisitante;
    private final int golesEquipoLocal;
    private final int golesEquipoVisitante;
    private final ResultadoEnum resultado;
    private final int ronda;



    //Constructor
    public Partido(Equipo equipoLocal, int golesEquipoLocal, int golesEquipoVisitante, Equipo equipoVisitante, int ronda) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
        this.ronda = ronda;
        this.resultado = null;
      
    }

    //Métodos get para cada atributo de Partido
    public Equipo getEquipoUno() {
        return equipoLocal;
    }

    public Equipo getEquipoDos() {
        return equipoVisitante;
    }

    public int getGolesEquipoUno() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoDos() {
        return golesEquipoVisitante;
    }
    
    public int getRonda() {
        return ronda;
    }
    
       
    // Método para retornar resultado
    public ResultadoEnum resultadoPartido() {

        if (this.golesEquipoLocal > this.golesEquipoVisitante) {
            return ResultadoEnum.GANA_EQUIPO_UNO;
        } else if (this.golesEquipoVisitante > this.golesEquipoLocal) {
            return ResultadoEnum.GANA_EQUIPO_DOS;
        } else {
            return ResultadoEnum.EMPATE;
        }
    }

   
}
