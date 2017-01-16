# README #

 Teste Backend - Catho 

### Pré-requisitos ###

* Java 8
* Maven 3.x.x
* ElasticSearch 5.1

### Tecnologias utilizadas ###

* Spring Boot
* Swagger
* Maven
* GIT

### Como foi desenvolvido ###
De acordo com o sistema que foi solicitado, achei interessante utilizar o ElasticSearch para armazenar os dados. As pesquisas
são simples e rápidas. Trazendo um resultado rápido (performance), onde as buscas retornam em poucos milesengundos.

### Aplicação possui 2 rotas ###
Uma rota(/job) para popular os dados de acordo com o Json enviado.
Uma rota(/job/search) onde executa as buscas de acordo com os parâmetros: 
   q: campo de busca livre. Exemplo: 2000
   page: página atual da paginação. Exemplo: 0
   limit: limite de resultados. Exemplo: 20
   orderby: resultado ordenado por esse campo. Exemplo: salario
   sorted: asc ou desc.  Exemplo: desc
   fields: campos onde o "q" será aplicado a busca. Separados por ",".  Exemplo: salario,title

### Swagger ###
Foi configurado o Swagger http://localhost:8080/ para ser testado facilmente e ainda serve de documentação e contrato.

### Testes ###
Os testes da aplicação foram em apenas algimas classes. Não utilizei mock para os testes.
Achei mais interessante focar mais nos testes funcionais no projeto /opportunity-functional-test

### ElasticSearch ###
  Primeiro é necessário subir o ElasticSearch.
  
  Realizar o Download do ElasticSearch: https://www.elastic.co/downloads/past-releases/elasticsearch-5-1-1
  Criar o diretório do log em: /var/log/spring-boot-elasticsearch-swagger/
  No diretório do ElasticSearch executar: ./bin/elasticsearch
  Testar: http://localhost:9200/

### Instalar e executar ###  
   Criar o diretório dos arquivos de configuração: 
   $mkdir /tmp/catho/
   
   Copiar os arquivos para o diretório criado (/tmp/catho/)
   $ cd /tmp/catho
   $ cp /{diretorio_aplicacao_opportunity}/src/main/resources/index/* .
   $ cp /{diretorio_aplicacao_opportunity}/src/main/resources/files/* .
   
   $ cp /{diretorio_aplicacao_opportunity}
   $ mvn clean package install && java -jar target/opportunity-1.0-SNAPSHOT.jar

### Acessar projeto ###  

   http://localhost:8080/
   Executar a rota "/job" para popular o elasticsearch. Alguns segundos para ser populada.
   
   Depois desse passo, você pode navegar no próprio Elasticsearch e verificar todos os dados inseridos
   http://localhost:9200/jobs/jobs/_search
   
   Pode executar as buscas na API.
   Executar a rota "/job/search" e alterar os parâmetros necessários.
	
### Sobre ###
Leandro Junqueira Garcia Miserani
   
   
