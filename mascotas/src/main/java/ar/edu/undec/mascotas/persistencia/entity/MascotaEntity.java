package ar.edu.undec.mascotas.persistencia.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "mascotas")
@SequenceGenerator(name = "mascotas_id_seq", initialValue = 1, sequenceName = "mascotas_id_seq", allocationSize = 1)
public class MascotaEntity {

    @Id
    @Column(name = "idmascota")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascotas_id_seq")
    private Integer idMascota;


    @Column(name = "nombre")
    private String  nombre;
    @Column(name = "raza")
    private String raza;
    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private ClienteEntity cliente;

    public MascotaEntity() {
    }

    public MascotaEntity(Integer idMascota, String nombre, String raza, LocalDate fechaNacimiento, ClienteEntity clienteBD) {
    }


    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
