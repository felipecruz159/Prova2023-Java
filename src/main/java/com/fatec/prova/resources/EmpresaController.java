package com.fatec.prova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.prova.entities.Empresa;
import com.fatec.prova.services.EmpresaService;

@RestController 
@RequestMapping("empresas")
@CrossOrigin
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    @PostMapping 
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa){
        Empresa newEmpresa = empresaService.save(empresa);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id")
            .buildAndExpand(empresa.getId())
            .toUri();

            return ResponseEntity.created(location).body(newEmpresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable int id) {
        Empresa empresa = empresaService.getEmpresaById(id);
        return ResponseEntity.ok().body(empresa);
    }

    @GetMapping("")
    public ResponseEntity<List<Empresa>> getEmpresas(){
        List<Empresa> empresas = empresaService.getEmpresas();
        return ResponseEntity.ok().body(empresas);
    }

    
}
