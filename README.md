# 🂡 APP Truco UTFPR

Aplicativo Android desenvolvido em **Kotlin** para marcação de pontos e gerenciamento de partidas de **Truco**, criado como trabalho final avaliativo.

---

## 📱 Telas e Funcionalidades

1. **Tela Inicial (MainActivity):**
   * Entrada dos nomes dos dois jogadores (**Jogador 01** e **Jogador 02**).
   * Validação em tempo real: o botão **"Começar"** só é habilitado após o preenchimento de ambos os nomes.
   * Validação de nomes iguais (impede que ambos os jogadores tenham o mesmo nome).

2. **Tela do Jogo (TelaInicialJogo):**
   * **Título Centralizado:** Exibe **"Contador de Truco"** no topo da tela.
   * **Placar Dinâmico:** Exibe o nome e a pontuação atual em destaque (com os pontos faltantes para a vitória *"Falta: X"* exibidos em uma linha abaixo).
   * **Botões de Pontuação (+ / -):** Permite incrementar ou decrementar pontos (`+1`, `+3`, `+6`, `+9`, `+12` e `-1`, `-3`, `-6`, `-9`, `-11`). A pontuação possui limite mínimo em `0` (não diminui abaixo de zero). Os botões numéricos têm fonte maior, negrito e largura ampliada.
   * **Condição de Vitória:** Ao atingir ou superar `12` pontos, um diálogo (*AlertDialog*) anuncia o vencedor, registra a partida e zera a pontuação para a próxima partida.
   * **Botões de Ação (Dispostos horizontalmente):**
     * **Hist. de Jogadas:** Abre a tela de histórico com as partidas registradas, vencedor, perdedor e placar de cada partida.
     * **Zerar Histórico:** Limpa as partidas registradas e reinicia a pontuação atual. Exibe a mensagem **"Pontuação dos jogadores zerada!"**.
     * **Inf. Nomes:** Retorna para a tela de cadastro de nomes.

3. **Tela de Histórico de Jogadas (TelaHistoricoJogadas):**
   * Exibe o título **"Contador de Truco"**, o subtítulo *"Histórico de Jogadas"* e o resumo de vitórias e derrotas de cada jogador.
   * Lista cada partida com os nomes dos jogadores e a pontuação final.
   * Quando os dois jogadores ainda não possuem partidas, exibe **"Nenhuma Partida Registrada no Historico"**.
   * Botão **"Voltar"** para retornar ao jogo.

---

## 🎨 Paleta de Cores e Temas (Light / Dark Mode)

O aplicativo conta com suporte automático a **Tema Claro e Tema Escuro (DayNight)**:
* **Tema Escuro:** Fundo preto (`#121212`), textos em branco (`#FFFFFF`) e acentos em vermelho (`#D32F2F`).
* **Tema Claro:** Fundo branco (`#FFFFFF`), textos principais em preto (`#000000`) e acentos em vermelho (`#D32F2F`).

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Kotlin
* **UI & Layouts:** `ConstraintLayout` e `ScrollView` (com suporte responsivo a rotação de tela / *Landscape*).
* **Gerenciamento de Views:** **View Binding** habilitado em todas as Activities.
* **Internacionalização (i18n):** Suporte completo para **Português (PT)** e **Inglês (EN)**.
* **Testes Unitários:** Testes JUnit para a lógica de pontuação, validação de nomes e repositório de histórico (`TrucoGameLogicTest`, `TrucoPontoLogicTest` e `RepositorioHistoricoTest`).

---

## 🧪 Testes Unitários

Para executar os testes unitários via terminal (Gradle):
```bash
./gradlew testDebugUnitTest
```
Ou clique com o botão direito na pasta de testes (`src/test`) no Android Studio e selecione **Run Tests**.

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/maike-rony/trabalhoandroid-truco.git
   ```
2. Abra o projeto no **Android Studio**.
3. Sincronize o projeto com o Gradle (`Sync Project with Gradle Files`).
4. Execute o app em um emulador ou dispositivo físico com Android 13+ (`minSdk 33`).
