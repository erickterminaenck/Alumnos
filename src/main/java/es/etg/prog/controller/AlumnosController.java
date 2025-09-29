package es.etg.prog.controller;

import java.util.ArrayList;
import java.util.List;

import model.Alumno;

/**
 * Controlador para gestionar alumnos.
 */
public class AlumnosController {

    // Lista interna de alumnos (actúa como "modelo" simple)
    private final List<Alumno> alumnos = new ArrayList<>();

    /**
     * Inserta un nuevo alumno en la lista si no existe ya.
     * @param a Alumno a insertar
     * @return true si se ha insertado, false si ya existía
     */
    public boolean insertarAlumno(Alumno a) {
        if (!alumnos.contains(a)) {
            alumnos.add(a);
            return true;
        }
        return false;
    }

    /**
     * Devuelve todos los alumnos registrados.
     * @return lista de alumnos
     */
    public List<Alumno> listarAlumnos() {
        return new ArrayList<>(alumnos); 
    }
}
