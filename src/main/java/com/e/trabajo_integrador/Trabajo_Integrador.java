package com.e.trabajo_integrador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
         ****************  @author ELIO  ****************
 */

public class Trabajo_Integrador {

    public static void main(String[] args) throws SQLException {
        ConeccionServidor objetoConexion = new ConeccionServidor();
        objetoConexion.Conectar();

        ResultSet dato = objetoConexion.resultadoSELEC;
        List<Partido> listaPartidos = new ArrayList<>();
        List<Pronostico> listaPronostico = new ArrayList<>();
        List<Ronda> listaRonda = new ArrayList<>();
        List<Participante> listaParticipantes = new ArrayList<>();

        String equipo1 = "", equipo2 = "", nameParticipante = "";
        String ganaEl = "", empate = "", ganaE2 = "";
        int golesEqui1 = 0, golesEqui2 = 0, numRonda = 0;
        String[] columna = new String[3];

        System.out.println("\nResultados de partidos cargados en Base de Datos.\n");

        //Recorro Base para obtener los datos partidos y rondas
        while (dato.next()) {
            
            try {
                nameParticipante = dato.getString(3);
                ganaEl = dato.getString(5);
                empate = dato.getString(6);
                ganaE2 = dato.getString(7);
                numRonda = dato.getInt(2);
                equipo1 = dato.getString(4);
                equipo2 = dato.getString(8);
                golesEqui1 = dato.getInt(9);
                golesEqui2 = dato.getInt(10);

            } catch (SQLException e) {
                System.out.println("No se conectó a la base de datos. ERROR");
                System.out.println(e);
            }
            Equipo equipoLocal = new Equipo(equipo1);
            Equipo equipoVisitante = new Equipo(equipo2);
            Partido partido = new Partido(equipoLocal,golesEqui1,golesEqui2,equipoVisitante,numRonda);
            listaPartidos.add(partido);
      
            Partido partidoEncontrado = BuscarPartidoPorNombreEquipos(listaPartidos, equipo1, equipo2);
            //if ( numRonda =!  )

            
            if (partido != partidoEncontrado) {

                Ronda ronda = new Ronda(numRonda, listaPartidos);
                listaRonda.add(ronda);

                System.out.print("Ronda " + ronda.getRonda() + "   -   ");
                System.out.println(partido.getEquipoUno().getNombre() + " " + partido.getGolesEquipoUno() + " VS. " + partido.getGolesEquipoDos() + " " + partido.getEquipoDos().getNombre());

            }
          
            Participante participante = new Participante(nameParticipante, listaPronostico);
            listaParticipantes.add(participante);
            
            Pronostico pronostico = new Pronostico(partidoEncontrado,partido.resultadoPartido(),participante);
            listaPronostico.add(pronostico);
        
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("º");
    }
    public static Partido BuscarPartidoPorNombreEquipos(List<Partido> listaPartidos, String nombreEquipoLocal, String nombreEquipoVisitante) {

        Partido partidoEncontrado = listaPartidos.stream()
                .filter(Partido -> Partido.getEquipoUno().getNombre().equals(nombreEquipoLocal) && Partido.getEquipoDos().getNombre().equals(nombreEquipoVisitante))
                .findAny()
                .orElse(null);
        return partidoEncontrado;
    }
    private static ResultadoEnum DeterminarResultadoElegido(String[] columna) {
        String ganaEquipoLocal = columna[0];
        String empate = columna[1];
        String ganaEquipoVisitante = columna[2];

        //si la columan 1 es igual a "x" GANA_EQUIPO_UNO
        if (ganaEquipoLocal.equals("X")) {
            System.out.println("L");
            return ResultadoEnum.GANA_EQUIPO_UNO;
        }
        if (ganaEquipoVisitante.equals("X")) {
            System.out.println("E");
            return ResultadoEnum.GANA_EQUIPO_DOS;
        }
        if (empate.equals("X")) {
            System.out.println("v");
            return ResultadoEnum.EMPATE;
        }

        return ResultadoEnum.EMPATE;

    }
}



           
           
            //columna[0] = ganaEl;
            //columna[1] = empate;
            //columna[2] = ganaE2;
          
         