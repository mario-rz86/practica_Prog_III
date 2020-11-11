package ar.edu.undec.mascotas.controller.dtomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class MascotaDTO {

    @JsonProperty("nombre")
    private String  nombre;

    @JsonProperty("raza")
    private String raza;
    @JsonProperty("fechaNacimiento")
    private LocalDate fechaNacimiento;


    public MascotaDTO(@JsonProperty("nombre") String nombre,
                      @JsonProperty("raza") String raza,
                      @JsonProperty("fechaNacimiento") LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
