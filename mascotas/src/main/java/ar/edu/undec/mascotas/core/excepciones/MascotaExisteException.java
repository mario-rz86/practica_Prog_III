package ar.edu.undec.mascotas.core.excepciones;

public class MascotaExisteException extends Exception{


    @Override
    public String getMessage() {
        return "Ya existe una mascota con ese nombre";
    }
}
