package org.example.Infraestructure.DbManagment.Contactos;
import org.example.Infraestructure.Conections.Conexiones;
import org.example.Infraestructure.Models.PersonaModels;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona {
    private Conexiones conexion;

    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    
    public String registrarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO personas(" +
                    "'idPersona', " +
                    "'idCiudad', " +
                    "'nombre', " +
                    "'apellido', " +
                    "'tipodocumento', " +
                    "'nrodocumento', " +
                    "'direccion'," +
                    "'celular', " +
                    "'email', " +
                    "'fechaNacimiento', " +
                    "'estado') " +
                    "values('" +
                    persona.IdPersona + "', '" +
                    persona.IdCiudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Celular + "', '" +
                    persona.Email + "', '" +
                    persona.FechaNacimiento + "', '" +
                    persona.Estado + "'))");
            conexion.conexionDB().close();
            return "La persona " + persona.Nombre + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE personas SET " +
                    "'idPersona' = '" + persona.IdPersona + "'," +
                    "'idCiudad' = '" + persona.IdCiudad + "'," +
                    "'nombre' = '" + persona.Nombre + "'," +
                    "'apellido' = '" + persona.Apellido + "'," +
                    "'tipodocumento' = '" + persona.TipoDocumento + "'," +
                    "'nrodocumento' = '" + persona.NroDocumento + "'," +
                    "'direccion' = '" + persona.Direccion + "'," +
                    "'celular' = '" + persona.Celular + "'," +
                    "'email' = '" + persona.Email + "'," +
                    "'fechaNacimiento' = '" + persona.FechaNacimiento + "'," +
                    "'Estado' = '" + persona.Estado + "' Where persona.idPersona = " + persona.IdPersona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModels consultarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where id = '" + id +"'"));
            if(conexion.getResultadoQuery().next()){
                return cargarDatosPersona(persona , conexion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
     public PersonaModels consultarPersonaPorDocumento(String documento){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where nrodocumento = '" + documento+"'"));
            if(conexion.getResultadoQuery().next()){
                return cargarDatosPersona(persona , conexion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
     private PersonaModels cargarDatosPersona(PersonaModels persona,Conexiones conexion){
        try {
            persona.IdPersona = conexion.getResultadoQuery().getInt("idPersona");
            persona.IdCiudad = conexion.getResultadoQuery().getInt("idCiudad");
            persona.Nombre = conexion.getResultadoQuery().getString("nombre");
            persona.Apellido = conexion.getResultadoQuery().getString("apellido");
            persona.TipoDocumento = conexion.getResultadoQuery().getString("tipoDocumento");
            persona.NroDocumento = conexion.getResultadoQuery().getString("nrodocumento");
            persona.Direccion = conexion.getResultadoQuery().getString("direccion");
            persona.Celular = conexion.getResultadoQuery().getString("celular");
            persona.Email = conexion.getResultadoQuery().getString("email");
            persona.FechaNacimiento = conexion.getResultadoQuery().getDate("fechaNacimiento");
            return persona;
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
     }

}
