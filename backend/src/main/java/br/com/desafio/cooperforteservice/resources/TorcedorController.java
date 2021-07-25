package br.com.desafio.cooperforteservice.resources;

import br.com.desafio.cooperforteservice.dtos.TorcedorDTO;
import br.com.desafio.cooperforteservice.entities.Torcedor;
import br.com.desafio.cooperforteservice.services.AutenticacaoService;
import br.com.desafio.cooperforteservice.services.TorcedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/torcedores")
public class TorcedorController {

    private TorcedorService torcedorService;

    private AutenticacaoService autenticacaoService;

    @GetMapping
    public ResponseEntity<List<Torcedor>> listar(){
        return ResponseEntity.ok(torcedorService.listar());
    }

    @PostMapping
    public ResponseEntity<Torcedor> novo(@RequestBody @Valid TorcedorDTO torcedorDTO){
        Torcedor novo = torcedorService.novo(torcedorDTO);
        return ResponseEntity.ok(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        torcedorService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torcedor> editar(@PathVariable("id") Long id, @RequestBody @Valid TorcedorDTO torcedorDTO){
        Torcedor torcedor = torcedorService.editar(id, torcedorDTO);
        return ResponseEntity.ok(torcedor);
    }
}
