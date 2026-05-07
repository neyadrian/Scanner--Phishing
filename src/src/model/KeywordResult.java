package model;

public class KeywordResult {

    private final Keyword keyword;
    private final int ocorrencias;
    private final int pontosGanhos;

    public KeywordResult(Keyword keyword, int ocorrencias) {
        this.keyword = keyword;
        this.ocorrencias = ocorrencias;
        this.pontosGanhos = ocorrencias * keyword.getPontuacao();
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public int getPontosGanhos() {
        return pontosGanhos;
    }

    public boolean foiEncontrada() {
        return ocorrencias > 0;
    }
}
