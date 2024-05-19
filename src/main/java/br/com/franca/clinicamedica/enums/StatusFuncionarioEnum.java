package br.com.franca.clinicamedica.enums;

public enum StatusFuncionarioEnum {

    ATIVO("A"),
    INATIVO("I");


    private String status;

    private StatusFuncionarioEnum(String status){
        this.status = status;
    }
}
