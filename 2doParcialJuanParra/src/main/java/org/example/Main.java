package org.example;

import org.example.Infraestructure.Models.PersonaModels;
import org.example.Infraestructure.Services.PersonaService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PersonaService personaService = new PersonaService("postgres", "1234", "localhost", "5432", "postgres");
        PersonaModels persona = new PersonaModels();
        persona.Nombre = "Juan";
        persona.Apellido = "Perez";
        personaService.registrarPersona(persona);
    }
}