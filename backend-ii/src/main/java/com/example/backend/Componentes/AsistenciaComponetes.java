package com.example.backend.Componentes;

import com.example.backend.modelos.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Asistecia")
@RestController
public class AsistenciaComponetes {
    @Autowired
    AsistenciaComponetes Servicios;

    @PostMapping
    public ResponseEntity<?>guardarAsistencia(@RequestBody Asistencia datosQueEnviaElCLinete){
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.Servicios.guardarAsistencia(datosQueEnviaElCLinete));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
