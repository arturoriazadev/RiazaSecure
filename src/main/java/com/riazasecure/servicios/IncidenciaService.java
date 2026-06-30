package com.riazasecure.servicios;

import java.util.ArrayList;

import com.riazasecure.modelo.Incidencia;

public class IncidenciaService {

    private ArrayList<Incidencia> incidencias;

    public IncidenciaService() {
        incidencias = new ArrayList<>();
    }

    // Crear incidencia
    public void crearIncidencia(Incidencia incidencia) {
        incidencias.add(incidencia);
    }

    // Listar incidencias
    public void listarIncidencias() {
        for (Incidencia incidencia : incidencias) {
            System.out.println(incidencia);
        }
    }

    // Devuelve el número de incidencias
    public int getNumeroIncidencias() {
        return incidencias.size();
    }

    // Buscar incidencia por ID
    public Incidencia buscarPorId(long id) {

        for (Incidencia incidencia : incidencias) {

            if (incidencia.getId() == id) {
                return incidencia;
            }
        }

        return null;
    }

    // Actualizar incidencia
    public boolean actualizarIncidencia(long id, Incidencia incidenciaActualizada) {

        Incidencia incidencia = buscarPorId(id);

        if (incidencia != null) {

            incidencia.setDescripcion(incidenciaActualizada.getDescripcion());
            incidencia.setFecha(incidenciaActualizada.getFecha());
            incidencia.setEstado(incidenciaActualizada.getEstado());

            return true;
        }

        return false;
    }

    // Eliminar incidencia
    public boolean eliminarIncidencia(long id) {

        Incidencia incidencia = buscarPorId(id);

        if (incidencia != null) {
            incidencias.remove(incidencia);
            return true;
        }

        return false;
    }
}