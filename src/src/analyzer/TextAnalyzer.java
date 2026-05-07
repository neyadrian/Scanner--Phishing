package analyzer;

import model.AnalysisReport;
import model.Keyword;
import model.KeywordResult;

import java.util.ArrayList;
import java.util.List;


public class TextAnalyzer {

    private final KeywordRepository repository;

    public TextAnalyzer() {
        this.repository = new KeywordRepository();
    }


    public AnalysisReport analisar(String arquivo, String conteudo) {
        String textoMinusculo = conteudo.toLowerCase();

        List<KeywordResult> resultados = new ArrayList<>();

        for (Keyword keyword : repository.getAll()) {
            int ocorrencias = contarOcorrencias(textoMinusculo, keyword.getTermo().toLowerCase());
            if (ocorrencias > 0) {
                resultados.add(new KeywordResult(keyword, ocorrencias));
            }
        }

        return new AnalysisReport(arquivo, resultados);
    }

    private int contarOcorrencias(String texto, String palavra) {
        int count = 0;
        int index = 0;
        while ((index = texto.indexOf(palavra, index)) != -1) {
            count++;
            index += palavra.length();
        }
        return count;
    }
}

