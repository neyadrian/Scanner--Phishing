package utils;

import java.io.*;


public class FileReader {

    public String ler(String caminho) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminho), "UTF-8"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                sb.append(linha).append(" ");
            }
        }

        return sb.toString();
    }

    public boolean existe(String caminho) {
        File f = new File(caminho);
        return f.exists() && f.isFile();
    }
}
