# PRODUCT API
---

## Tecnologias
 > [Java 10]
 > [Postgres] (versão 10)
 > [Spring Boot 2]
 > [Maven]

## Como executar
Primeiramente antes de executar a aplicação é necessário que seja criada a base (tabelas, inserido alguns dados e etc.) de dados no [Postgres] **local**, para isso basta subir localmente uma instancia do banco e 
executar os scrips presente na pasta [db].

**OBS:** É necessário que sejam criado o `usuário: product_app` com os mesmos dados informados no arquivo citado, pois essa é a conta utilziada pela aplicação para conectar-se com o banco de dados. 
Caso queira trocar o mesmo, basta ir no arquivo de configuração da aplicação (`application.yml`) e trocar os dados para um de sua preferência (contanto que o mesmo tenha acesso de leitura nas tabelas `product` e `product_images`).

Após a criação e configuração do banco, caso queira executar a aplicação via IDE, basta executar a `main` do projeto presente no arquivo `[ProductApplication.java]`, que a aplicação irá subir na porta `8080` de sua máquina.

Caso queira somente executar a aplicação rodando o arquivo `JAR` (localizado na pasta [jar]), basta rodar o seguinte comando:
```
 <LOCAL DE INSTALAÇÃO DO JAVA>/bin/java -jar -D64 -server -Xmx2959m -Xms2959m -XX:+AggressiveHeap -XX:+DisableExplicitGC -XX:ThreadStackSize=256 -Duser.timezone=America/Sao_Paulo <LOCAL ONDE SE ECONTRA O ARQUIVO JAR>/product.jar
```

**OBS:** 
Caso esteja utilizando uma máquina com `Windows`, para executar o `Java`, basta utilziar o arquivo `java.exe` localizado dentro da pasta `bin`.

## Serviço
O serviço dispónível para consulta dos dados e busca utilzando alguma palavra como critério de filtragem é:

### GET
 - `http://localhost:8080/products?text=<TEXTO BUSCADO>&page=<NÚMERO DA PÁGINA>&size=<QUANTIDADES DE ELEMENTOS RETORNADOS POR PÁGINA>`
 - Os parâmetros `text`, `page` e `size` não são obrigatórios, sendo que caso não sejam informados os critérios utilizados serão: `text=ALL`(buscando por todos os dados existentes na base), `page=0` e `size=5`
 - O retorno dos dados segue o seguinte formato:
 ```json

 ```
 - Outros dados importantes para que sejam realizados as navegações nas páginas são as informações retornadas no `HEADER` da resposta: 
 -- 
 - A applicação está gerando LOGs, e os mesmo poderão ser encotrados no `/data/logs/product/app.log`


---
[Java 10]: <https://docs.oracle.com/javase/10/>
[Postgres]: <https://www.enterprisedb.com/>
[Spring Boot 2]: <https://spring.io/projects/spring-boot>
[Maven]: <https://maven.apache.org/>

[db]: <https://github.com/attnk/test_products_api/tree/master/db>
[ProductApplication.java]: <https://github.com/attnk/test_products_api/blob/master/product/src/main/java/com/br/productapi/product/ProductApplication.java>
[jar]: <https://github.com/attnk/test_products_api/tree/master/jar>