package org.example.Infraestructure.Services;

import org.example.Infraestructure.DbManagment.Cuentas.Movimiento;
import org.example.Infraestructure.Models.MovimientoModels;

public class MovimientoService {
      Movimiento movimientoDB;
    public MovimientoService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        movimientoDB = new Movimiento(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(MovimientoModels movimiento){
        if(validarDatos(movimiento)){
            return movimientoDB.registrarMovimiento(movimiento);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarMovimiento(MovimientoModels movimiento){
        if(validarDatos(movimiento)){
            return movimientoDB.modificarMovimiento(movimiento);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public MovimientoModels consultarMovimientoPorId(int id){
        return  movimientoDB.consultarMovimiento(id);
    } 

    private boolean validarDatos(MovimientoModels movimiento) {
        int idMovimiento = movimiento.IdMovimiento;
        try {
            if (idMovimiento > 0) {
                throw new Exception("El Id Movimiento no debe estar vacío");
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
