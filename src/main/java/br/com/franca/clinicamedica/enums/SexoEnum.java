package br.com.franca.clinicamedica.enums;

public enum SexoEnum {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");


    private String sexo;

    private SexoEnum(String sexo){
        this.sexo = sexo;
    }
}