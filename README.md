Estrutura do Projeto no Android Studio

ProspAI/


```plaintext
├── app/
│   ├── layout/              # Arquivos XML reutilizáveis para layouts
│   ├── pages/               # Activities para cada tela (Ex: Home, Analise, etc.)
│   ├── schemas/             # Modelos de dados (DTOs, POJOs)
│   ├── services/            # Lógica de negócios/serviços
│   ├── utils/               # Funções auxiliares/utilitários
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/prospai/
│   │   │       ├── activities/   # Arquivos das Activities
│   │   │       ├── fragments/    # Lógica baseada em fragments (se utilizado)
│   │   │       └── services/     # Classes de serviços
│   │   ├── res/
│   │       ├── layout/           # Arquivos XML de layout
│   │       ├── drawable/         # Imagens e ícones
│   │       ├── values/           # Strings, cores, dimensões
│   │       ├── mipmap/           # Ícones do app
│   ├── AndroidManifest.xml
├── build.gradle.kts              # Arquivo Gradle baseado em Kotlin
├── settings.gradle.kts           # Configurações do projeto
├── gradle/                       # Wrapper do Gradle
└── gradlew                       # Script do Gradle wrapper
```
Documentação da API: Clientes
Endpoint para Listar Clientes
Este endpoint permite listar todos os clientes cadastrados na base de dados.

URL
arduino
Copiar código
https://prospai.azurewebsites.net/api/clientes
Método HTTP
sql
Copiar código
GET
Parâmetros
Não são necessários parâmetros para esta requisição.

Cabeçalhos Recomendados
Content-Type: application/json (Opcional, pois GET não envia dados no corpo)
Exemplo de Requisição
Para buscar todos os clientes, use o seguinte comando curl:

bash
Copiar código
curl -X GET "https://prospai.azurewebsites.net/api/clientes"
Respostas
Código de Status HTTP
200 OK: A requisição foi bem-sucedida e a resposta contém a lista de clientes.
404 Not Found: O recurso solicitado não foi encontrado.
500 Internal Server Error: Erro no servidor ao processar a requisição.
Corpo da Resposta
Se a requisição for bem-sucedida, a resposta será uma lista de objetos JSON representando os clientes. Exemplo de resposta:

json
Copiar código
[
    {
        "id": 1,
        "nome": "João da Silva",
        "email": "joao.silva@example.com",
        "telefone": "123456789",
        "segmentoMercado": "Tecnologia",
        "scoreEngajamento": 85.0,
        "dataCriacao": "2023-01-15T12:34:56Z"
    },
    {
        "id": 2,
        "nome": "Maria Oliveira",
        "email": "maria.oliveira@example.com",
        "telefone": "987654321",
        "segmentoMercado": "Saúde",
        "scoreEngajamento": 90.0,
        "dataCriacao": "2023-02-20T08:21:45Z"
    }
]
Descrição dos Campos
id: Identificador único do cliente (número inteiro).
nome: Nome completo do cliente (string).
email: Endereço de e-mail do cliente (string).
telefone: Número de telefone do cliente (string).
segmentoMercado: Segmento de mercado ao qual o cliente pertence (string).
scoreEngajamento: Pontuação de engajamento do cliente (número decimal).
dataCriacao: Data e hora em que o cliente foi criado (string no formato ISO 8601).
Exemplos de Resposta
Resposta Bem-Sucedida:

json
Copiar código
[
    {
        "id": 1,
        "nome": "Ana Costa",
        "email": "ana.costa@example.com",
        "telefone": "123123123",
        "segmentoMercado": "Educação",
        "scoreEngajamento": 78.0,
        "dataCriacao": "2023-03-12T11:45:00Z"
    }
]
Resposta de Erro 404:

json
Copiar código
{
    "error": "Recurso não encontrado"
}
Resposta de Erro 500:

json
Copiar código
{
    "error": "Erro interno do servidor"
}
Notas
Certifique-se de que o servidor da API esteja ativo e acessível ao fazer a requisição.
Verifique os logs do servidor caso receba erros inesperado
