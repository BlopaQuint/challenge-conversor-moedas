import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMoeda {

    public Moeda buscaDados(Menu meuMenu) {

        String base = meuMenu.getBase();
        String target = meuMenu.getTarget();

        String apiKey = "319d5518edbc316c951fe328";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base +  "/" + target);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter comunicação com o servidor.");
        }

    }

    public void converteValores(Moeda minhaMoeda, Menu meuMenu) {

        Scanner scanner = new Scanner(System.in);

        double taxaDeConversao = minhaMoeda.conversionRate();
        System.out.println("Digite o valor para a conversão:");

        double valor = scanner.nextDouble();
        double resultado = valor * taxaDeConversao;

        System.out.println(String.format("O valor de %.2f %s convertido para %s é igual a %.2f %s",
                valor, meuMenu.getBase(), meuMenu.getTarget(), resultado, meuMenu.getTarget()));

    }
}