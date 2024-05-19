package br.com.franca.clinicamedica.enums;

public enum TipoUsuarioEnum {

    MEDICO("Médico"),
    PACIENTE("Paciente"),
    ENFERMEIRO("Enfermeiro");


    private String tipoUsuario;

    private TipoUsuarioEnum(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
}
