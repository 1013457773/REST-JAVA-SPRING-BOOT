package com.example.backend.Componentes;

import com.example.backend.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Usuario")
@RestController
public class UsuarioComponetes {
    @Autowired
    UsuarioComponetes Servicios;

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datosQueEnviaElCLinete){
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.Servicios.guardarUsuario(datosQueEnviaElCLinete));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
