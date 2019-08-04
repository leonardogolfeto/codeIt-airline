package model.locais;

import model.pessoas.Pessoa;
import model.pessoas.cabine.ChefeServico;
import model.pessoas.cabine.Comissaria;
import model.pessoas.passageiros.Bandido;
import model.pessoas.passageiros.Policial;
import model.pessoas.tecnica.Oficial;
import model.pessoas.tecnica.Piloto;

import java.util.ArrayList;

public class Local implements DetentorPessoas {

    public int oficiais;
    public int comissarios;
    public int bandido;
    public int policial;
    public int piloto;
    public int chefeServico;

    private ArrayList<Pessoa> pessoas;

    public Local() {

        oficiais = 0;
        comissarios = 0;
        bandido = 0;
        policial = 0;
        piloto = 0;
        chefeServico = 0;
        this.pessoas = new ArrayList<>();
    }

    @Override
    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public Boolean adicionaPessoa(Pessoa pessoa) {

        if (verificaSePessoaPodeSerAdicionada(pessoa)) {
            pessoas.add(pessoa);
            return true;
        }

        return false;
    }

    public void adicionaPessoaRemovida(int indexPessoa, Pessoa pessoa) {
        pessoas.add(indexPessoa, pessoa);
    }

    @Override
    public Boolean removePessoa(Pessoa pessoa) {

        if (verificaSePessoaPodeSerRemovida(pessoa)) {
            pessoas.remove(pessoa);
            return true;
        }
        return false;
    }

    @Override
    public void removeUltimaPessoaAdicionada() {

        pessoas.remove(pessoas.size() - 1);

    }

    private Boolean verificaSePessoaPodeSerAdicionada(Pessoa pessoa) {

        boolean podeSerAdicionado;

        if (pessoa.getClass().equals(Policial.class)) {
            policial++;
            return true;
        }

        if (pessoa.getClass().equals(Bandido.class)) {
            if (policial == 1 || comissarios + oficiais + piloto + chefeServico == 0) {
                bandido++;
                return true;
            }
            return false;
        }

        if (pessoa.getClass().equals(Piloto.class)) {

            Piloto pessoaPiloto = new Piloto();

            podeSerAdicionado = verificaSeAListaEstaVazia() || (pessoaPiloto.verificarRestricaoEntrada(this) && verificaSeBandidoEstaComPolicial());

            piloto += podeSerAdicionado ? 1 : 0;
            return podeSerAdicionado;

        }


        if (pessoa.getClass().equals(ChefeServico.class)) {

            ChefeServico pessoaChefeServico = new ChefeServico();

            podeSerAdicionado = verificaSeAListaEstaVazia() || (pessoaChefeServico.verificarRestricaoEntrada(this) && verificaSeBandidoEstaComPolicial());

            chefeServico += podeSerAdicionado ? 1 : 0;
            return podeSerAdicionado;
        }

        if (pessoa.getClass().equals(Comissaria.class)) {

            Comissaria pessoaComissaria = new Comissaria();

            podeSerAdicionado = verificaSeAListaEstaVazia() || (pessoaComissaria.verificarRestricaoEntrada(this) && verificaSeBandidoEstaComPolicial());

            comissarios += podeSerAdicionado ? 1 : 0;
            return podeSerAdicionado;
        }

        if (pessoa.getClass().equals(Oficial.class)) {

            Oficial pessoaOficial = new Oficial();

            podeSerAdicionado = verificaSeAListaEstaVazia() || (pessoaOficial.verificarRestricaoEntrada(this) && verificaSeBandidoEstaComPolicial());

            oficiais += podeSerAdicionado ? 1 : 0;
            return podeSerAdicionado;
        }

        return false;
    }

    private Boolean verificaSePessoaPodeSerRemovida(Pessoa pessoa) {

        boolean podeSerRemovido;

        if (pessoa.getClass().equals(Policial.class)) {

            podeSerRemovido = bandido == 0 || comissarios + chefeServico + piloto + oficiais == 0;
            policial -= podeSerRemovido ? 1 : 0;
            return podeSerRemovido;


        }

        if (pessoa.getClass().equals(Bandido.class)) {
            bandido--;
            return true;
        }

        if (pessoa.getClass().equals(Piloto.class)) {

            Piloto pessoaPiloto = new Piloto();
            podeSerRemovido = verificaSeEUltimo() || pessoaPiloto.verificarRestricaoSaida(this);

            piloto -= podeSerRemovido ? 1 : 0;
            return podeSerRemovido;

        }


        if (pessoa.getClass().equals(ChefeServico.class)) {

            ChefeServico pessoaChefeServico = new ChefeServico();
            podeSerRemovido = verificaSeEUltimo() || pessoaChefeServico.verificarRestricaoSaida(this);

            chefeServico -= podeSerRemovido ? 1 : 0;
            return podeSerRemovido;
        }

        if (pessoa.getClass().equals(Comissaria.class)) {

            Comissaria pessoaComissaria = new Comissaria();
            podeSerRemovido = verificaSeEUltimo() || pessoaComissaria.verificarRestricaoSaida(this);

            comissarios -= podeSerRemovido ? 1 : 0;
            return podeSerRemovido;
        }

        if (pessoa.getClass().equals(Oficial.class)) {

            Oficial pessoaOficial = new Oficial();
            podeSerRemovido = verificaSeEUltimo() || pessoaOficial.verificarRestricaoSaida(this);

            oficiais -= podeSerRemovido ? 1 : 0;
            return podeSerRemovido;
        }

        return false;

    }


    private Boolean verificaSeAListaEstaVazia() {

        return pessoas.isEmpty();
    }

    private Boolean verificaSeEUltimo() {

        return pessoas.size() == 1;
    }

    private Boolean verificaSeBandidoEstaComPolicial() {

        return bandido == 0 || policial > 0;
    }

    @Override
    public void exibeListaDePessoas(){

        if (verificaSeAListaEstaVazia()) {
            System.out.println("VAZIO...");

        } else {
            for (Pessoa pessoa : pessoas)
                System.out.println(pessoas.indexOf(pessoa) + "-" + pessoa.getClass().getSimpleName());
        }

    }

}
