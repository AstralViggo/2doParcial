package org.example.Infraestructure.Services;

import org.example.Infraestructure.DbManagment.Direccion.Ciudad;
import org.example.Infraestructure.Models.CiudadModels;

public class CiudadService {
      Ciudad ciudadDB;
    public CiudadService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new Ciudad(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
            return ciudadDB.registrarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
            return ciudadDB.modificarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CiudadModels consultarCiudadPorId(int id){
        return  ciudadDB.consultarCiudad(id);
    } 

    private boolean validarDatos(CiudadModels ciudad) {
        int idCiudad = ciudad.IdCiudad;
        try {
            if (idCiudad > 0) {
                throw new Exception("El Id Ciudad no debe estar vacío");
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
