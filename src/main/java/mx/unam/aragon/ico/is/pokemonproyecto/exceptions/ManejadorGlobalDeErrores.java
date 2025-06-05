package mx.unam.aragon.ico.is.pokemonproyecto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<HashMap<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String,String> errors = new HashMap<>();
        errors.put("timestamp", LocalDateTime.now().toString());
        errors.put("message", "El dato no es valido, asegurese de que el dato sea correcto e intentelo de nuevo");
        errors.put("codigo", "2402");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HashMap<String,String> errors = new HashMap<>();
        errors.put("timestamp", LocalDateTime.now().toString());
        errors.put("message", "La sintaxis del argumento no es valida, por favor revise su peticion e intente de nuevo");
        errors.put("codigo", "0816");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
