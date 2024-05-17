package br.com.franca.clinicamedica.enums;

public enum CorRacaEnum {

    BRANCO("Branco"),
    NEGRO("Negro"),
    PARDO("Pardo"),
    INDIGENA("Indigena"),
    AMARELO("Amarelo");

    private String corRaca;

    private CorRacaEnum(String corRaca){
        this.corRaca=corRaca;
    }
}
