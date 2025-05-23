package com.quizcamila.app.controlador;

import com.quizcamila.app.entidades.Equipo;
import com.quizcamila.app.repositorio.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import java.util.List;


@Controller
public class EquipoControlador {

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    @GetMapping("/")
    public String mostrarInicio() {
        return "index"; 
    }

    @GetMapping("/veragenda")
    public String mostrarFormulario(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "formagenda"; 
    }

    @PostMapping("/guardar")
    public String guardarEquipo(@Valid Equipo equipo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formagenda"; 
        }

        equipoRepositorio.save(equipo); 
        model.addAttribute("mensaje", "¡Equipo guardado con éxito!");
        model.addAttribute("equipo", new Equipo()); 
        return "formagenda";
    }
    
    @GetMapping("/verlista")
    public String verEquipos(Model model) {
        List<Equipo> equipos = equipoRepositorio.findAll();
        model.addAttribute("equipos", equipos);
        return "veragenda";
    }

}
