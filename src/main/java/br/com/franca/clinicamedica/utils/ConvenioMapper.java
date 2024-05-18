package br.com.franca.clinicamedica.utils;

import br.com.franca.clinicamedica.dtos.ConvenioDTO;
import br.com.franca.clinicamedica.dtos.TipoPlanoDTO;
import br.com.franca.clinicamedica.entities.Convenio;

import java.util.stream.Collectors;

public class ConvenioMapper {

    public static ConvenioDTO toDTO(Convenio convenio) {
        ConvenioDTO dto = new ConvenioDTO();
        dto.setId(convenio.getId());
        dto.setNome(convenio.getNome());
        dto.setStatusConvenio(convenio.getStatusConvenio());
        dto.setCnpj(convenio.getCnpj());
        dto.setRegistroAns(convenio.getRegistroAns());
        // Convertendo os TipoPlanos para DTOs
        if (convenio.getTipoPlano() != null) {
            dto.setTipoPlano(convenio.getTipoPlano().stream()
                    .map(TipoPlanoMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Convenio toEntity(ConvenioDTO dto) {
        Convenio convenio = new Convenio();
        convenio.setId(dto.getId());
        convenio.setNome(dto.getNome());
        convenio.setStatusConvenio(dto.getStatusConvenio());
        convenio.setCnpj(dto.getCnpj());
        convenio.setRegistroAns(dto.getRegistroAns());
        // Convertendo os TipoPlanos DTOs para entidades
        if (dto.getTipoPlano() != null) {
            convenio.setTipoPlano(dto.getTipoPlano().stream()
                    .map(TipoPlanoMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return convenio;
    }
}