package model.pessoas.cabine;

import model.locais.Local;
import model.pessoas.PessoaComRestricao;


public class ChefeServico implements PessoaComRestricao {

    @Override
    public Boolean verificarRestricaoEntrada(Local local) {
        return local.oficiais == 0 || local.comissarios + local.policial + local.piloto > 0;
    }

    @Override
    public Boolean verificarRestricaoSaida(Local local) {
        return local.comissarios == 0 || local.piloto == 0 || (local.oficiais + local.policial > 0);
    }

    @Override
    public Boolean isMotorista() {
        return true;
    }
}
