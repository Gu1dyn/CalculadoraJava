# Calculadora Java

Una calculadora simple desarrollada en Java con interfaz gráfica usando Swing.

## Características

- ✅ Suma
- ✅ Resta
- ✅ Multiplicación
- ✅ División (con validación de división por cero)
- ✅ Interfaz gráfica intuitiva
- ✅ Función de limpiar campos

## Estructura del Proyecto

```
src/
├── App.java                     # Clase principal
├── mundo/
│   └── Calculadora.java         # Lógica de operaciones matemáticas
└── interfaz/
    ├── InterfazCalculadora.java # Ventana principal
    ├── PanelDatos.java          # Panel de entrada de datos
    ├── PanelBotones.java        # Panel de botones de operaciones
    └── PanelResultados.java     # Panel de resultados
```

## Requisitos

- Java 8 o superior
- JDK instalado

## Compilación y Ejecución

### Opción 1: Desde línea de comandos

```bash
# Compilar
javac -d . src/App.java src/mundo/*.java src/interfaz/*.java

# Ejecutar
java App
```

### Opción 2: Visual Studio Code

1. Asegúrate de tener instalada la extensión "Extension Pack for Java"
2. Abre el proyecto en VS Code
3. Presiona `F5` o usa `Run > Start Debugging`

## Uso

1. Ingresa el primer número en el campo "Número 1"
2. Ingresa el segundo número en el campo "Número 2"
3. Selecciona la operación deseada (Sumar, Restar, Multiplicar, Dividir)
4. El resultado aparecerá en el campo "Resultado"
5. Usa el botón "Limpiar" para borrar todos los campos

## Capturas de Pantalla

![Calculadora](screenshot.png)

## Características Técnicas

- **Patrón de diseño**: Separación de responsabilidades (lógica de negocio vs interfaz)
- **Manejo de excepciones**: Validación de división por cero
- **Interfaz**: Swing con GridLayout y BorderLayout
- **Eventos**: ActionListener para manejo de botones

## Autor

Johan David Guillen Becerra

Enlace del proyecto: (https://github.com/Gu1dyn/CalculadoraJava)
