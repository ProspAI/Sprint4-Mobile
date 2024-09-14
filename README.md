Estrutura do Projeto no android studio
ProspAI/
├── app/
│   ├── layout/              # Reusable layout XML files
│   ├── pages/               # Activities for each screen (e.g., Home, Analise, etc.)
│   ├── schemas/             # Data models (DTOs, POJOs)
│   ├── services/            # Business logic/services
│   ├── utils/               # Helper functions/utilities
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/prospai/
│   │   │       ├── activities/   # Activity files
│   │   │       ├── fragments/    # Fragment-based logic (if used)
│   │   │       └── services/     # Service classes
│   │   ├── res/
│   │       ├── layout/           # XML layout files
│   │       ├── drawable/         # Images and icons
│   │       ├── values/           # Strings, colors, dimensions
│   │       ├── mipmap/           # App icons
│   ├── AndroidManifest.xml
├── build.gradle.kts              # Kotlin-based Gradle file
├── settings.gradle.kts           # Project settings
├── gradle/                       # Gradle wrapper
└── gradlew                       # Gradle wrapper script
