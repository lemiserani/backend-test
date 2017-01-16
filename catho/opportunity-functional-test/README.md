# README #

Teste Funcional -  Catho 

### Pré-requisitos ###

 Ruby 2.2.0
 cucumber

### Instação ###

 Você pode usar rvm para instalar várias versões do ruby em sua maquina
 (https://rvm.io/rvm/install)
 Depois você pode install o ruby  2.2.0
 rvm install 2.2.0

 Ou você pode instalar o ruby sem rvm.
 https://www.ruby-lang.org/pt/documentation/installation/

  $ cp /{diretorio_aplicacao_opportunity-funcional-test}

* Instalar gem bundler

   $ gem install bundler

* Instalar projeto
  $ bundle ou bundle install
     
### Executar testes ###
  
  A Api opportunity e o ElasticSearch devem estar rodando. 
  Os dados do ElasticSearch deve estar populado. 
  
    $ rake local_opportunity 
    or
    $  cucumber -p local_opportunity

### Sobre ###
Leandro Junqueira Garcia Miserani
