/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.UsuarioDAO;
import com.lp2.proyecto2.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Francisca Carmona
 */
@Controller
public class verUsuarioController {

    @Autowired
    private UsuarioDAO uDao;

    @GetMapping("/verUsuarios")
    public String verUsuarios(Model model) {
        List<Usuario> lista = uDao.findAll();
        model.addAttribute("listaUsuarios", lista);
        return "verUsuarios";
    }
}
