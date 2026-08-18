package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferenciaScreen {

    private static final String PAQUETE =
            "edu.pe.cibertec.ciberbank:id/";

    public static final Target SPINNER_BENEFICIARIO =
            Target.the("spinner de beneficiarios")
                    .located(By.id(PAQUETE + "spn_beneficiario"));

    /*
     * Estos tres resource-id deben confirmarse con Appium Inspector.
     * No los vamos a inventar.
     */
    public static final Target CAMPO_MONTO =
            Target.the("campo monto de transferencia")
                    .located(By.id(PAQUETE + "inp_monto"));

    public static final Target BOTON_TRANSFERIR =
            Target.the("botón transferir")
                    .located(By.id(PAQUETE + "btn_transferir"));

    public static final Target MENSAJE_ERROR =
            Target.the("mensaje de error de transferencia")
                    .located(By.id(PAQUETE + "err_transferencia"));

    public static final Target NUMERO_OPERACION =
            Target.the("número de operación")
                    .located(By.id(PAQUETE + "txt_numero_operacion"));

    public static final Target SALDO =
            Target.the("saldo disponible")
                    .located(By.id(PAQUETE + "txt_saldo"));
}