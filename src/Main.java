import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu meuMenu = new Menu();
        meuMenu.exibirMenu();

        ConversorDeMoeda conversor = new ConversorDeMoeda();
        try {
            Moeda minhaMoeda = conversor.buscaDados(meuMenu);
            conversor.converteValores(minhaMoeda, meuMenu);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação...");
        }

       scanner.close();
    }
}