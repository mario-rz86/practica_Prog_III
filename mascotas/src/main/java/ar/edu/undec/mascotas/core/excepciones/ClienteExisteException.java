package ar.edu.undec.mascotas.core.excepciones;

public class ClienteExisteException extends Exception {
    @Override
    public String getMessage() {
        return "Ya existe un cleinte con ese numero de documento";
    }
}
