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
[
  {
    "id": 5,
    "name": "Toalha de mão",
    "category": "Toalhas",
    "size": "Toalhas de mão",
    "priceFrom": 49.90,
    "priceTo": 29.90,
    "images": [
      "https://thumb1.shutterstock.com/thumb_large/1528667/144521369/stock-photo-basket-of-pure-white-towels-on-wooden-table-in-japanese-restaurant-144521369.jpg",
      "https://thumb1.shutterstock.com/thumb_large/1528667/144521369/stock-photo-basket-of-pure-white-towels-on-wooden-table-in-japanese-restaurant-144521369.jpg",
      "https://thumb9.shutterstock.com/thumb_large/3819122/1042317892/stock-photo-the-blue-gray-towel-roll-in-hand-on-white-background-isolation-1042317892.jpg",
      "https://thumb1.shutterstock.com/thumb_large/1528667/144521369/stock-photo-basket-of-pure-white-towels-on-wooden-table-in-japanese-restaurant-144521369.jpg"
    ],
    "searchBy": "ALL"
  },
  {
    "id": 6,
    "name": "Toalha de mesa",
    "category": "Toalhas",
    "size": "Mesa",
    "priceFrom": 29.90,
    "priceTo": 19.90,
    "images": [
      "https://thumb10.shutterstock.com/thumb_large/2061695/355891343/stock-photo-table-cloth-kitchen-red-color-isolated-on-white-355891343.jpg",
      "https://thumb9.shutterstock.com/thumb_large/1427423/537583432/stock-photo-kitchen-background-with-table-cloth-537583432.jpg",
      "https://thumb10.shutterstock.com/thumb_large/2061695/355891343/stock-photo-table-cloth-kitchen-red-color-isolated-on-white-355891343.jpg",
      "https://thumb9.shutterstock.com/thumb_large/1427423/537583432/stock-photo-kitchen-background-with-table-cloth-537583432.jpg"
    ],
    "searchBy": "ALL"
  },
  {
    "id": 7,
    "name": "Travesseiro",
    "category": "Travesseiros",
    "size": "Adulto",
    "priceFrom": 29.90,
    "priceTo": 19.90,
    "images": [
      "https://thumb1.shutterstock.com/thumb_large/3040346/760987840/stock-photo-white-linen-pillow-cushion-mockup-on-plaid-inrerior-photo-760987840.jpg",
      "https://thumb1.shutterstock.com/thumb_large/137002/1054812590/stock-photo-different-pillows-on-chair-in-room-1054812590.jpg",
      "https://thumb1.shutterstock.com/thumb_large/3040346/760987840/stock-photo-white-linen-pillow-cushion-mockup-on-plaid-inrerior-photo-760987840.jpg",
      "https://thumb1.shutterstock.com/thumb_large/137002/1054812590/stock-photo-different-pillows-on-chair-in-room-1054812590.jpg"
    ],
    "searchBy": "ALL"
  },
  {
    "id": 1,
    "name": "teste 1",
    "category": "categ_01",
    "size": "size_01",
    "priceFrom": 299.90,
    "priceTo": 199.90,
    "images": [
      "https://thumb10.shutterstock.com/thumb_large/2973451/587783213/stock-photo-sun-lights-to-the-clean-white-towels-on-the-hotel-bed-feels-cozy-comfort-and-relax-for-cozy-587783213.jpg",
      "https://thumb10.shutterstock.com/thumb_large/2429366/590662787/stock-photo-white-towel-on-bed-decoration-in-bedroom-interior-vintage-light-filter-590662787.jpg",
      "https://thumb10.shutterstock.com/thumb_large/2429366/590662787/stock-photo-white-towel-on-bed-decoration-in-bedroom-interior-vintage-light-filter-590662787.jpg",
      "https://thumb10.shutterstock.com/thumb_large/2973451/587783213/stock-photo-sun-lights-to-the-clean-white-towels-on-the-hotel-bed-feels-cozy-comfort-and-relax-for-cozy-587783213.jpg"
    ],
    "searchBy": "ALL"
  },
  {
    "id": 4,
    "name": "Lençol Adulto",
    "category": "Lençol adulto",
    "size": "King size",
    "priceFrom": 59.90,
    "priceTo": 39.90,
    "images": [
      "https://thumb1.shutterstock.com/thumb_large/277009/786226663/stock-photo-simple-gray-and-white-bedroom-interior-with-blanket-and-pillows-on-king-size-bed-bright-window-786226663.jpg",
      "https://thumb1.shutterstock.com/thumb_large/277009/782654206/stock-photo-grey-and-yellow-room-with-king-size-bed-poster-and-lamp-standing-on-bedside-table-782654206.jpg",
      "https://thumb1.shutterstock.com/thumb_large/277009/786226663/stock-photo-simple-gray-and-white-bedroom-interior-with-blanket-and-pillows-on-king-size-bed-bright-window-786226663.jpg",
      "https://thumb1.shutterstock.com/thumb_large/277009/782654206/stock-photo-grey-and-yellow-room-with-king-size-bed-poster-and-lamp-standing-on-bedside-table-782654206.jpg"
    ],
    "searchBy": "ALL"
  }
]
 ```
 - Outros dados importantes para que sejam realizados as navegações nas páginas são as informações retornadas no `HEADER` da resposta: 
 > X-Paging-Total-Entries

 > X-Paging-Entries-Per-Page

 > X-Paging-Current-Page
 
 > X-Paging-Total-Pages

 - A applicação está gerando LOGs, e os mesmo poderão ser encotrados no `/data/logs/product/app.log`


---
[Java 10]: <https://docs.oracle.com/javase/10/>
[Postgres]: <https://www.enterprisedb.com/>
[Spring Boot 2]: <https://spring.io/projects/spring-boot>
[Maven]: <https://maven.apache.org/>

[db]: <https://github.com/attnk/test_products_api/tree/master/db>
[ProductApplication.java]: <https://github.com/attnk/test_products_api/blob/master/product/src/main/java/com/br/productapi/product/ProductApplication.java>
[jar]: <https://github.com/attnk/test_products_api/tree/master/jar>