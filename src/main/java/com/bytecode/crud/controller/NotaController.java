package com.bytecode.crud.controller;

import com.bytecode.crud.model.Nota;
import com.bytecode.crud.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("notas");

        modelAndView.addObject("notas", notaRepository.findAll());
        modelAndView.addObject("nota", new Nota());

        return modelAndView;
    }

    @PostMapping
    public String save(@ModelAttribute Nota nota){
        notaRepository.save(nota);
        return "redirect:/nota";
    }

    @PostMapping("/actualizar")
    public String update(@RequestParam long id,
                         @RequestParam String titulo,
                         @RequestParam String descripcion){
        Nota nota = notaRepository.findById(id).get();

        nota.setDescripcion(descripcion);
        nota.setTitulo(titulo);
        nota.setFechaActualizacion(new Date());

        notaRepository.save(nota);
        return "redirect:/nota";
    }

    @PostMapping("/eliminar")
    public String delete(@RequestParam long id){
        notaRepository.deleteById(id);
        return "redirect:/nota";
    }
}
