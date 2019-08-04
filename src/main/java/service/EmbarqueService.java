package service;

import model.locais.Local;
import model.locais.Veiculo;
import model.pessoas.Pessoa;
import model.pessoas.cabine.ChefeServico;
import model.pessoas.cabine.Comissaria;
import model.pessoas.passageiros.Bandido;
import model.pessoas.passageiros.Policial;
import model.pessoas.tecnica.Oficial;
import model.pessoas.tecnica.Piloto;

import java.util.ArrayList;
import java.util.Scanner;

public class EmbarqueService {

    private Veiculo smartFortwo;
    private Local terminal;
    private Local aviao;
    private ArrayList<Pessoa> pessoas;
    private Piloto piloto;
    private Comissaria comissaria;
    private Comissaria comissaria2;
    private ChefeServico chefeServico;
    private Oficial oficial;
    private Oficial oficial2;
    private Policial policial;
    private Bandido bandido;
    private Scanner input;
    public boolean estaNoTerminal = true;


    public EmbarqueService() {

        this.smartFortwo = new Veiculo();
        this.terminal = new Local();
        this.aviao = new Local();
        this.pessoas = new ArrayList<>();
        this.piloto = new Piloto();
        this.comissaria = new Comissaria();
        this.comissaria2 = new Comissaria();
        this.chefeServico = new ChefeServico();
        this.oficial = new Oficial();
        this.oficial2 = new Oficial();
        this.policial = new Policial();
        this.bandido = new Bandido();
        this.input = new Scanner(System.in);
        popularPessoas();
    }

    private void popularPessoas() {
        pessoas.add(this.piloto);
        pessoas.add(this.comissaria);
        pessoas.add(this.comissaria2);
        pessoas.add(this.chefeServico);
        pessoas.add(this.oficial);
        pessoas.add(this.oficial2);
        pessoas.add(this.policial);
        pessoas.add(this.bandido);
        terminal.comissarios = 2;
        terminal.oficiais = 2;
        terminal.bandido = 1;
        terminal.policial = 1;
        terminal.piloto = 1;
        terminal.chefeServico = 1;

        terminal.setPessoas(pessoas);
    }

    private Boolean adicionaPassageiroNoVeiculoAPartirDoTerminal(int indexPessoa) {
        if (terminal.getPessoas().size() - 1 < indexPessoa)
            return false;
        return transacaoDePassageirosParaOVeiculo(indexPessoa, terminal);
    }

    private Boolean adicionaPassageiroNoVeiculoAPartirDoAviao(int indexPessoa) {
        if (aviao.getPessoas().size() - 1 < indexPessoa)
            return false;
        return transacaoDePassageirosParaOVeiculo(indexPessoa, aviao);
    }

    private Boolean adicionaPassageiroNoAviaoAPartirDoVeiculo(int indexPessoa) {
        if (indexPessoa >= 2)
            return false;

        boolean foiAdicionado = transacaoPassageirosAPartirDoVeiculo(indexPessoa, aviao);
        verificaSeOEmbarqueFoiFinalizado();
        return foiAdicionado;
    }

    private Boolean adicionaPassageiroNoTerminalAPartirDoVeiculo(int indexPessoa) {
        if (indexPessoa >= 2)
            return false;
        return transacaoPassageirosAPartirDoVeiculo(indexPessoa, terminal);
    }

    private Boolean transacaoPassageirosAPartirDoVeiculo(int indexPessoa, Local local) {

        Boolean foiAdicionado;
        Boolean foiRemovido;

        Pessoa pessoa = smartFortwo.getPessoas().get(indexPessoa);

        foiAdicionado = local.adicionaPessoa(pessoa);
        foiRemovido = smartFortwo.removePessoa(pessoa);


        if (foiAdicionado && foiRemovido) {
            return true;
        } else if (foiAdicionado)
            local.removeUltimaPessoaAdicionada();
        else if (foiRemovido)
            smartFortwo.adicionaPessoa(pessoa);

        return false;
    }

    private Boolean transacaoDePassageirosParaOVeiculo(int indexPessoa, Local local) {

        Boolean foiAdicionado;
        Boolean foiRemovido;
        Pessoa pessoa = local.getPessoas().get(indexPessoa);

        foiAdicionado = smartFortwo.adicionaPessoa(pessoa);
        foiRemovido = local.removePessoa(pessoa);

        if (foiAdicionado && foiRemovido)
            return true;
        else if (foiAdicionado)
            smartFortwo.removeUltimaPessoaAdicionada();
        else if (foiRemovido)
            local.adicionaPessoaRemovida(indexPessoa, pessoa);

        return false;
    }


    public void exibeAmbientesESuasPessoas() {

        System.out.println("TERMINAL: \n");
        terminal.exibeListaDePessoas();

        System.out.println("\n SMART FORTWO: \n");
        smartFortwo.exibeListaDePessoas();

        System.out.println("\n AVIÃO: \n");
        aviao.exibeListaDePessoas();
        System.out.println();
    }

