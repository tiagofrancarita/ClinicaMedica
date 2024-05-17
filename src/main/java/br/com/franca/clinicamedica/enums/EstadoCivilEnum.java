package br.com.franca.clinicamedica.enums;

public enum EstadoCivilEnum {

    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    SEPARADO("Separado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viuvo");

    private String estadoCivil;

    private EstadoCivilEnum(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
}