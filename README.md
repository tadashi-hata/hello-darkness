# Hello Darkness Application
Esta aplicação possui APIs de um sistema de streaming de música aleatório.

As funcionalidades presentes nesta aplicação são:
- pesquisar músicas
- Pesquisar cantores
- Criar playlists

## Objetivo
Esta aplicação possui fins didáticos para apresentar exemplos de testes unitários e integrados utilizando Mockito e JUnit 5.

## Prerequisitos de sistema
- Maven: 3.6.1
- Java 12
- Lombok 1.18.8. 

**Importante:** É necessário incluir o plugin do Lombok na sua IDE. Para tal, veja referência: [Setup Lombok](https://projectlombok.org/setup/eclipse)
No caso do Intellij, caso os passos descritos não funcionem, você pode baixar o plugin diretamente em [Jetbrains Lombok](https://plugins.jetbrains.com/plugin/6317-lombok) e instalar manualmente na sua IDE. 

## Build e execução da aplicação
Para realizar o build basta executar: 
       
      mvn clean install
  
Gerar pacote: 

      mvn package

Subir aplicação: 

      java -jar ./target/hello-darkness-0.0.1-SNAPSHOT.jar

## Swagger 2.0
A documentação das APIs está presente em resources/hello-darkness.yaml
Para facilitar a visualização, pode-se utilizar a página [Swagger Editor](https://editor.swagger.io/) basta importar o arquivo.

### Referências:
- [JUnit 5](https://junit.org/junit5/docs/current/user-guide/#writing-tests)
- [Mockito](https://static.javadoc.io/org.mockito/mockito-core/3.0.0/org/mockito/Mockito.html)

