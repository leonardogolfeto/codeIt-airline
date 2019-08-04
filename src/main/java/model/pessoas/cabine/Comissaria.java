package model.pessoas.cabine;

import model.locais.Local;
import model.pessoas.PessoaComRestricao;

public class Comissaria implements PessoaComRestricao {

    @Override
    public Boolean verificarRestricaoEntrada(Local local) {
        return local.piloto == 0 || local.oficiais + local.policial + local.chefeServico > 0;
    }

    @Override
    public Boolean verificarRestricaoSaida(Local local) {
        return local.oficiais == 0 || local.chefeServico == 0 || (local.piloto + local.policial > 0);
    }

    @Override
    public Boolean isMotorista() {
        return false;
    }
}
