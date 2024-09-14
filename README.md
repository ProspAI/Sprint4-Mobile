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
