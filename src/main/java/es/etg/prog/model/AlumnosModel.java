package es.etg.prog.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlumnosModel {
    private final Map<Long, Alumno> alumnos = new LinkedHashMap<>();
    private long secuencia = 0; // contador para IDs

    /** Inserta un alumno y le asigna un id automático */
    public Alumno insertar(Alumno a) {
        long id = ++secuencia;
        a.setId(id);
        alumnos.put(id, a);
        return a;
    }

    /** Devuelve todos los alumnos registrados */
    public List<Alumno> listar() {
        return new ArrayList<>(alumnos.values());
    }
}
