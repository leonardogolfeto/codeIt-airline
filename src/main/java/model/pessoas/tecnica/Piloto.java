package model.pessoas.tecnica;

import model.locais.Local;
import model.pessoas.PessoaComRestricao;

public class Piloto implements PessoaComRestricao {

    @Override
    public Boolean verificarRestricaoEntrada(Local local) {

        return local.comissarios == 0 && local.bandido == 0 || local.oficiais + local.policial + local.chefeServico > 0;
    }

    @Override
    public Boolean verificarRestricaoSaida(Local local) {

        return local.oficiais == 0 || local.chefeServico == 0 || (local.comissarios + local.policial > 0);
    }

    @Override
    public Boolean isMotorista() {
        return true;
    }
}
