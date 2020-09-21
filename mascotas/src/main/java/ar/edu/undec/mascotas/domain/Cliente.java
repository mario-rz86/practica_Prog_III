package ar.edu.undec.mascotas.domain;

import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;

import java.time.LocalDate;

public class Cliente {

    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;

    private Cliente(String apellido, String nombre, String dni, LocalDate fechaNacimiento) {
        this.apellido = apellido;
        this.nombre =nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Cliente instancia(String apellido, String nombre, String dni, LocalDate fechaNacimiento) throws ClienteIncompletoException {
        if(apellido.isEmpty() || nombre.isEmpty() || dni.isEmpty()) {
            throw new ClienteIncompletoException();
        }
        return new Cliente(apellido, nombre, dni, fechaNacimiento);
    }

    public String getDni() { return dni; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    public void modificarDatos(Cliente clienteDatosNuevos) {
        this.apellido = clienteDatosNuevos.getApellido();
        this.nombre = clienteDatosNuevos.getNombre();
        this.dni = clienteDatosNuevos.getDni();
        this.fechaNacimiento = clienteDatosNuevos.getFechaNacimiento();
    }




}
