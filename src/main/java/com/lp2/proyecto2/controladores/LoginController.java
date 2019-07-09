/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.UsuarioDAO;
import com.lp2.proyecto2.modelo.Usuario;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Francisca Carmona
 */
@Controller
public class LoginController {

    @Autowired
    UsuarioDAO uDAO;

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Usuario usuario, Model model, HttpServletRequest request) throws IOException{
       
        Usuario usuariobd = uDAO.findByEmailAndPassword(usuario.getEmail(),usuario.getPassword());
        if (usuariobd!=null) {
            
       request.getSession().setAttribute("usuariologueado", usuariobd);
            return"/Principal";
        } else {
             model.addAttribute("usuario", new Usuario());
             model.addAttribute("error", true);
            
        return "/index";
        }

       
    }
     @PostMapping("logout")
    public String cerrarSesion( HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }
    @GetMapping("/fundadoras")
    public String fundadoras(Model model){
    return "Fundadoras";
    }
    @GetMapping("/historia")
    public String historia(Model model){
    return "Historia";
    }


}
