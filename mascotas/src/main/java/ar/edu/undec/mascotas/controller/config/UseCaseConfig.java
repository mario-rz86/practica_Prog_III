package ar.edu.undec.mascotas.controller.config;

import ar.edu.undec.mascotas.core.casosUso.ConsultarMascotasCasoUso;
import ar.edu.undec.mascotas.core.casosUso.CrearMascotaCasoUso;
import ar.edu.undec.mascotas.persistencia.ConsultarMascotaRepoImpl;
import ar.edu.undec.mascotas.persistencia.CrearMascotaRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Autowired
    CrearMascotaRepoImpl crearMascotaRepo;

    @Autowired
    ConsultarMascotaRepoImpl consultarMascotaRepo;

    @Bean
    public CrearMascotaCasoUso crearMascotaCasoUso(){
        return new CrearMascotaCasoUso(crearMascotaRepo);
    }

    @Bean
    public ConsultarMascotasCasoUso consultarMascotasCasoUso() {return new ConsultarMascotasCasoUso(consultarMascotaRepo);}

}
