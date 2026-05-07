package analyzer;

import model.Keyword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class KeywordRepository {

    private static final List<Keyword> KEYWORDS = new ArrayList<>();

    static {
        KEYWORDS.add(new Keyword("verificar sua conta",     3));
        KEYWORDS.add(new Keyword("confirme seus dados",     3));
        KEYWORDS.add(new Keyword("clique aqui imediatamente", 3));
        KEYWORDS.add(new Keyword("sua conta será encerrada", 3));
        KEYWORDS.add(new Keyword("atualize suas informações", 3));
        KEYWORDS.add(new Keyword("acesso suspenso",         3));
        KEYWORDS.add(new Keyword("urgente",                 3));
        KEYWORDS.add(new Keyword("informações bancárias",   3));
        KEYWORDS.add(new Keyword("número do cartão",        3));
        KEYWORDS.add(new Keyword("senha",                   3));

        KEYWORDS.add(new Keyword("clique aqui",             2));
        KEYWORDS.add(new Keyword("acesse agora",            2));
        KEYWORDS.add(new Keyword("oferta exclusiva",        2));
        KEYWORDS.add(new Keyword("parabéns",                2));
        KEYWORDS.add(new Keyword("você foi selecionado",    2));
        KEYWORDS.add(new Keyword("prêmio",                  2));
        KEYWORDS.add(new Keyword("grátis",                  2));
        KEYWORDS.add(new Keyword("promoção",                2));
        KEYWORDS.add(new Keyword("desconto especial",       2));
        KEYWORDS.add(new Keyword("responda agora",          2));

        KEYWORDS.add(new Keyword("banco",                   1));
        KEYWORDS.add(new Keyword("paypal",                  1));
        KEYWORDS.add(new Keyword("atualização",             1));
        KEYWORDS.add(new Keyword("segurança",               1));
        KEYWORDS.add(new Keyword("verificação",             1));
        KEYWORDS.add(new Keyword("confirmação",             1));
        KEYWORDS.add(new Keyword("conta",                   1));
        KEYWORDS.add(new Keyword("login",                   1));
        KEYWORDS.add(new Keyword("acesso",                  1));
        KEYWORDS.add(new Keyword("cadastro",                1));
    }

    public List<Keyword> getAll() {
        return Collections.unmodifiableList(KEYWORDS);
    }
}
