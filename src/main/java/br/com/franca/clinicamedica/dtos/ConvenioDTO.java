package br.com.franca.clinicamedica.dtos;

import br.com.franca.clinicamedica.enums.StatusConvenioEnum;

import java.util.List;

public class ConvenioDTO {

    private Long id;
    private String nome;
    private List<TipoPlanoDTO> tipoPlano;
    private StatusConvenioEnum statusConvenio;
    private String cnpj;
    private String registroAns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TipoPlanoDTO> getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(List<TipoPlanoDTO> tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public StatusConvenioEnum getStatusConvenio() {
        return statusConvenio;
    }

    public void setStatusConvenio(StatusConvenioEnum statusConvenio) {
        this.statusConvenio = statusConvenio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRegistroAns() {
        return registroAns;
    }

    public void setRegistroAns(String registroAns) {
        this.registroAns = registroAns;
    }
}
