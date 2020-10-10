package ar.edu.undec.mascotas.domain;

import ar.edu.undec.mascotas.casosUso.excepciones.ClienteIncompletoException;

import java.time.LocalDate;
import java.util.List;

public class Cliente {

    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private List<Mascota> mascotas;

    private Cliente(String apellido, String nombre, String dni, LocalDate fechaNacimiento, List<Mascota> mascotas) {
        this.apellido = apellido;
        this.nombre =nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.mascotas = mascotas;
    }

    public static Cliente instancia(String apellido, String nombre, String dni, LocalDate fechaNacimiento, List<Mascota> mascotas) throws ClienteIncompletoException {
        if(apellido.isEmpty() || nombre.isEmpty() || dni.isEmpty()) {
            throw new ClienteIncompletoException();
        }
        return new Cliente(apellido, nombre, dni, fechaNacimiento, mascotas);
    }

    public String getDni() { return dni; }
    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public List<Mascota> getMascotas() { return mascotas; }

    public void modificarDatos(Cliente clienteDatosNuevos) {
        this.apellido = clienteDatosNuevos.getApellido();
        this.nombre = clienteDatosNuevos.getNombre();
        this.dni = clienteDatosNuevos.getDni();
        this.fechaNacimiento = clienteDatosNuevos.getFechaNacimiento();
        this.mascotas = clienteDatosNuevos.getMascotas();

    }




}
