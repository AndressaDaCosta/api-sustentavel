# API Sustentável - Ações pelo Futuro

API REST para gerenciamento de ações sustentáveis promovidas por pessoas físicas, ONGs ou empresas.

## Tecnologias Utilizadas

-   Java 17
-   Spring Boot 3.2.0
-   Spring Data JPA
-   PostgreSQL
-   Bean Validation
-   Maven

## Configuração do Banco de Dados

Configure um banco PostgreSQL com as seguintes credenciais (ou altere no application.properties):

```
URL: jdbc:postgresql://localhost:5432/api_sustentavel
Usuário: postgres
Senha: postgres
```

## Como Executar

1. Clone o repositório
2. Configure o banco PostgreSQL

### **2. Configurar o Banco de Dados**

```bash
# Acessar o PostgreSQL
psql -U postgres

# Dentro do psql, executar:
CREATE DATABASE api_sustentavel;
\q
```

3. Execute: `mvn spring-boot:run`
4. A aplicação estará disponível em: `http://localhost:8080`

## Endpoints da API

### Listar todas as ações

-   **GET** `/acoes`
-   Retorna todas as ações sustentáveis cadastradas

### Buscar ação por ID

-   **GET** `/acoes/{id}`
-   Retorna uma ação específica pelo ID

### Criar nova ação

-   **POST** `/acoes`
-   Body (JSON):

```json
{
	"titulo": "Plantio de Árvores no Parque",
	"descricao": "Ação de plantio de 100 mudas nativas",
	"categoria": "PLANTIO",
	"dataRealizacao": "2025-09-24",
	"responsavel": "Andressa Teste"
}
```

### Atualizar ação

-   **PUT** `/acoes/{id}`
-   Body: mesmo formato do POST

### Deletar ação

-   **DELETE** `/acoes/{id}`
-   Remove a ação pelo ID

### Filtrar por categoria

-   **GET** `/acoes/categoria?tipo={CATEGORIA}`
-   Categorias disponíveis: DOACAO, RECICLAGEM, PLANTIO, EDUCACAO_AMBIENTAL, OUTROS

## Validações

-   **título**: obrigatório, entre 3 e 100 caracteres
-   **descrição**: obrigatório, entre 10 e 1000 caracteres
-   **categoria**: obrigatório, deve ser um dos valores do enum
-   **dataRealizacao**: obrigatório, não pode ser futura
-   **responsavel**: obrigatório, entre 2 e 100 caracteres

## Tratamento de Erros

A API possui tratamento global de exceções que retorna respostas padronizadas:

-   **400 Bad Request**: Erros de validação
-   **404 Not Found**: Recurso não encontrado
-   **500 Internal Server Error**: Erros internos do servidor

## Exemplo de Resposta de Erro

```json
{
	"timestamp": "2025-09-24T22:00:00",
	"status": 400,
	"error": "Bad Request",
	"message": "Erro de validação",
	"path": "/acoes",
	"details": [
		"titulo: Título é obrigatório",
		"dataRealizacao: Data de realização é obrigatória"
	]
}
```

## **✅ CHECKLIST DE VALIDAÇÃO**

-   [x] PostgreSQL instalado e rodando
-   [x] Banco `api_sustentavel` criado
-   [x] Aplicação sobe sem erros
-   [x] GET `/acoes` retorna `[]`
-   [x] POST cria nova ação
-   [x] GET `/acoes` mostra a ação criada
-   [x] GET `/acoes/1` retorna a ação
-   [x] Filtro por categoria funciona
-   [x] Validação de campos obrigatórios funciona
-   [x] PUT atualiza ação existente
-   [x] DELETE remove ação
