package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PerfilScreen {

    private static final String PAQUETE =
            "edu.pe.cibertec.ciberbank:id/";

    public static final Target BOTON_CERRAR_SESION =
            Target.the("botón cerrar sesión")
                    .located(By.id(PAQUETE + "btn_cerrar_sesion"));

    public static final Target PANTALLA_LOGIN =
            Target.the("pantalla de login")
                    .located(By.id(PAQUETE + "inp_usuario"));

    public static final Target DASHBOARD =
            Target.the("dashboard")
                    .located(By.id(PAQUETE + "dashboard"));
}