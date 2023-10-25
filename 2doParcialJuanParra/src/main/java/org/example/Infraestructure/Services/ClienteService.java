package org.example.Infraestructure.Services;
import org.example.Infraestructure.DbManagment.Contactos.Cliente;
import org.example.Infraestructure.Models.ClienteModels;
public class ClienteService {
     Cliente clienteDB;
    public ClienteService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new Cliente(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){
        if(validarDatos(cliente)){
            return clienteDB.registrarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCliente(ClienteModels cliente){
        if(validarDatos(cliente)){
            return clienteDB.modificarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public ClienteModels consultarClientePorId(int id){
        return  clienteDB.consultarCliente(id);
    } 
  
    private boolean validarDatos(ClienteModels cliente) {
        int idCliente = cliente.IdCliente;
        try {
             if (idCliente > 0) {
                throw new Exception("El Id del cliente no debe estar vacío");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
