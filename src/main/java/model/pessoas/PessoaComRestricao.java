package model.pessoas;

import model.locais.Local;

public interface PessoaComRestricao extends Pessoa {

    Boolean verificarRestricaoEntrada(Local local);
    Boolean verificarRestricaoSaida(Local local);
}
