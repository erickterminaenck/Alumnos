package es.etg.prog.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alumno {
    private Long id; // lo pone el modelo
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Alumno(Long id, String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this(null, nombre, apellidos, fechaNacimiento);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    public int getEdad() { 
        if (fechaNacimiento == null) return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears(); 
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = (fechaNacimiento != null) ? fechaNacimiento.format(fmt) : "N/D";
        return "#" + (id != null ? id : "N/D") + " - " + nombre + " " + apellidos +
               " (Nac.: " + fecha + ", Edad: " + getEdad() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        // Si el id es null, compara por nombre, apellidos y fechaNacimiento
        if (id == null || alumno.id == null) {
            return Objects.equals(nombre, alumno.nombre) &&
                   Objects.equals(apellidos, alumno.apellidos) &&
                   Objects.equals(fechaNacimiento, alumno.fechaNacimiento);
        }
        return Objects.equals(id, alumno.id);
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return Objects.hash(nombre, apellidos, fechaNacimiento);
        }
        return Objects.hash(id);
    }
}
