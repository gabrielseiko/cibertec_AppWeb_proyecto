package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Cliente;


public interface IClienteService {
	public List<Cliente> ListadoClient();
	public Optional<Cliente> BuscarClient(String id);
	public int Grabar(Cliente objC);
	public void Suprimir(String id);
}
