package com.example.demo;

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



 post @Orcamento{
    "title": "Comprar suprimentos",
        "description": "Comprar suprimentos para o escritório",
        "dueDate": "2024-10-30",
        "priority": "alta"
}


@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @PostMapping
    public Orcamento criarOrcamento(@RequestBody Orcamento orcamento){
        return orcamentoService.insertOrcamento(orcamento);
    }

    @GetMapping
    public List<Orcamento> listarOrcamento(){
        return orcamentoService.selectAllOrcamento();
    }

    @PutMapping("/{id}/aprovar")
    public Orcamento aprovarOrcamento(@PathVariable int id){
        return orcamentoService.aprovarOrcamento(id);
    }

    @GetMapping("/{id}")
    public Orcamento buscarById(@PathVariable int id){
        return orcamentoService.selectOrcamentoById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        orcamentoService.deletarOrcamento(id);
    }
}