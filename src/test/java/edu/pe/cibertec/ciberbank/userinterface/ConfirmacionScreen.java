package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionScreen {

    public static final Target ACEPTAR =
            Target.the("botón Aceptar del diálogo de confirmación")
                    .located(By.id("android:id/button1"));

    public static final Target CANCELAR =
            Target.the("botón Cancelar del diálogo de confirmación")
                    .located(By.id("android:id/button2"));
}