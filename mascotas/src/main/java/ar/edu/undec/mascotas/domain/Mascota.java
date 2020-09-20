package ar.edu.undec.mascotas.domain;

import ar.edu.undec.mascotas.casosUso.excepciones.MascotaIncompletaException;

import java.time.LocalDate;

public class Mascota {
    private String  nombre;
    private String raza;
    private LocalDate fechaNacimiento;

    private Mascota(String nombre, String raza, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Mascota instancia(String nombre, String raza, LocalDate fechaNacimiento) throws MascotaIncompletaException {
        if(nombre.isEmpty() || raza.isEmpty()) {
            throw new MascotaIncompletaException();
        }
        return new Mascota(nombre,raza,fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }
    public String getRaza() { return raza; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void modificarDatos(Mascota mascotaDatosNuevos) {
        this.nombre = mascotaDatosNuevos.getNombre();
        this.raza = mascotaDatosNuevos.getRaza();
        this.fechaNacimiento = mascotaDatosNuevos.getFechaNacimiento();
    }




}
