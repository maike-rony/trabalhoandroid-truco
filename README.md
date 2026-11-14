# 🂡 APP Truco UTFPR

Aplicativo Android desenvolvido em **Kotlin** para marcação de pontos e gerenciamento de partidas de **Truco**, criado como trabalho final avaliativo.

---

## 📱 Telas e Funcionalidades

1. **Tela Inicial (MainActivity):**
   * Entrada dos nomes dos dois jogadores (**Jogador 01** e **Jogador 02**).
   * Validação em tempo real: o botão **"Começar"** só é habilitado após preenchimento de ambos os nomes.
   * Validação de nomes iguais (impede que ambos os jogadores tenham o mesmo nome).
   * Limpeza automática dos campos ao retornar da tela de jogo.

2. **Tela do Jogo (TelaInicialJogo):**
   * **Placar Dinâmico:** Exibe o nome de cada jogador, sua pontuação atual (com zero formatado como `0`) e os pontos faltantes para alcançar a vitória (`"Falta: X"`).
   * **Botões de Pontuação (+ / -):** Permite incrementar ou decrementar pontos (`+1`, `+3`, `+6`, `+9`, `+12` e `-1`, `-3`, `-6`, `-9`, `-12`). A pontuação possui limite mínimo em `0`.
   * **Condição de Vitória:** Ao atingir ou superar `12` pontos, um diálogo (*AlertDialog*) anuncia o vencedor e zera a pontuação para a próxima partida, incrementando o histórico de vitórias do respectivo jogador.
   * **Botões de Ação:**
     * **Hist. de Jogadas:** Abre a tela de histórico de partidas ganhas.
     * **Zerar Histórico:** Reinicia a pontuação atual.
     * **Inf. Nomes:** Retorna para a tela de cadastro de nomes.

3. **Tela de Histórico de Jogadas (TelaHistoricoJogadas):**
   * Exibe o título centralizado **" Jogo Truco "** e o placar acumulado de partidas ganhas por cada jogador desde o início da sessão.
   * Botão **"Voltar"** para retornar rapidamente ao jogo.

---

## 🎨 Paleta de Cores e Identidade Visual

O aplicativo possui um tema moderno e escuro inspirado no universo de jogos de cartas:
* **Preto / Fundo Escuro** (`#121212`)
* **Vermelho Truco** (`#D32F2F` e `#FF5252`)
* **Cinza Superfície** (`#1E1E1E` e `#E0E0E0`)

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Kotlin
* **UI:** Views tradicionais com `ConstraintLayout` e `ScrollView` (adaptado para rotação de tela / *Landscape*).
* **Gerenciamento de Views:** **View Binding** habilitado em todas as Activities.
* **Internacionalização (i18n):** Suporte completo para **Português (PT)** e **Inglês (EN)**.
* **Testes Unitários:** Testes robustos desenvolvidos com JUnit (`TrucoGameLogicTest` e `TrucoPontoLogicTest`).

---

## 🧪 Testes Unitários

Para executar os testes unitários via terminal (Gradle):
```bash
./gradlew testDebugUnitTest
```
Ou clique com o botão direito na pasta de testes (`src/test`) no Android Studio e selecione **Run Tests with Coverage**.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/maike-rony/trabalhoandroid-truco.git
   ```
2. Abra o projeto no **Android Studio**.
3. Sincronize o projeto com o Gradle (`Sync Project with Gradle Files`).
4. Execute o app em um emulador ou dispositivo físico com Android 13+ (`minSdk 33`).
