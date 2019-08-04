package model.locais;

import model.pessoas.Pessoa;
import model.pessoas.cabine.ChefeServico;
import model.pessoas.cabine.Comissaria;
import model.pessoas.passageiros.Bandido;
import model.pessoas.passageiros.Policial;
import model.pessoas.tecnica.Oficial;
import model.pessoas.tecnica.Piloto;

import java.util.ArrayList;

public class Veiculo implements DetentorPessoas {

    private ArrayList<Pessoa> pessoas;

    public Veiculo() {
        this.pessoas = new ArrayList<>();
    }

    @Override
    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    @Override
    public Boolean adicionaPessoa(Pessoa pessoa) {

        if (pessoas.isEmpty()) {
            pessoas.add(pessoa);
            return true;

        } else if (pessoas.size() == 1) {
            if (verificaSePessoaPodeSerAdicionada(pessoa)) {
                pessoas.add(pessoa);
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean removePessoa(Pessoa pessoa) {

        pessoas.remove(pessoa);
        return true;
    }

    @Override
    public void removeUltimaPessoaAdicionada() {
        pessoas.remove(pessoas.size() - 1);
    }

    private Boolean verificaSePessoaPodeSerAdicionada(Pessoa pessoa) {
        Pessoa PassageiroAtual = pessoas.get(0);

        if (PassageiroAtual.getClass().equals(Policial.class))
            return true;

        if (PassageiroAtual.getClass().equals(Bandido.class))
            return pessoa.getClass().equals(Policial.class);

        if (PassageiroAtual.getClass().equals(Piloto.class))
            return pessoa.getClass().equals(Oficial.class) || pessoa.getClass().equals(Policial.class) || pessoa.getClass().equals(ChefeServico.class);

        if (PassageiroAtual.getClass().equals(ChefeServico.class))
            return pessoa.getClass().equals(Comissaria.class) || pessoa.getClass().equals(Policial.class) || pessoa.getClass().equals(Piloto.class);

        if (PassageiroAtual.getClass().equals(Comissaria.class))
            return pessoa.getClass().equals(ChefeServico.class) || pessoa.getClass().equals(Policial.class);

        if (PassageiroAtual.getClass().equals(Oficial.class))
            return pessoa.getClass().equals(Piloto.class) || pessoa.getClass().equals(Policial.class);

        return false;
    }

    @Override
    public void exibeListaDePessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("VAZIO...");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoas.indexOf(pessoa) + "-" + pessoa.getClass().getSimpleName());
            }
        }

    }

    public boolean temMotorista() {
        for (Pessoa pessoa : pessoas)
            if (pessoa.isMotorista()) return true;
        return false;
    }
}