    public void exibeMenuTerminal() {

        System.out.println("O VEICULO ESTÁ NO TERMINAL, ESCOLHA A OPÇÃO DESEJADA");
        System.out.println("--------------------------------------------\n");
        System.out.println("1 - EMBARCAR PASSAGEIRO NO VEICULO");
        System.out.println("2 - DESEMBARCAR PASSAGEIRO DO VEICULO");
        System.out.println("3 - VIAJAR PARA O AVIÃO");
        System.out.println("0 - SAIR");
    }


    public void exibeMenuAviao() {

        System.out.println("O VEICULO ESTÁ NO AVIÃO, ESCOLHA A OPÇÃO DESEJADA");
        System.out.println("--------------------------------------------\n");
        System.out.println("1 - EMBARCAR PASSAGEIRO NO AVIAO");
        System.out.println("2 - DESEMBARCAR PASSAGEIRO DO AVIAO");
        System.out.println("3 - VIAJAR PARA O TERMINAL");
        System.out.println("0 - SAIR");
    }

    public void realizaOqueFoiEscolhidoNoMenuTerminal(int escolha) {

        boolean foiRealizado;

        switch (escolha) {
            case 1: {
                if (smartFortwo.getPessoas().size() < 2) {

                    System.out.println("DIGITE O NUMERO DO PASSAGEIRO QUE VOCE DESEJA EMBARCAR:");
                    int indexPassageiro = input.nextInt();
                    foiRealizado = adicionaPassageiroNoVeiculoAPartirDoTerminal(indexPassageiro);
                    System.out.println(foiRealizado ? "O PASSAGEIRO ENTROU NO VEICULO COM SUCESSO !" : "O PASSAGEIRO NAO PODE ENTRAR NO VEICULO, VERIFIQUE AS REGRAS DE EMBARQUE !");

                } else {

                    System.out.println("O VEICULO ESTA CHEIO !!!");
                }
            }
            break;

            case 2: {
                if (smartFortwo.getPessoas().size() > 0) {

                    System.out.println("DIGITE O NUMERO DO PASSAGEIRO QUE VOCE DESEJA DESEMBARCAR:");
                    int indexPassageiro = input.nextInt();
                    foiRealizado = adicionaPassageiroNoTerminalAPartirDoVeiculo(indexPassageiro);
                    System.out.println(foiRealizado ? "O PASSAGEIRO ENTROU NO TERMINAL COM SUCESSO !" : "O PASSAGEIRO NAO PODE ENTRAR NO TERMINAL, VERIFIQUE AS REGRAS DE EMBARQUE !");

                } else {
                    System.out.println("O VEICULO ESTÁ VAZIO !\n");
                }
            }
            break;

            case 3: {
                if (smartFortwo.temMotorista()) {
                    System.out.println("VIAJANDO...");
                    estaNoTerminal = false;
                } else
                    System.out.println("O VEICULO ESTÁ SEM MOTORISTA !!!\n");
            }
            break;

            default: {
                System.out.println("DIGITE UM VALOR VALIDO PARA O MENU.");
            }
            break;

        }

    }

    public void realizaOqueFoiEscolhidoNoMenuAviao(int escolha) {

        boolean foiRealizado;

        switch (escolha) {
            case 1: {

                System.out.println("DIGITE O NUMERO DO PASSAGEIRO QUE VOCE DESEJA EMBARCAR:");
                int indexPassageiro = input.nextInt();
                foiRealizado = adicionaPassageiroNoAviaoAPartirDoVeiculo(indexPassageiro);
                System.out.println(foiRealizado ? "O PASSAGEIRO ENTROU NO AVIÃO COM SUCESSO !" : "O PASSAGEIRO NAO PODE ENTRAR NO AVIÃO, VERIFIQUE AS REGRAS DE EMBARQUE !");
            }
            break;

            case 2: {
                if (!aviao.getPessoas().isEmpty()) {

                    System.out.println("DIGITE O NUMERO DO PASSAGEIRO QUE VOCE DESEJA DESEMBARCAR:");
                    int indexPassageiro = input.nextInt();
                    foiRealizado = adicionaPassageiroNoVeiculoAPartirDoAviao(indexPassageiro);
                    System.out.println(foiRealizado ? "O PASSAGEIRO ENTROU NO VEICULO COM SUCESSO !" : "O PASSAGEIRO NAO PODE ENTRAR NO VEICULO, VERIFIQUE AS REGRAS DE EMBARQUE !");

                } else {
                    System.out.println("O AVIÃO ESTÁ VAZIO !");
                }
            }
            break;
            case 3: {

                if (smartFortwo.temMotorista()) {
                    System.out.println("VIAJANDO...");
                    estaNoTerminal = true;
                } else
                    System.out.println("O VEICULO ESTÁ SEM MOTORISTA !!!");
            }
            break;
            default: {
                System.out.println("DIGITE UM VALOR VALIDO PARA O MENU.");
            }
            break;
        }

    }

    private void verificaSeOEmbarqueFoiFinalizado() {

        if (aviao.getPessoas().size() == 8) {
            System.out.println("EMBARQUE REALIZADO COM SUCESSO !!!!!");
            System.exit(0);
        }
    }
}
