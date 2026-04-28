# 🎮 KingsMarket - API de E-commerce de Games

Este é o back-end de uma plataforma de e-commerce robusta para o mercado de games. Desenvolvido com **Java Spring Boot**, o sistema gerencia um ecossistema complexo de jogos, categorias e desenvolvedoras, utilizando as melhores práticas de arquitetura REST e performance de dados.

## 🚀 Diferenciais Técnicos

Diferente de um CRUD comum, este projeto implementa:

* **Relacionamentos Dinâmicos:** Vinculação entre Jogos, Desenvolvedoras e Categorias (Gêneros).
* **Interface Projections:** Consultas otimizadas que devolvem apenas o necessário para o front-end, reduzindo o consumo de banda.
* **Paginação e Filtros:** Endpoints preparados para grandes volumes de dados com filtros por termo e preço.
* **Tratamento de Exceções Global:** Sistema personalizado de mensagens de erro que retorna JSONs claros e amigáveis para o usuário.
* **Validação de Dados:** Uso de *Bean Validation* para garantir a integridade das informações no banco de dados.

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA**: Persistência de dados eficiente.
* **Oracle Database**: Banco de dados relacional de alto desempenho.
* **Lombok**: Produtividade na criação de classes de modelo.
* **Jakarta Validation**: Regras de negócio direto na camada de dados.
* **Maven**: Gestão de dependências e automação de build.

---

## 📂 Arquitetura do Sistema

A estrutura foi organizada seguindo o padrão de camadas para facilitar a escalabilidade:

* **Controller**: Endpoints REST que gerenciam as requisições HTTP.
* **Service**: O "coração" da aplicação, contendo as regras de negócio e validações.
* **Repository**: Abstração da comunicação com o banco de dados.
* **Model/Entity**: Definição das tabelas e relacionamentos JPA.
* **Projections**: Interfaces para otimização de consultas (DTO).
* **Exceptions**: Gerenciamento centralizado de erros da API.

---

## 🔗 Endpoints Principais

### **Jogos**
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/jogos` | Lista todos os jogos com detalhes completos. |
| `GET` | `/api/jogos/buscar` | Busca paginada por termo (título) usando Projeção. |
| `GET` | `/api/jogos/preco-maximo` | Filtra jogos por valor máximo. |
| `POST` | `/api/jogos` | Cadastra um novo jogo (requer DevID e CatID). |
| `PUT` | `/api/jogos/{id}` | Atualiza dados de um jogo existente. |
| `DELETE` | `/api/jogos/{id}` | Remove um jogo do inventário. |

### **Categorias e Desenvolvedoras**
* Endpoints completos de CRUD disponíveis em `/api/categorias` e `/api/desenvolvedoras`.

---

## 🔧 Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Jppcamilo/KingsMarket.git
    ```
2.  **Configuração do Banco:**
    Atualize as credenciais do seu banco Oracle no arquivo `src/main/resources/application.properties`.
3.  **Build e Run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

---

### 👥 Equipe de Desenvolvimento
* **João Pedro Pereira Camilo** | RM 562005
* **Lucas Matsubara Reis** | RM 565020
* **Pamella Christiny Chaves Brito** | RM 565206
