package phishing;

import analyzer.TextAnalyzer;
import model.AnalysisReport;
import ui.ConsoleUI;
import utils.FileReader;
import utils.SampleEmailGenerator;

import java.io.IOException;
import java.util.Scanner;

/**
 * 15.10 - Scanner de Phishing
 *
 * Ponto de entrada da aplicação. Coordena a leitura do arquivo,
 * a análise do conteúdo e a exibição do relatório.
 */
public class Main {

    private static final String PASTA_EMAILS = "emails";

    public static void main(String[] args) {
        ConsoleUI ui           = new ConsoleUI();
        TextAnalyzer analyzer  = new TextAnalyzer();
        FileReader fileReader  = new FileReader();
        Scanner input          = new Scanner(System.in);

        ui.exibirCabecalho();

        System.out.print("Digite o caminho do arquivo de texto a ser analisado\n" +
                "(ou pressione Enter para usar os e-mails de exemplo): ");
        String caminho = input.nextLine().trim();

        if (caminho.isEmpty()) {
            caminho = criarExemplos(ui, input);
            if (caminho == null) return;
        } else if (!fileReader.existe(caminho)) {
            ui.exibirErro("Arquivo não encontrado: " + caminho);
            return;
        }

        try {
            String conteudo = fileReader.ler(caminho);
            AnalysisReport relatorio = analyzer.analisar(caminho, conteudo);
            ui.exibirRelatorio(relatorio);
        } catch (IOException e) {
            ui.exibirErro("Não foi possível ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Cria e-mails de exemplo e pede ao usuário qual analisar.
     */
    private static String criarExemplos(ConsoleUI ui, Scanner input) {
        SampleEmailGenerator gerador = new SampleEmailGenerator();
        try {
            String phishing = gerador.gerarEmailPhishing(PASTA_EMAILS);
            String legitimo = gerador.gerarEmailLegitimo(PASTA_EMAILS);

            ui.exibirMensagem("\nArquivos de exemplo criados em '" + PASTA_EMAILS + "/':");
            ui.exibirMensagem("  [1] " + phishing + "  (alto risco)");
            ui.exibirMensagem("  [2] " + legitimo + "  (legítimo)");
            ui.exibirMensagem("");

            System.out.print("Escolha [1] ou [2]: ");
            String opcao = input.nextLine().trim();

            return opcao.equals("2") ? legitimo : phishing;

        } catch (IOException e) {
            ui.exibirErro("Não foi possível criar os arquivos de exemplo: " + e.getMessage());
            return null;
        }
    }
}
