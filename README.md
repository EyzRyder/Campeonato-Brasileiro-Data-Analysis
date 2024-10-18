# Campeonato Brasileiro Data Analysis
Este projeto em Java realiza a análise de dados de jogos do Campeonato Brasileiro, utilizando arquivos CSV que contêm informações sobre partidas, gols, cartões e estatísticas de jogadores entre 2003 e 2022.

## Objetivo
O objetivo deste projeto é extrair e apresentar informações relevantes sobre o Campeonato Brasileiro, incluindo:

- [ ] O time que mais venceu jogos no ano de 2008;
- [ ] O estado com o menor número de jogos entre 2003 e 2022;
- [ ] O jogador que mais fez gols;
- [ ] O jogador que mais fez gols de pênaltis;
- [ ] O jogador que mais fez gols contra;
- [x] O jogador que mais recebeu cartões amarelos;
- [x] O jogador que mais recebeu cartões vermelhos;
- [ ] O placar da partida com o maior número de gols;


## Dados
Os dados necessários para a análise podem ser encontrados nos seguintes arquivos CSV:
[Fonte dos Dados](https://github.com/vconceicao/ada_brasileirao_dataset/tree/master)

- campeonato-brasileiro-gols.csv
- campeonato-brasileiro-cartoes.csv
- campeonato-brasileiro-estatisticas-full.csv
- campeonato-brasileiro-full.csv

## Como Usar
Clone este repositório:

```bash
git clone https://github.com/EyzRyder/Campeonato-Brasileiro-Data-Analysis.git
```

Navegue até o diretório do projeto:

```bash
cd Campeonato-Brasileiro-Data-Analysis
```

Compile o projeto:

```bash
javac src/*.java
```

Execute a análise:

```bash
java src/Campeonato-Brasileiro-Data-Analysis
```

Dependências
- Java 11 ou superior
