# Como rodar o projeto?

Pre-requisitos pra rodar:
- Java version 21

### 1 - Clone esse repositorio
https://github.com/melmonfre/simplepdv-back/
![image](https://github.com/DgSantos017/restaurant/assets/62971277/2fd0ab71-e709-475b-9708-56d53e2ac247)


### 2 - Abra ele com seu editor de código, recomendo o InteliJ, 

### 3 - por fim, se voce abriu com o InteliJ, entre na classe ```RestaurantApplication``` e pressione o botao de startar e deve ter esse resultado abaixo 
![image](https://github.com/DgSantos017/restaurant/assets/62971277/f7e1f260-0fb8-45ce-9a8f-2e5037cf2ac2)


# Arquitetura da API


![image](https://github.com/DgSantos017/restaurant/assets/62971277/f6c178d8-61fc-41d5-a4ad-ea0594b91b72)

### Padrão de Commit com Emoji
### Usar emojis nos commits pode tornar mais fácil identificar o propósito ou intenção de cada commit. Aqui estão alguns exemplos de como você pode fazer isso:

✨ :sparkles: para uma nova funcionalidade
🐛 :bug: quando corrigir um bug
📝 :memo: ao escrever documentação
🚀 :rocket: para melhorias de desempenho
✅ :white_check_mark: ao adicionar testes
♻️ :recycle: ao refatorar código


### consumers
-> Camada para o caso for necessário consumir algo externo

### controllers
-> Camada de entrada e saída de dados através das requisições http

### dtos
-> Camada que serve para encaminhar somente os dados que realmente vai ser necessário de uma entidade/model

### models
-> Camada que serve para modelar os atributos do banco de dados

### producers 
-> Camada para caso for preciso encaminhar alguma fila para algum serviço externo

### repositories
-> Camada de manipulação do banco de dados através das querys SQL

### services
-> Camada de regra de negócio, dividida entre interface e implementação para melhor controle dos contratos e lógica 

### utlis 
-> Camada para agrupar uma lógica que vai ser útil em diversas camadas

### validations
-> Camada para validar/tratar dados e se preciso suas exceções




