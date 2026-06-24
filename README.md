



# Sistema de Notificaciones (Factory Method)

Este proyecto implementa un sistema flexible para enviar notificaciones por diferentes canales (Email, SMS, Push) utilizando Spring Boot. Está diseñado para que añadir un nuevo canal sea lo más sencillo posible sin romper el código existente.

## Cómo funciona la estructura

El diseño se divide en tres partes clave:

* **El Producto (`Notification`):** La interfaz que define cómo se envía una notificación. De aquí salen `EmailNotification`, `SmsNotification`, etc.
* **El Creador (`NotificationCreator`):** La lógica que sabe cómo procesar y fabricar cada tipo de notificación. Cada canal tiene el suyo (ej. `EmailNotificationCreator`) marcado con `@Component` para que Spring lo maneje.
* **La Fábrica (`NotificationCreatorFactory`):** Centraliza todos los creadores y elige automáticamente el correcto en tiempo de ejecución según el tipo que se solicite.

## Ventajas de este diseño

* **Inyección automática:** Spring Boot detecta y registra todos los canales de notificación disponibles sin necesidad de configurarlos a mano.
* **Código limpio:** Evitamos usar bloques gigantes de `if-else` o `switch` para decidir qué notificación enviar.
* **Fácil de mantener:** Toda la lógica común (como registrar logs o auditorías) se centraliza en un solo lugar en lugar de repetirse por cada canal.

## Cómo probarlo

Ejecuta la aplicación:

```bash
mvn spring-boot:run

```

```

## Cómo agregar un nuevo canal (Ejemplo: WhatsApp)

Para añadir WhatsApp, solo debes seguir estos tres pasos sin tocar el código de los otros canales:

1. Crear la clase `WhatsAppNotification`.
2. Crear su creador `WhatsAppNotificationCreator` anotado con `@Component`.
3. Agregar el tipo `WHATSAPP` al Enum de tipos de notificación.