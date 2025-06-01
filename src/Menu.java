import java.util.Scanner;

public class Menu {

    private String base;
    private String target;

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public void exibirMenu() {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("""
                *****************************************
                \nBem-vindo ao CODEMO - Conversor de Moedas
                \n*****************************************
                """);

        System.out.println("""
                1) Real Brasileiro [BRL] → Dólar Americano [USD]
                2) Dólar Americano [USD] → Real Brasileiro [BRL]
                3) Real Brasileiro [BRL] → Euro [EUR]
                4) Euro [EUR] → Real Brasileiro [BRL]
                5) Dólar Americano [USD] → Euro [EUR]
                6) Euro [EUR] → Dólar Americano [USD]
                """);

        System.out.println("Digite uma opção válida (1 - 6)");
        opcao = scanner.nextInt();

        while (opcao < 1 || opcao > 6) {

            System.out.println("Opção inválida. Digite um número entre 1 e 6 para escolher a opção desejada.");
            opcao = scanner.nextInt();

        }

        if (opcao == 1) {
            this.base = "BRL";
            this.target = "USD";
        } else if (opcao == 2) {
            this.base = "USD";
            this.target = "BRL";
        } else if (opcao == 3) {
            this.base = "BRL";
            this.target = "EUR";
        } else if (opcao == 4) {
            this.base = "EUR";
            this.target = "BRL";
        } else if (opcao == 5) {
            this.base = "USD";
            this.target = "EUR";
        } else {
            this.base = "EUR";
            this.target = "USD";
        }
    }
}