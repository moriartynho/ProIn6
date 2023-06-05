# <p align="center">ProIn6</p> 
<p align="center">Esse projeto Recria um Protótipo de Projeto Integrador do curso de Engenharia da Computação da UNIVESP por Wilkson Júnior, que na ocasião foi feito através do MIT App Inventor. O programa nada mais é do que uma simples ferramenta de auxílio na gestão financeira do usuário.</p>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>



Técnicas e Tecnologias utilizadas: 
* Java
* MySQL
* Paradigma de Orientação a Objetos

Página Inicial do programa:

_____________________________________
![image](https://user-images.githubusercontent.com/67657259/227678066-de48b5fe-1fe4-472d-8858-73556ea042c4.png)

_____________________________________
O programa possui as seguintes funcionalidades:

1 - Receita: possibilita ao usuário criar uma lista de rendimentos, descrevendo a razão, o valor e o momento em que é registrada a receita:
____________
![image](https://user-images.githubusercontent.com/67657259/227678431-133f8055-5bf0-4113-9203-516a66af9d20.png)
_____________

2 - Despesa: semelhante ao item anterior, cria uma lista de despesas com os mesmos atributos:
___
![image](https://user-images.githubusercontent.com/67657259/227678461-8ed4576a-68f0-44bd-bd5c-4a776caccf5a.png)
___

3 - É possível que o usuário crie também uma lista de tarefas a serem realizadas com um título, data e valor a ser utilizado:
______
![image](https://user-images.githubusercontent.com/67657259/227679272-a8459821-22ab-4dbf-b7a4-ec76fe486be8.png)

______
Os dados das listas de receitas, despesas e tarefas são salvos em em um banco de dados após serem criados:

Transações (Receitas e Despesas) - armazenadas no banco. Os tipos são definidos por booleanos, sendo "true" = receita e "false" = despesa.
___
![image](https://user-images.githubusercontent.com/67657259/227682106-9ba6c047-eaba-4c8e-ad36-51844817300b.png)

_____________

Tarefas:

![image](https://user-images.githubusercontent.com/67657259/227680142-173301c1-cc26-4eb8-b3a8-3365b5602aad.png)
____________

Esses dados são armazenados já relacionados ao id do usuário que as criou. O usuário tem uma opção de "resetar" as informações da sua conta no Banco de Dados.

Conforme são adicionadas e removidas receitas e despesas das listas, os saldos são atualizados:

_____
![image](https://user-images.githubusercontent.com/67657259/227680954-04fc7b26-8e76-48a7-b804-20aa3ed0fca9.png)
_____

Há também um histórico de todas as transações registradas pelo usuário:

_____
![image](https://user-images.githubusercontent.com/67657259/227682030-ea4cc513-97a1-4dd0-b2a5-a274242f4819.png)

_____
