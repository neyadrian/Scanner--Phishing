package ui;

import model.AnalysisReport;
import model.KeywordResult;

/**
 * Responsável por toda a saída formatada no console.
 */
public class ConsoleUI {

    private static final int LARGURA = 65;

    public void exibirCabecalho() {
        System.out.println();
        System.out.println("  ╔═══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                  SCANNER DE PHISHING                      ║");
        System.out.println("  ║   Detecta palavras suspeitas em e-mails e mensagens       ║");
        System.out.println("  ╚═══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Pontuação: 1 = pouco provável | 2 = moderado | 3 = altamente provável");
        System.out.println();
    }

    public void exibirRelatorio(AnalysisReport relatorio) {
        System.out.println("\n" + "=".repeat(LARGURA));
        System.out.println("  ANALISANDO: " + relatorio.getArquivo());
        System.out.println("=".repeat(LARGURA));

        if (relatorio.getResultados().isEmpty()) {
            System.out.println("\n  Nenhuma palavra suspeita encontrada.\n");
        } else {
            System.out.printf("\n%-35s %10s %10s%n", "PALAVRA / FRASE", "OCORRÊNCIAS", "PONTOS");
            System.out.println("-".repeat(58));

            for (KeywordResult resultado : relatorio.getResultados()) {
                System.out.printf("%-35s %10d %10d%n",
                        resultado.getKeyword().getTermo(),
                        resultado.getOcorrencias(),
                        resultado.getPontosGanhos());
            }

            System.out.println("-".repeat(58));
            System.out.printf("%-35s %10d %10d%n",
                    "TOTAL",
                    relatorio.getTotalOcorrencias(),
                    relatorio.getTotalPontos());
        }

        System.out.println("=".repeat(LARGURA));
        exibirVeredicto(relatorio);
    }

    private void exibirVeredicto(AnalysisReport relatorio) {
        AnalysisReport.RiscoNivel nivel = relatorio.getRiscoNivel();
        System.out.println();
        System.out.println("  RESULTADO: " + nivel.getTitulo()
                + " (score = " + relatorio.getTotalPontos() + ")");
        System.out.println("  " + nivel.getDescricao());
        System.out.println("=".repeat(LARGURA));
        System.out.println();
    }

    public void exibirErro(String mensagem) {
        System.out.println("\n[ERRO] " + mensagem);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
