package br.com.franca.clinicamedica.controller;

import br.com.franca.clinicamedica.dtos.ConvenioDTO;
import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.usecases.convenio.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/convenios")
public class ConvenioController {

    private final CreateConvenioUseCase createConvenioUseCase;
    private final DeleteConvenioUseCase deleteConvenioUseCase;
    private final GetConvenioUseCase getConvenioUseCase;
    private final ListConvenioUseCase listConvenioUseCase;
    private final UpdateConvenioUseCase updateConvenioUseCase;
    private final ModelMapper modelMapper;


    @Autowired
    public ConvenioController(CreateConvenioUseCase createConvenioUseCase, DeleteConvenioUseCase deleteConvenioUseCase, GetConvenioUseCase getConvenioUseCase, ListConvenioUseCase listConvenioUseCase, UpdateConvenioUseCase updateConvenioUseCase, ModelMapper modelMapper) {
        this.createConvenioUseCase = createConvenioUseCase;
        this.deleteConvenioUseCase = deleteConvenioUseCase;
        this.getConvenioUseCase = getConvenioUseCase;
        this.listConvenioUseCase = listConvenioUseCase;
        this.updateConvenioUseCase = updateConvenioUseCase;
        this.modelMapper = modelMapper;
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
    public ResponseEntity<Page<ConvenioDTO>> listAllConvenios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome") String sortBy) {
        Page<Convenio> convenios = listConvenioUseCase.listAllConvenios(page, size, sortBy);

        List<ConvenioDTO> convenioDTOs = convenios.stream()
                .map(convenio -> modelMapper.map(convenio, ConvenioDTO.class))
                .collect(Collectors.toList());

        Page<ConvenioDTO> convenioDTOPage = new PageImpl<>(convenioDTOs, PageRequest.of(page, size, Sort.by(sortBy)), convenios.getTotalElements());

        return ResponseEntity.ok(convenioDTOPage);

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
