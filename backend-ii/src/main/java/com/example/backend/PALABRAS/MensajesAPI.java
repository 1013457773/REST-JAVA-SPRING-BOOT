package com.example.backend.PALABRAS;

public enum MensajesAPI {
    ERROR_ASISTENCIA_NO_ENCONTRADO_("La Asistencia que buscar, no esta en la base de datos"),
    ERROR_CALIFICACION_NO_ENCONTRADO_("la Calificacion que buscas no esta en la base de datos"),
    ERROR_CURSO_NO_ENCONTRADO_("el Cuarso que buscas no esta en la base de datos"),
    ERROR_DOCENTE_NO_ENCONTRADO_("el Docente que buscas no esta en la base de datos"),
    ERROR_ESTUDIANTE_NO_ENCONTRADO_("el Estudiante que buscas no esta en la base de datos"),
    ERROR_INSCRIPCION_NO_ENCONTRADO_("la Inscripcion que buscas no esta en la base de datos"),
    ERROR_MATERIA_NO_ENCONTRADO_("la Materia que buscas no esta en la base de datos"),
    ERROR_USUARIO_NO_ENCONTRADO_("el Usuario que buscas no esta en la base de datos"),
    ;

    private String Mensaje;

    MensajesAPI(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

}
