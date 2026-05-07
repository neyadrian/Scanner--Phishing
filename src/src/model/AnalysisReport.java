package model;

import java.util.List;


public class AnalysisReport {

    public enum RiscoNivel {
        LEGITIMO    ("PROVAVELMENTE LEGÍTIMO",   "Nenhuma palavra suspeita encontrada."),
        BAIXO       ("BAIXO RISCO",               "Poucas palavras suspeitas. Pode ser legítimo."),
        MODERADO    ("RISCO MODERADO",            "Atenção! Este e-mail contém diversas palavras suspeitas."),
        ALTO        ("ALTO RISCO DE PHISHING",    "CUIDADO! Este e-mail apresenta forte padrão de phishing.");

        private final String titulo;
        private final String descricao;

        RiscoNivel(String titulo, String descricao) {
            this.titulo = titulo;
            this.descricao = descricao;
        }

        public String getTitulo()    { return titulo; }
        public String getDescricao() { return descricao; }
    }

    private final String arquivo;
    private final List<KeywordResult> resultados;
    private final int totalOcorrencias;
    private final int totalPontos;

    public AnalysisReport(String arquivo, List<KeywordResult> resultados) {
        this.arquivo = arquivo;
        this.resultados = resultados;

        int ocorrencias = 0;
        int pontos = 0;
        for (KeywordResult r : resultados) {
            ocorrencias += r.getOcorrencias();
            pontos      += r.getPontosGanhos();
        }
        this.totalOcorrencias = ocorrencias;
        this.totalPontos      = pontos;
    }

    public String getArquivo()              { return arquivo; }
    public List<KeywordResult> getResultados() { return resultados; }
    public int getTotalOcorrencias()        { return totalOcorrencias; }
    public int getTotalPontos()             { return totalPontos; }

    public RiscoNivel getRiscoNivel() {
        if (totalPontos == 0)       return RiscoNivel.LEGITIMO;
        if (totalPontos <= 5)       return RiscoNivel.BAIXO;
        if (totalPontos <= 15)      return RiscoNivel.MODERADO;
        return RiscoNivel.ALTO;
    }
}
