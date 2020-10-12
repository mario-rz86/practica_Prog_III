package ar.edu.undec.mascotas.persistencia.entity;


import ar.edu.undec.mascotas.domain.Mascota;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "clientes")
@SequenceGenerator(name = "clientes_id_seq", initialValue = 1, sequenceName = "clientes_id_seq", allocationSize = 1)
public class ClienteEntity {

    @Id
    @Column(name = "idcliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_id_seq")
    private Integer idCliente;

    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dni")
    private String dni;
    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cliente")
    private List<MascotaEntity> mascotas;

    public ClienteEntity() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<MascotaEntity> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaEntity> mascotas) {
        this.mascotas = mascotas;
    }
}
