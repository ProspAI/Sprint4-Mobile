# Documentação do Projeto ProspApp

## Visão Geral

O **ProspApp** é um aplicativo móvel desenvolvido com Kotlin para Android, que se integra com uma API para gerenciar clientes, feedbacks, previsões, relatórios, estratégias de vendas e usuários. O aplicativo inclui funcionalidades para login, navegação entre diferentes telas e visualização de dados.

## Como Usar o Aplicativo

### 1. Configuração Inicial

Certifique-se de ter um ambiente Android configurado:

- **Android Studio instalado.**
- **SDK do Android configurado.**

Adicione o arquivo `google-services.json` (se aplicável):

- Se estiver usando serviços do Firebase, adicione o arquivo `google-services.json` ao diretório `app` do seu projeto.

### 2. Credenciais de Acesso

Para testar o aplicativo, você pode usar as seguintes credenciais de login:

- **Email:** `teste@gmail.com`
- **Senha:** `123456`

Essas credenciais devem ser criadas na plataforma de autenticação Firebase ou no seu sistema de backend, conforme configurado.

### 3. Telas do Aplicativo

O aplicativo possui as seguintes telas:

#### Tela de Login (`LoginActivity`)

- **Descrição:** Tela inicial onde os usuários inserem suas credenciais para acessar o aplicativo.
- **Funcionalidade:** Permite login com email e senha. Um botão de login redireciona para a tela principal após a autenticação bem-sucedida.

#### Tela Home (`MainActivity`)

- **Descrição:** Tela principal exibida após o login bem-sucedido.
- **Funcionalidade:** Exibe uma visão geral e fornece botões para navegar para outras telas, como Análise e Agenda. O método `fetchClientes` é chamado aqui para listar clientes da API.

#### Tela de Análise (`AnaliseActivity`)

- **Descrição:** Tela dedicada à análise de dados.
- **Funcionalidade:** Exibe informações e gráficos relacionados às análises disponíveis.

#### Tela de Agenda (`AgendaActivity`)

- **Descrição:** Tela para gerenciamento de eventos e tarefas.
- **Funcionalidade:** Permite visualizar e interagir com itens agendados.

#### Tela de Cadastro (não utilizada)

- **Descrição:** Tela projetada para registro de novos usuários, mas não está incluída no código atual.

### 4. Executar o Projeto

1. Abra o projeto no Android Studio.
2. Certifique-se de que todas as dependências estão corretamente configuradas e sincronizadas.
3. Execute o aplicativo no emulador ou em um dispositivo físico.

### 5. Testar a API

Para testar a API, você pode usar ferramentas como Postman ou cURL. Por exemplo, para listar todos os clientes:

```bash
curl -X GET "https://prospai.azurewebsites.net/api/clientes"
6. Documentação da API
Endpoint para Listar Clientes
URL: https://prospai.azurewebsites.net/api/clientes
Método HTTP: GET
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
Verifique os logs do servidor caso receba erros inesperados.
Estrutura do Projeto no Android Studio
plaintext
Copiar código
ProspAI/
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
