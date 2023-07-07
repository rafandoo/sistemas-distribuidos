<h1 align="center">Aplicação de Gerência de Fundos Imobiliários Utilizando Conceitos de Sistemas Distribuídos  🖥️</h1>

> Status do projeto: ✅ Finalizado


## Project description 📝

<p align="justify">
Este presente projeto foi desenvolvido para a matéria de Sistemas Distribuídos, do curso
de Bacharel em Ciência da Computação - IFC. Com o objetivo de desenvolver uma aplicação
que utilize conceitos de sistemas distribuídos.
</p>

## Tecnologias 👨‍💻

<p align="center">
  <img src="https://img.shields.io/badge/Python-14354C?style=for-the-badge&logo=python&logoColor=white" alt="python"/>
  <img src="https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white" alt="mongo"/>
  <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="docker"/>
</p>

## Configuração ⚙️

### Pré-requisitos

Para rodar este projeto é necessário ter instalado em sua máquina o Python 3.10 ou superior e o Docker.

### Instalação

Para rodar este projeto é necessário instalar suas dependências, por meio do comando abaixo no shell

```shell
  pip install -r requirements.txt
```

Após a instalação das dependências, podemos fazer a configuração do banco de dados, para isso, basta rodar o comando abaixo no shell

```shell
  docker-compose up -d
```

Acessamos o container do banco de dados

```shell
  docker exec -it mongo1 /bin/sh
  mongo --port 30001
```

Para efetivar a replica set, basta rodar o comando abaixo no shell

```js
  rs.initiate(
    {
        _id: "rs01",
        members: [
            { _id: 0, host : "mongo1:30001" , priority: 5},
            { _id: 1, host : "mongo2:30002" , priority: 1},
            { _id: 2, host : "mongo3:30003" , priority: 1}
        ]
    }
  )
```

## Como executar ▶️

Rode o arquivo `main.py` utilizando o comando abaixo para executar o projeto.

```shell
   python main.py
```

## Documents 📄

- [Relatório]()

## Libraries and frameworks 📚

- [Lumi](https://github.com/Lumi-Official/lumi)


## License 🔑

The [MIT License](https://github.com/rafandoo/Sistemas-Distribuidos/blob/91cc044873aa80506ad964c3f824ed00b0ac2caf/LICENSE) (MIT)

Copyright :copyright: 2023 - Rafael Camargo

