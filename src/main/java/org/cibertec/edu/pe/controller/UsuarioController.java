package org.cibertec.edu.pe.controller;

import javax.servlet.http.HttpSession;

import org.cibertec.edu.pe.model.Usuario;
import org.cibertec.edu.pe.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String registroPage() {
        return "login"; // Página HTML para el formulario de registro
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login"; // Redirige a la página de inicio de sesión después del registro
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Página HTML para el formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String autenticarUsuario(String correoUsuario, String contrasenaUsuario, Model model) {
        Usuario usuario = usuarioService.autenticarUsuario(correoUsuario, contrasenaUsuario);

        if (usuario != null) {
            // Autenticación exitosa
            model.addAttribute("usuario", usuario); // Agregar el usuario a la sesión
            return "redirect:/index"; // Redirige a la página principal del usuario autenticado
        } else {
            // Autenticación fallida
            return "redirect:/login?error=true"; // Redirige a la página de inicio de sesión con un mensaje de error
        }
    }
    
    /*
    @GetMapping("/index")
    public String dashboardPage(@ModelAttribute("usuario") Usuario usuario) {
        if (usuario == null) {
            // Manejo del caso en el que el usuario no está en la sesión
            return "redirect:/login"; // Redirige a la página de inicio de sesión
        } else if ("ADMIN".equals(usuario.getTipoUsuario())) {
            return "redirect:/indexAdmin/ADMIN"; // Redirige a la página de administrador
        } else if ("USER".equals(usuario.getTipoUsuario())) {
            return "redirect:/indexUser/USER"; // Redirige a la página de usuario normal
        } else {
            // Puedes manejar otros tipos de usuario aquí si es necesario
            return "index"; // Redirige a una vista de dashboard predeterminada
        }
    }*/

    
    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        // Elimina el atributo de sesión que contiene la información del usuario
        session.removeAttribute("usuario");
        // Puedes agregar lógica adicional de cierre de sesión si es necesario

        return "redirect:/login"; // Redirige a la página de inicio de sesión
    }

}
