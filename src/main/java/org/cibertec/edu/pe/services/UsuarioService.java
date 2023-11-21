package org.cibertec.edu.pe.services;

import org.cibertec.edu.pe.model.Usuario;
import org.cibertec.edu.pe.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	 private final IUsuarioRepository usuarioRepository;

	    @Autowired
	    public UsuarioService(IUsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    public Usuario registrarUsuario(Usuario usuario) {
	    	usuario.setTipoUsuario("USER");
	        // Puedes agregar validaciones y lógica de registro aquí
	        return usuarioRepository.save(usuario);
	    }

	    public Usuario autenticarUsuario(String correoUsuario, String contrasenaUsuario) {
	        Usuario usuario = usuarioRepository.findByCorreoUsuario(correoUsuario);

	        if (usuario != null && usuario.getContrasenaUsuario().equals(contrasenaUsuario)) {
	            return usuario;
	        }
	        
	        return null; // Autenticación fallida
	    }
	    
}
