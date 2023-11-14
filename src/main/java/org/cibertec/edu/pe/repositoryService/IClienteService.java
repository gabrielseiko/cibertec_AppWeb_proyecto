package org.cibertec.edu.pe.repositoryService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Cliente;




public interface IClienteService {
	public List<Cliente> ListadoClientes();
	public Optional<Cliente> BuscarCliente(int id);
	public int Grabar(Cliente objC);
	public void Suprimir(int id);
}
