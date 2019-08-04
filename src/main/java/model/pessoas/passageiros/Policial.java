package model.pessoas.passageiros;

import model.pessoas.Pessoa;

public class Policial implements Pessoa {

    @Override
    public Boolean isMotorista() {
        return true;
    }
}
