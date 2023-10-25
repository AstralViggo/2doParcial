package org.example.Infraestructure.Services;

import org.example.Infraestructure.DbManagment.Cuentas.Cuentas;
import org.example.Infraestructure.Models.CuentasModels;

public class CuentasService {
     Cuentas cuentasDB;
    public CuentasService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentasDB = new Cuentas(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuentas(CuentasModels cuentas){
        if(validarDatos(cuentas)){
            return cuentasDB.registrarCuentas(cuentas);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCuentas(CuentasModels cuentas){
        if(validarDatos(cuentas)){
            return cuentasDB.modificarCuentas(cuentas);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CuentasModels consultarCuentasPorId(int id){
        return  cuentasDB.consultarCuentas(id);
    } 

    private boolean validarDatos(CuentasModels cuentas) {
        int idCuenta = cuentas.IdCuenta;
        try {
            if (idCuenta > 0) {
                throw new Exception("El Id Cuenta no debe estar vacío");
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
