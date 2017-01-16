@local_opportunity
Feature: Opportunity API

Scenario: Positivo: Search Jobs - Check the values of each job
When Opportunity API execute Get in ElasticSearch with q=Joinville & fields=cidade & page=0 & limit=10 & orderby=salario & sorted=asc
Then Opportunity verify fields of each Job

Scenario: Negative: Search Jobs - Check the values of each job
When Opportunity API execute Get in ElasticSearch with q=Joinville & fields=cidade & page=1000 & limit=10 & orderby=salario & sorted=asc
Then Opportunity verify result without Job

Scenario: Positivo: Search Jobs - Check the values of each job
When Opportunity API execute Get in ElasticSearch with q=2000 & fields=salario & page=0 & limit=10 & orderby=salario & sorted=asc
Then Opportunity verify field salary with value 2000

Scenario: Negativo: Search Jobs - Check the values of each job
When Opportunity API execute Get in ElasticSearch with q=100000 & fields=salario & page=0 & limit=10 & orderby=salario & sorted=asc
Then Opportunity verify field salary with value 100000

Scenario: Positivo: Search Jobs - Check the values of each job
When Opportunity API execute Get in ElasticSearch with q=Auxiliar & fields=title & page=0 & limit=100 & orderby=salario & sorted=asc
Then Opportunity verify field limit with value 100

Scenario: Positivo: Search Jobs - Check the values of each hits
When Opportunity API execute Get in ElasticSearch with q=Auxiliar & fields=title & page=0 & limit=10 & orderby=salario & sorted=asc
Then Opportunity verify field hits