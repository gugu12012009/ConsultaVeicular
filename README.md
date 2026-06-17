# Consulta Veicular - Aplicativo Android

## 📱 Descrição
Aplicativo Android completo para consultar informações de rodízio e licenciamento de veículos, além de calcular qual combustível é mais vantajoso.

## ✅ Funcionalidades Implementadas

### 1️⃣ Splash Screen
- Exibe o nome do aplicativo
- Ícone relacionado a veículos 🚗
- Permanece visível por 2 segundos
- Navega automaticamente para a tela inicial

### 2️⃣ Tela Inicial (Menu)
- Botão: "Consulta de Rodízio e Licenciamento"
- Botão: "Calculadora de Combustível"
- Interface intuitiva e organizada

### 3️⃣ Tela de Consulta de Rodízio
**Entrada:** Placa do veículo (ex: ABC1D23)

**Extrai o último número da placa e informa:**
- Dia da semana do rodízio
- Horários de restrição
- Mês de licenciamento

**Regras do Rodízio:**
- Finais 1 e 2 → Segunda-feira (7h às 10h e 17h às 20h)
- Finais 3 e 4 → Terça-feira (7h às 10h e 17h às 20h)
- Finais 5 e 6 → Quarta-feira (7h às 10h e 17h às 20h)
- Finais 7 e 8 → Quinta-feira (7h às 10h e 17h às 20h)
- Finais 9 e 0 → Sexta-feira (7h às 10h e 17h às 20h)

**Regras de Licenciamento:**
- Final 1 e 2 → até julho
- Final 3 e 4 → até agosto
- Final 5 e 6 → até setembro
- Final 7 e 8 → até outubro
- Final 9 → até novembro
- Final 0 → até dezembro

### 4️⃣ Tela Calculadora de Combustível
**Entradas:**
- Preço da Gasolina (R$)
- Preço do Etanol (R$)

**Fórmula:** Etanol ÷ Gasolina

**Recomendações:**
- Se resultado < 0,70 → Etanol é mais vantajoso
- Se resultado >= 0,70 → Gasolina é mais vantajosa

## 🛠️ Estrutura do Projeto

```
ConsultaVeicular/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml
│   │       ├── java/com/example/consultaveicular/
│   │       │   ├── SplashActivity.java
│   │       │   ├── MainActivity.java
│   │       │   ├── RodizioActivity.java
│   │       │   ├── CombustivelActivity.java
│   │       │   └── UtilsRodizio.java
│   │       └── res/
│   │           ├── layout/
│   │           │   ├── activity_splash.xml
│   │           │   ├── activity_main.xml
│   │           │   ├── activity_rodizio.xml
│   │           │   └── activity_combustivel.xml
│   │           └── values/
│   │               ├── strings.xml
│   │               ├── colors.xml
│   │               └── styles.xml
│   └── build.gradle
├── build.gradle
└── gradle.properties
```

## 🎨 Design
- Material Design 3
- Cores automotivas: Azul, Cinza e Branco
- Interface responsiva
- Botões "Voltar" em todas as telas secundárias

## 📋 Requisitos Técnicos
- ✅ Java puro (sem Kotlin)
- ✅ XML para layouts
- ✅ Activities separadas
- ✅ Validações de entrada
- ✅ 100% offline (sem banco de dados)
- ✅ Material Components
- ✅ API 21+ (Android 5.0)

## 🚀 Como Executar

1. Clone o repositório
2. Abra no Android Studio
3. Sincronize o Gradle
4. Execute no emulador ou dispositivo físico

## 📦 Dependências
- androidx.appcompat:appcompat:1.6.1
- com.google.android.material:material:1.11.0
- androidx.constraintlayout:constraintlayout:2.1.4

## ✨ Validações Implementadas
- Verificação de placa vazia
- Extração correta do último número
- Validação de valores numéricos na calculadora
- Mensagens de erro amigáveis
- Campos obrigatórios

## 👨‍💻 Autor
Gustavo de Jesus Santos Soares (gugu12012009)
