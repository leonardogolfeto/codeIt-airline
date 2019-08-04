import service.EmbarqueService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int escolha;
        EmbarqueService embarqueService = new EmbarqueService();


        do {
            embarqueService.exibeAmbientesESuasPessoas();

            if (embarqueService.estaNoTerminal) {
                embarqueService.exibeMenuTerminal();
                escolha = input.nextInt();
                embarqueService.realizaOqueFoiEscolhidoNoMenuTerminal(escolha);

            } else {
                embarqueService.exibeMenuAviao();
                escolha = input.nextInt();
                embarqueService.realizaOqueFoiEscolhidoNoMenuAviao(escolha);
            }

        } while (escolha != 0);


    }


}
