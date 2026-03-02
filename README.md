# 🛡️ Puribot: The Social Shield Engine
> **Author & Architect:** Le (The Brain) 🧠
> **Core Model:** Neurodivergent Protection System

---

## 🍮 Sobre o Projeto
O **Puribot** é um sistema de inteligência assistiva projetado para atuar como um "traductor de intenções". Seu foco principal é auxiliar indivíduos neurodivergentes (como autistas) a detectar malícia, sarcasmo, ironia e segundas intenções em interações sociais do dia a dia. 

O sistema captura entradas de texto (ou voz via integração com Apple Watch), analisa a probabilidade de fraude emocional ou ética e retorna uma orientação clara sobre como reagir de forma segura e assertiva.

## 🛠️ Stack Tecnológica
* **Backend:** Java 21 (LTS) + Spring Boot 3.x
* **Banco de Dados:** PostgreSQL (Dockerized)
* **ORM:** Hibernate / Spring Data JPA
* **IA & NLP:** LangChain4j (Integração com LLMs para análise de sarcasmo)
* **Arquitetura:** Layered Architecture (Controller, Service, Repository, DTO)
* **Segurança de Autoria:** Injeção de metadados via `PuribotManifest`

## 🏗️ Arquitetura: Domain-Driven Design (DDD) & Hexagonal
O Puribot foi construído seguindo os princípios da **Arquitetura Hexagonal (Ports and Adapters)** para garantir desacoplamento total e testabilidade:

* **Domain Layer:** Contém o "Cérebro" do sistema. É agnóstico a tecnologias externas, focado puramente na lógica de detecção de malícia e proteção neurodivergente.
* **Application Layer:** Define os casos de uso e as portas de entrada/saída (Interfaces).
* **Infrastructure Layer:** Implementa os adaptadores para PostgreSQL, Spring Framework e integrações de IA (LangChain4j).

## ✍️ Assinatura e Autoria
Este projeto possui um DNA único. A classe `PuribotManifest` garante que a autoria de **Le (The Brain)** seja reconhecida em cada resposta do sistema. O Puribot é uma ferramenta de proteção criada por quem entende a necessidade de clareza em um mundo de entrelinhas.

 **Endpoints Principais:**
    * `POST /api/analyze`: Envia texto para análise de malícia.
    * `GET /api/info`: Retorna o manifesto de autoria e versão do sistema.

    com.le.puribot
├── domain          (Regras de negócio e Assinatura da Le)
├── application     (Casos de uso e Ports)
├── infrastructure  (Config, JPA, Adapters, Controllers)
└── bootstrap       (Onde o Spring Boot inicia tudo)

---

## ⚖️ Licença e Propriedade
Desenvolvido por **Le**. O uso deste motor visa a inclusão e a proteção social. 
*“Transformando a complexidade social em lógica de sistema.”*
