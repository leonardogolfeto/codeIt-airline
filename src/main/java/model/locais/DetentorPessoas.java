package model.locais;

import model.pessoas.Pessoa;

import java.util.ArrayList;

public interface DetentorPessoas {

    ArrayList<Pessoa> getPessoas();
    Boolean removePessoa(Pessoa pessoa);
    Boolean adicionaPessoa(Pessoa pessoa);
    void removeUltimaPessoaAdicionada();
    void exibeListaDePessoas();
}
