markdown
````
# Connectivity Forecast API

API REST desenvolvida em **Java e Spring Boot** como reimplementação educacional de uma API de referência para análise de previsões de conectividade. O projeto faz parte da disciplina **APS II** e tem como objetivo demonstrar a organização de uma aplicação backend, a exposição de recursos REST e a documentação de serviços com OpenAPI.

A aplicação disponibiliza um catálogo de modelos, localizações, previsões de conectividade e atividades, utilizando dados fictícios e previsões previamente definidas.

## Objetivos do projeto

- Reimplementar a estrutura e o comportamento esperado da API de referência.
- Aplicar conceitos de desenvolvimento de APIs REST com Java e Spring Boot.
- Organizar o código em camadas, separando responsabilidades.
- Disponibilizar documentação interativa dos endpoints.
- Fornecer uma base para estudos e experimentação com dados de conectividade.

## Tecnologias utilizadas

- **Java 17** — linguagem de programação.
- **Spring Boot** — framework para desenvolvimento da aplicação.
- **Maven 3.9+** — gerenciamento de dependências e execução do projeto.
- **OpenAPI / Swagger UI** — documentação e exploração dos endpoints.
- **JUnit e ferramentas de teste do projeto** — validação do comportamento da aplicação.

## Requisitos

Antes de executar o projeto, verifique se os seguintes componentes estão instalados:

- Java 17.
- Maven 3.9 ou superior.

Para conferir as versões instaladas, execute:

```bash
java -version
mvn -version
````

## Como executar

Clone o repositório e acesse a pasta do projeto:

bash
```
git clone <URL_DO_REPOSITORIO>
cd <PASTA_DO_PROJETO>
```

### 1. Executar os testes

Para compilar o projeto e executar os testes automatizados:

bash
```
mvn test
```

### 2. Iniciar a aplicação

Execute a aplicação com o Spring Boot:

bash
```
mvn spring-boot:run
```

Após a inicialização, a API estará disponível localmente em `http://localhost:8080`, salvo configuração diferente.

### 3. Acessar a documentação

Com a aplicação em execução, utilize os seguintes endereços:

| Recurso | URL |
| --- | --- |
| Swagger UI | [http://localhost:8080/swagger-ui.html](<http://localhost:8080/swagger-ui.html>) |
| Especificação OpenAPI | [http://localhost:8080/v3/api-docs](<http://localhost:8080/v3/api-docs>) |

O Swagger UI permite visualizar os endpoints documentados, consultar parâmetros e executar requisições diretamente pela interface.

## Escopo funcional

A API disponibiliza recursos relacionados à previsão e à análise experimental de conectividade.

| Recurso | Descrição |
| --- | --- |
| Health | Verificação da disponibilidade da aplicação. |
| Modelos | Catálogo de modelos de previsão, incluindo modelos ativos e inativos. |
| Localizações | Informações sobre as localizações utilizadas nos dados de referência. |
| Previsões | Consulta às previsões de conectividade previamente definidas. |
| Atividades | Recurso destinado às atividades relacionadas ao domínio da aplicação. |

Os recursos são disponibilizados sob o prefixo de versionamento `/api/v1`.

### Dados de referência

A aplicação utiliza uma fixture estática, estruturada para reproduzir o conjunto de dados da API de referência.

| Elemento | Quantidade |
| --- | --- |
| Modelos ativos | 4 |
| Modelos inativos | 1 |
| Probes | 10 |
| Instantes de previsão | 24 |
| Total de previsões | 960 |

As 960 previsões correspondem à combinação de 4 modelos ativos, 10 probes e 24 instantes:

`4 × 10 × 24 = 960 previsões`

Os dados são fictícios e utilizados exclusivamente para fins educacionais.

## Arquitetura do projeto

O código é organizado em camadas para separar as responsabilidades e facilitar a manutenção e a evolução da aplicação.

- Controllers: recebem as requisições HTTP, encaminham as operações e definem as respostas da API.
- Services: concentram as regras de negócio e o processamento das operações.
- Repositories: abstraem o acesso e a consulta aos dados da aplicação.
- Domain Models: representam as entidades e os conceitos do domínio.
- DTOs (Data Transfer Objects): definem as estruturas utilizadas na entrada e na saída de dados da API.
- Configuration: reúne as configurações necessárias para o funcionamento da aplicação e de sua documentação.

Essa organização favorece a separação de responsabilidades, a testabilidade e a compreensão do código.

## Características e limitações

Esta implementação foi projetada para execução local e aprendizado.

- Utiliza dados mockados e previamente definidos.
- Não consulta a infraestrutura do RIPE Atlas.
- Não treina, carrega ou executa modelos reais de aprendizado de máquina.
- Não utiliza banco de dados.
- Não exige deploy ou infraestrutura externa para sua execução básica.
- Implementa classificações e recomendações por meio de regras experimentais.

> Importante: as classificações e recomendações disponibilizadas pela aplicação não representam padrões científicos validados e não devem ser interpretadas como resultados de modelos reais de previsão.

## Documentação da API

O README e a especificação OpenAPI são os pontos de partida para compreender os recursos disponibilizados.

Como parte da evolução do projeto, recomenda-se documentar cada endpoint com:

- Método HTTP e caminho do recurso.
- Descrição de sua finalidade.
- Parâmetros de caminho, query e corpo da requisição.
- Regras de validação e valores permitidos.
- Exemplos de requisições e respostas.
- Códigos HTTP de sucesso e de erro.
- Estrutura das mensagens de erro.
- Origem dos campos retornados e suas regras de preenchimento.

Essas informações devem refletir o comportamento efetivamente implementado, evitando divergências entre o código e a documentação.

## Testes

Os testes automatizados podem ser executados com:

bash
```
mvn test
```

Recomenda-se cobrir, conforme os recursos implementados:

- Disponibilidade do endpoint de health.
- Consulta ao catálogo de modelos.
- Tratamento de modelos ativos e inativos.
- Consulta às localizações.
- Recuperação e validação das previsões.
- Comportamento dos endpoints de atividades.
- Tratamento de parâmetros inválidos e recursos inexistentes.

## Licença e atribuição

Este projeto preserva a referência à licença MIT da API de origem. Consulte o arquivo de licença distribuído com o projeto para verificar os termos aplicáveis à implementação e à reutilização do código.

A atribuição à API de referência deve ser mantida conforme as condições da licença original.

## Contexto acadêmico

Projeto desenvolvido para fins educacionais no contexto da disciplina APS II, com foco na implementação de APIs REST, organização em camadas, testes e documentação de serviços backend.

Os dados, as previsões e as regras experimentais não se destinam à utilização como serviço de monitoramento ou previsão de conectividade em ambientes de produção.

```

```
