/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.ServicioDAO;
import com.lp2.proyecto2.dao.TipoServicioDAO;
import com.lp2.proyecto2.modelo.Servicio;
import com.lp2.proyecto2.modelo.TipoDeServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Francisca Carmona
 */
@Controller
public class ConsultasController {
    
    @Autowired
    private TipoServicioDAO tsDao;
    
    
    
    
    
    
//    
//    @Autowired
//    private ServicioDAO sDao;
//   
//    @GetMapping("/servicio/{id}")
//    public String MostrarConsultas(Model model, @PathVariable("id") Integer id) {
//        
//        Optional<Servicio> optional = this.sDao.findById(id); 
//        
//        if (optional.isPresent()) {
//            Servicio servicio = optional.get();
//            
//        }
//        
//        return "/Consultas";
//    }
    
}
