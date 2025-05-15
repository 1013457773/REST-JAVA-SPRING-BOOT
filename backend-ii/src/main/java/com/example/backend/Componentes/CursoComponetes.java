package com.example.backend.Componentes;

import com.example.backend.modelos.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Curso")
@RestController
public class CursoComponetes {
    @Autowired
    CursoComponetes Servicios;

    @PostMapping
    public ResponseEntity<?> guardarCurso(@RequestBody Curso datosQueEnviaElCLinete){
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.Servicios.guardarCurso(datosQueEnviaElCLinete));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
