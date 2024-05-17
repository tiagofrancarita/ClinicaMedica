package br.com.franca.clinicamedica.enums;

public enum FormaPagamentoEnum {
    CONVENIO("Convênio"),
    DINHEIRO("Dinheiro"),
    PIX("Pix"),
    CREDITO("Crédito"),
    DEBITO("Débito");

    private String formaPagamento;

    private FormaPagamentoEnum(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }
}
