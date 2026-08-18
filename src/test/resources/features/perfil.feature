# language: es

@perfil
Característica: Cierre de sesión

  Escenario: Cerrar sesión correctamente
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando cierra sesión
    Entonces debería ver la pantalla de login

  Escenario: El botón atrás no permite regresar al dashboard después del logout
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando cierra sesión
    Y presiona el botón atrás del sistema
    Entonces debería seguir en la pantalla de login