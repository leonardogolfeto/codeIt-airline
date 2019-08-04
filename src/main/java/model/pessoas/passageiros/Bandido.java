package model.pessoas.passageiros;

import model.pessoas.Pessoa;

public class Bandido implements Pessoa {

    @Override
    public Boolean isMotorista() {
        return false;
    }
}
