/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.UsuarioDAO;
import com.lp2.proyecto2.modelo.Usuario;
import java.io.IOException;
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
public class UsuarioController {

    @Autowired
    UsuarioDAO uDAO;

    @GetMapping("/CrearUsuario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoUsuario", new Usuario());
        return "/CrearUsuario";
    }

    @PostMapping("/CrearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario, HttpServletResponse response) throws IOException {

        if (!usuario.getNombre().equals("")) {
            this.uDAO.save(usuario);
            return "redirect:/";
        } else {
            return "redirect:/CrearUsuario";
        }

    }

}
