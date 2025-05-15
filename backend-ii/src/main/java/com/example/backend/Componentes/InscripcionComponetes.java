package com.example.backend.Componentes;

import com.example.backend.modelos.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Inscripcion")
@RestController
public class InscripcionComponetes {
    @Autowired
    InscripcionComponetes Servicios;

    @PostMapping
    public ResponseEntity<?> guardarInscripcion(@RequestBody Inscripcion datosQueEnviaElCLinete){
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.Servicios.guardarInscripcion(datosQueEnviaElCLinete));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
