#Author: Samuca_rds@yahoo.com.br


Feature: Marca, Modelo e versao


  @tag1
  Scenario: Validar marca, modelo e versao
  Given que o usuario acesse o "https://www.webmotors.com.br/"
  When realizar a busca por marca "Honda"
  And o modelo "City"
  And a versao
  Then sera exibido retorno da busca

 