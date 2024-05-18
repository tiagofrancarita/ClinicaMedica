package br.com.franca.clinicamedica.utils;

import br.com.franca.clinicamedica.dtos.TipoPlanoDTO;
import br.com.franca.clinicamedica.entities.TipoPlano;

public class TipoPlanoMapper {
    public static TipoPlanoDTO toDTO(TipoPlano tipoPlano) {
        TipoPlanoDTO dto = new TipoPlanoDTO();
        dto.setId(tipoPlano.getId());
        dto.setNome(tipoPlano.getNome());
        dto.setDataInicio(tipoPlano.getDataInicio());
        dto.setDataFim(tipoPlano.getDataFim());
        return dto;
    }

    public static TipoPlano toEntity(TipoPlanoDTO dto) {
        TipoPlano tipoPlano = new TipoPlano();
        tipoPlano.setId(dto.getId());
        tipoPlano.setNome(dto.getNome());
        tipoPlano.setDataInicio(dto.getDataInicio());
        tipoPlano.setDataFim(dto.getDataFim());
        return tipoPlano;
    }
}
