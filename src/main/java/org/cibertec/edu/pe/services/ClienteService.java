package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.repository.IClienteRepository;
import org.cibertec.edu.pe.repositoryService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteRepository data;

	@Override
	public List<Cliente> ListadoClientes() {
		return (List<Cliente>) data.findAll();
	}

	@Override
	public Optional<Cliente> BuscarCliente(int id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Cliente objC) {
		int rpta = 0;
		Cliente c = data.save(objC);
		if (!c.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(int id) {
		data.deleteById(id);

	}
}
