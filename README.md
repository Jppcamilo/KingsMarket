# 🎮 KingsMarket - Loja Virtual de Jogos

Este é o back-end de uma plataforma de e-commerce voltada para o mercado de games. O projeto foi desenvolvido para gerenciar o inventário de jogos e desenvolvedoras, permitindo operações completas de CRUD (Create, Read, Update, Delete) através de uma API REST robusta.

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando as melhores práticas de desenvolvimento Java:

* **Java 17** (ou a versão que você estiver usando)
* **Spring Boot**: Framework principal para agilidade no desenvolvimento.
* **Spring Data JPA**: Para persistência de dados de forma simplificada.
* **Banco de Dados SQL**: Armazenamento relacional para jogos e desenvolvedoras.
* **Lombok**: Para redução de código boilerplate (Getters, Setters, etc).
* **Maven**: Gerenciador de dependências.

## 🛠️ Arquitetura e Organização

O sistema segue o padrão de camadas para garantir a manutenção e escalabilidade:

1.  **Controller**: Camada de entrada, onde os endpoints da API são definidos.
2.  **Service**: Camada de lógica de negócio, isolando a regra do sistema.
3.  **Repository**: Camada de acesso ao banco de dados utilizando JPA.
4.  **Model/Entity**: Representação das tabelas do banco de dados.

## 📌 Funcionalidades Principais

* [x] Cadastro e listagem de novos jogos.
* [x] Gerenciamento de desenvolvedoras vinculadas aos títulos.
* [x] Atualização de dados e remoção lógica ou física de registros.
* [x] Validação de dados de entrada.

## 🔧 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/LucasMatsubara/kingsMarket.git
    ```
2.  **Configure o Banco de Dados:**
    Ajuste as credenciais no arquivo `src/main/resources/application.properties`.
3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

---
Desenvolvido por: 
👤 João Pedro Pereira Camilo | RM 562005
👤 Lucas Matsubara Reis | RM 565020
👤 Pamella Christiny Chaves Brito | RM 565206
