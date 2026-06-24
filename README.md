# Factory Method en Spring Boot — Sistema de Notificaciones

## Estructura del patrón

| Rol GoF             | Clase                                                              |
|----------------------|---------------------------------------------------------------------|
| Product              | `Notification` (interfaz)                                          |
| Concrete Product     | `EmailNotification`, `SmsNotification`, `PushNotification`         |
| Creator              | `NotificationCreator` (abstracta, define `crearNotificacion()`)    |
| Concrete Creator     | `EmailNotificationCreator`, `SmsNotificationCreator`, `PushNotificationCreator` |
| Cliente              | `NotificationService` (vía `NotificationCreatorFactory`)            |

## Por qué este diseño funciona bien en Spring Boot

1. **Cada Concrete Creator es un `@Component`.** Spring los detecta automáticamente
   por classpath scanning; no hay que registrarlos a mano.
2. **`NotificationCreatorFactory` recibe `List<NotificationCreator>` por constructor.**
   Spring inyecta TODOS los creators existentes automáticamente. La factory los
   indexa por `NotificationType` para resolverlos en O(1) en tiempo de ejecución.
3. **Principio Abierto/Cerrado real:** para añadir un canal nuevo (ej. WhatsApp)
   solo se crean `WhatsAppNotification` + `WhatsAppNotificationCreator` con
   `@Component`. No se toca ninguna clase existente, ni switch, ni if-else.
4. **El Service y el Controller nunca usan `new EmailNotification()` directamente.**
   Solo conocen las abstracciones `Notification` / `NotificationCreator`,
   cumpliendo el Principio de Inversión de Dependencias.
5. **`procesarEnvio()` en el Creator abstracto** es el método "plantilla" que usa
   el Factory Method internamente — ahí se centraliza lógica común (logging,
   métricas, reintentos) sin duplicarla en cada Concrete Creator.

## Cómo probarlo

```bash
mvn spring-boot:run
```

```bash
curl -X POST "http://localhost:8080/api/notificaciones/EMAIL?mensaje=Hola&destinatario=ana@mail.com"
curl -X POST "http://localhost:8080/api/notificaciones/SMS?mensaje=Hola&destinatario=3001234567"
curl -X POST "http://localhost:8080/api/notificaciones/PUSH?mensaje=Hola&destinatario=device-token-123"
```

## Cómo extenderlo (ejemplo: agregar WhatsApp)

1. Crear `WhatsAppNotification implements Notification`.
2. Crear `WhatsAppNotificationCreator extends NotificationCreator` con `@Component`.
3. Agregar `WHATSAPP` al enum `NotificationType`.
4. Listo. No se modifica ninguna otra clase.
