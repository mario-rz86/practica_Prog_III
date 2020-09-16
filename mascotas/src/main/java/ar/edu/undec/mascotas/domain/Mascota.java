package ar.edu.undec.mascotas.domain;

import java.time.LocalDate;

public class Mascota {
    private String  nombre;
    private final String raza;
    private final LocalDate fechaNacimiento;

    private Mascota(String nombre, String raza, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Mascota instancia(String nombre, String raza, LocalDate fechaNacimiento) {
        return new Mascota(nombre,raza,fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
