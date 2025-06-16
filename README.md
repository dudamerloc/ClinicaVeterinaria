# 🐶 Clínica Veterinária - Sistema de Gerenciamento  

## 🐾 Sobre o Projeto  
Este projeto é um sistema simples para ajudar a organizar o atendimento em uma clínica veterinária. Ele facilita o cadastro dos tutores, dos pets, o agendamento de consultas com veterinários e a listagem dos atendimentos realizados.

Foi desenvolvido em Java, com foco na programação orientada a objetos, para garantir uma estrutura clara e fácil de manter.

## 📋 Funcionalidades  
- Cadastro dos tutores dos pets, com nome, CPF, telefone e endereço.  
- Cadastro dos pets, com informações como nome, tipo, sexo e castração.  
- Cadastro dos veterinários, incluindo nome, CPF e CRMV.  
- Agendamento de consultas, relacionando pet, veterinário, data e descrição.  
- Listagem das consultas agendadas.  
- Validações para garantir que os dados estejam corretos antes do agendamento.

## 📁 Estrutura do Projeto  
- **model**: classes que representam os dados do sistema (Cliente, Animal, Veterinário, Consulta).  
- **controller**: lógica do sistema que gerencia os dados e as regras.  
- **view**: interface simples via console para interação com o usuário.

## ⚙️ Como Usar  
1. Tenha o Java instalado (JDK 11 ou superior).  
2. Execute a classe `view.Menu` na sua IDE ou pelo terminal.

### 🐕 Passos no Sistema  
- Escolha entre as opções do menu:  
  - Cadastrar o tutor do pet.  
  - Cadastrar o pet.  
  - Agendar uma consulta.  
  - Listar as consultas agendadas.  
  - Sair do sistema.  
- Preencha as informações solicitadas de forma clara.  
- Para agendar uma consulta, o tutor, o pet e o veterinário devem estar cadastrados.

## ⚠️ Observações Importantes  
- O CPF identifica unicamente cada tutor.  
- Cada pet está vinculado ao seu tutor.  
- Os veterinários são identificados pelo CRMV.  
- As consultas são registradas com a data atual.  
- Validações simples garantem que o sistema funcione corretamente.

