package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IClienteService;
import org.cibertec.edu.pe.interfaces.ICliente;
import org.cibertec.edu.pe.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private ICliente data;
	
	@Override
	public void Suprimir(String id) {
		data.deleteById(id);
	}

	@Override
	public List<Cliente> ListadoClient() {
		return (List<Cliente>)data.findAll();
	}

	@Override
	public Optional<Cliente> BuscarClient(String id) {
		return data.findById(id);

	}

	@Override
	public int Grabar(Cliente objC) {
		int rpta = 0;
		Cliente p = data.save(objC);
		if(!p.equals(null))
			rpta = 1;
		return rpta;
	}
}
