# 🛡️ Scanner de Phishing — Exercício 15.10

Analisa arquivos de texto em busca de palavras e frases comumente encontradas em e-mails de phishing, atribuindo uma pontuação de risco a cada ocorrência.

---

## 📁 Estrutura do projeto

\```
PhishingScanner/
├── src/
│   └── phishing/
│       ├── Main.java                          ← ponto de entrada da aplicação
│       ├── model/
│       │   ├── Keyword.java                   ← palavra-chave e sua pontuação
│       │   ├── KeywordResult.java             ← ocorrências e pontos de uma palavra
│       │   └── AnalysisReport.java            ← relatório completo + nível de risco
│       ├── analyzer/
│       │   ├── KeywordRepository.java         ← repositório com as 30 palavras
│       │   └── TextAnalyzer.java              ← lógica de contagem e análise
│       ├── util/
│       │   ├── FileReader.java                ← leitura de arquivos de texto
│       │   └── SampleEmailGenerator.java      ← gerador de e-mails de exemplo
│       └── ui/
│           └── ConsoleUI.java                 ← saída formatada no console
├── emails/                                    ← criada automaticamente ao executar
└── README.md
\```

---

## ▶️ Como compilar e executar

### 1. Compilar

\```bash
# Execute dentro da pasta PhishingScanner/
javac -encoding UTF-8 -d out $(find src -name "*.java")
\```

### 2. Executar

\```bash
java -cp out phishing.Main
\```

### 3. Analisar um arquivo próprio

Ao iniciar, digite o caminho do arquivo que deseja verificar:

\```
Digite o caminho do arquivo de texto a ser analisado: emails/meu_email.txt
\```

### 4. Usar os e-mails de exemplo

Pressione **Enter** sem digitar nada. O programa criará dois e-mails na pasta `emails/` e perguntará qual analisar:

\```
[1] emails/email_phishing.txt   (alto risco)
[2] emails/email_legitimo.txt   (legítimo)
\```

---

## 🔑 Tabela de pontuação

| Pontos | Nível                  | Exemplos de palavras/frases                               |
|:------:|------------------------|-----------------------------------------------------------|
| **3**  | Altamente provável     | `urgente`, `senha`, `acesso suspenso`, `número do cartão` |
| **2**  | Moderadamente provável | `clique aqui`, `prêmio`, `grátis`, `você foi selecionado` |
| **1**  | Pouco provável         | `banco`, `login`, `conta`, `acesso`                       |

> Cada ocorrência da palavra no texto soma seus pontos ao total.

---

## 🚦 Níveis de risco

| Score    | Nível                     | Descrição                                             |
|:--------:|---------------------------|-------------------------------------------------------|
| **0**    | ✅ Provavelmente legítimo  | Nenhuma palavra suspeita encontrada.                  |
| **1–5**  | 🟡 Baixo risco             | Poucas palavras suspeitas. Pode ser legítimo.         |
| **6–15** | 🟠 Risco moderado          | Atenção! Diversas palavras suspeitas detectadas.      |
| **16+**  | 🔴 Alto risco de phishing  | CUIDADO! Forte padrão de phishing identificado.       |

---

## 🧩 Arquitetura

O projeto segue uma separação clara de responsabilidades em pacotes:

- **`model/`** — estruturas de dados puras (sem lógica de negócio)
- **`analyzer/`** — regras de negócio: repositório de palavras e algoritmo de análise
- **`util/`** — utilitários de I/O reutilizáveis
- **`ui/`** — toda a interação com o console isolada em um único lugar

---

## 📋 Exemplo de saída

\```
ANALISANDO: emails/email_phishing.txt

PALAVRA / FRASE                     OCORRÊNCIAS     PONTOS
----------------------------------------------------------
verificar sua conta                           1          3
urgente                                       1          3
senha                                         1          3
clique aqui                                   2          4
prêmio                                        1          2
...
----------------------------------------------------------
TOTAL                                        26         51

RESULTADO: ALTO RISCO DE PHISHING (score = 51)
CUIDADO! Este e-mail apresenta forte padrão de phishing.

----------------------------------------------------------
## 👤 Autor

**Ney Adrian**

---

*Projeto desenvolvido para fins educacionais com foco em conceitos fundamentais de POO.*

\```