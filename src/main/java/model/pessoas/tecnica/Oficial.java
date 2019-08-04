package model.pessoas.tecnica;

import model.locais.Local;
import model.pessoas.PessoaComRestricao;

public class Oficial implements PessoaComRestricao {

    @Override
    public Boolean verificarRestricaoEntrada(Local local) {
        return local.chefeServico == 0 || local.comissarios + local.policial + local.piloto > 0;
    }


    @Override
    public Boolean verificarRestricaoSaida(Local local) {
        return local.comissarios == 0 || local.piloto == 0 || (local.chefeServico + local.policial > 0);
    }

    @Override
    public Boolean isMotorista() {
        return false;
    }
}
