package ar.edu.undec.mascotas.casosUso.excepciones;

public class MascotaExisteException extends Exception{


    @Override
    public String getMessage() {
        return "Ya existe una mascota con ese nombre";
    }
}
