package br.com.franca.clinicamedica.enums;

public enum StatusConvenioEnum {

    ATIVO("A"),
    INATIVO("I");


    private String status;

    private StatusConvenioEnum(String status){
        this.status = status;
    }
}
