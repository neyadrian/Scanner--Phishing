package utils;

import java.io.*;

public class SampleEmailGenerator {
    public String gerarEmailPhishing(String pasta) throws IOException {
        String conteudo =
                "Prezado cliente,\n\n" +
                        "URGENTE: Verificar sua conta é necessário para evitar o cancelamento.\n" +
                        "Confirme seus dados imediatamente para manter o acesso.\n" +
                        "Clique aqui para atualizar suas informações de login e senha.\n\n" +
                        "Seu banco identificou atividade suspeita. Acesso suspenso temporariamente.\n" +
                        "Por favor, confirme o número do cartão e as informações bancárias.\n\n" +
                        "Sua conta será encerrada em 24 horas se não houver verificação.\n" +
                        "Clique aqui agora e responda agora para evitar bloqueio.\n\n" +
                        "Promoção: Você foi selecionado para um prêmio exclusivo! Grátis!\n" +
                        "Acesse agora e faça seu cadastro para receber o desconto especial.\n\n" +
                        "Atenciosamente,\nEquipe de Segurança\n";

        return salvar(pasta, "email_phishing.txt", conteudo);
    }

    public String gerarEmailLegitimo(String pasta) throws IOException {
        String conteudo =
                "Olá!\n\n" +
                        "Conforme combinado, segue em anexo o relatório mensal.\n" +
                        "Qualquer dúvida, estou à disposição.\n\n" +
                        "Abraços,\nJoão\n";

        return salvar(pasta, "email_legitimo.txt", conteudo);
    }

    private String salvar(String pasta, String nomeArquivo, String conteudo) throws IOException {
        new File(pasta).mkdirs();
        String caminho = pasta + File.separator + nomeArquivo;

        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(caminho), "UTF-8"))) {
            pw.print(conteudo);
        }

        return caminho;
    }
}
