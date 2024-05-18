package br.com.franca.clinicamedica.controller;

import br.com.franca.clinicamedica.dtos.ConvenioDTO;
import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.usecases.convenio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/convenios")
public class ConvenioController {

    private final CreateConvenioUseCase createConvenioUseCase;
    private final DeleteConvenioUseCase deleteConvenioUseCase;
    private final GetConvenioUseCase getConvenioUseCase;
    private final ListConvenioUseCase listConvenioUseCase;
    private final UpdateConvenioUseCase updateConvenioUseCase;

    @Autowired
    public ConvenioController(CreateConvenioUseCase createConvenioUseCase, DeleteConvenioUseCase deleteConvenioUseCase, GetConvenioUseCase getConvenioUseCase, ListConvenioUseCase listConvenioUseCase, UpdateConvenioUseCase updateConvenioUseCase) {
        this.createConvenioUseCase = createConvenioUseCase;
        this.deleteConvenioUseCase = deleteConvenioUseCase;
        this.getConvenioUseCase = getConvenioUseCase;
        this.listConvenioUseCase = listConvenioUseCase;
        this.updateConvenioUseCase = updateConvenioUseCase;
    }

    @PostMapping("/createConvenio")
    public ResponseEntity<ConvenioDTO> createConvenio(@RequestBody ConvenioDTO convenioDTO) {
        ConvenioDTO createdConvenioDTO = createConvenioUseCase.createConvenio(convenioDTO);
        return ResponseEntity.ok(createdConvenioDTO);
    }

    @GetMapping("getConvenio/{id}")
    public ResponseEntity<Convenio> getConvenio(@PathVariable Long id) {
        Optional<Convenio> convenio = getConvenioUseCase.getConvenio(id);
        return convenio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/listAllConvenios")
    public ResponseEntity<Page<Convenio>> listAllConvenios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome") String sortBy) {
        Page<Convenio> convenios = listConvenioUseCase.listAllConvenios(page, size, sortBy);
        return ResponseEntity.ok(convenios);
    }
    @DeleteMapping("deleteConvenio/{id}")
    public ResponseEntity<Void> deleteConvenio(@PathVariable Long id) {
        try {
            deleteConvenioUseCase.deleteConvenio(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("updateConvenio/{id}")
    public ResponseEntity<Convenio> updateConvenio(@PathVariable Long id, @RequestBody Convenio convenio) {
        if (!getConvenioUseCase.getConvenio(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        convenio.setId(id);
        Convenio updatedConvenio = updateConvenioUseCase.updateConvenio(convenio);
        return ResponseEntity.ok(updatedConvenio);
    }
}
