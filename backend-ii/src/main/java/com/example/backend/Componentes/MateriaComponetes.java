package com.example.backend.Componentes;

import com.example.backend.modelos.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Materia")
@RestController
public class MateriaComponetes {
    @Autowired
    MateriaComponetes Servicios;

    @PostMapping
    public ResponseEntity<?> guardarMateria(@RequestBody Materia datosQueEnviaElCLinete){
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.Servicios.guardarMateria(datosQueEnviaElCLinete));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
