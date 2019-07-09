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
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class TipoServicioController {

    @Autowired
    private TipoServicioDAO tsDao;
    @Autowired
    private ServicioDAO sDAO;

    @GetMapping("/tipos_servicio/{id}")
    public String mostrarTipos(Model model, @PathVariable("id") Integer id) {

        List<TipoDeServicio> list = tsDao.findByIdServicio_IdServicio(id);
        model.addAttribute("listamanicure", list);

        return "/TipoServicio";
    }

    @GetMapping("/tipo-servicio/{id}")
    public String tipoServicio(Model model, @PathVariable("id") Integer id) {
        Optional<TipoDeServicio> optional = this.tsDao.findById(id);

        if (optional.isPresent()) {
            TipoDeServicio tipoServicio = optional.get();
            model.addAttribute("Nombre", tipoServicio.getNombre());
            model.addAttribute("Profesional", tipoServicio.getProfesional());
            model.addAttribute("Descripcion", tipoServicio.getDescripcion());
            model.addAttribute("Email", tipoServicio.getEmail_servicio());
        }
        return "Consultas";
    }

    @GetMapping("/principal")
    public String mostrarPrincipal(Model model) {
        return "/Principal";
    }

    //revisar
    @GetMapping("/agregar-tipo-servicio/{id}")
    public String mostrarFormulario(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("nuevoTipoServicio", new TipoDeServicio());
        Optional<Servicio> optional = this.sDAO.findById(id);

        if (optional.isPresent()) {
            Servicio servicio = optional.get();
            model.addAttribute("id_servicio", servicio.getIdServicio());
        }

        return "agregarTipoServicio";
    }

    @PostMapping("/agregar-tipo-servicio/{id}")
    public String crearServicio(@ModelAttribute TipoDeServicio tiposervicio, HttpServletResponse response, @PathVariable("id") Integer id) throws IOException {

        Optional<Servicio> s = sDAO.findById(id);

        tiposervicio.setIdServicio(s.get());

        if (!tiposervicio.getNombre().equals("")) {
            this.tsDao.save(tiposervicio);
            response.sendRedirect("/principal");
        } else {
            return "redirect:/agregar-tipo-servicio/{id}";
        }

         return null;
    }
}
