package com.bandtec.projetojpa01.classes;

public class UserValidations {

    public boolean validacaoEmail(String email) {
        return email.length() <= 0 ||
                email.indexOf("@") == -1 ||
                email.indexOf(".") == -1 ||
                email.isEmpty();
    }

    public boolean validacaoCPF(String cpf) {
        return cpf.length() <= 10 || cpf.length() > 11;
    }

    public boolean validacaoDataNascimento(String dataNascimento) {
        return dataNascimento.length() <= 7 || dataNascimento.length() > 8;
    }

    public boolean validacaoRG(String rg) {
        return rg.length() <= 8 || rg.length() > 9;
    }

    public boolean validacaoTelFixo(String telefoneFixo) {
        return telefoneFixo.length() <= 9 || telefoneFixo.length() > 10;
    }

    public boolean validacaoTelCel(String telefoneCelular) {
        return telefoneCelular.length() <= 10 || telefoneCelular.length() > 11;
    }

}
