package model;

public class Keyword {

    private final String termo;
    private final int pontuacao;

    public Keyword(String termo, int pontuacao) {
        this.termo = termo;
        this.pontuacao = pontuacao;
    }

    public String getTermo() {
        return termo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    @Override
    public String toString() {
        return "Keyword{termo='" + termo + "', pontuacao=" + pontuacao + "}";
    }
}
