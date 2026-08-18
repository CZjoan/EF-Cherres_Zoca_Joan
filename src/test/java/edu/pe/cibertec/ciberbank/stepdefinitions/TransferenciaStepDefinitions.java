package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.tasks.AceptarTransferencia;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.SeleccionarBeneficiario;
import edu.pe.cibertec.ciberbank.tasks.RealizarTransferencia;
import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.ensure.Ensure.that;

public class TransferenciaStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que Jaime inició sesión con el usuario {string}")
    public void jaime_inicio_sesion(String usuario) {

        theActorCalled("Jaime").attemptsTo(
                IniciarSesion.con(usuario, "Cibertec123")
        );
    }

    @Dado("que inicia sesión con el usuario {string}")
    public void inicia_sesion_con_usuario(String usuario) {

        theActorCalled(usuario).attemptsTo(
                IniciarSesion.con(usuario, "Cibertec123")
        );
    }

    @Cuando("transfiere {double} al beneficiario {string}")
    public void transfiere_al_beneficiario(
            Double monto,
            String beneficiario) {

        theActorInTheSpotlight().attemptsTo(
                SeleccionarBeneficiario.conNombre(beneficiario),
                RealizarTransferencia.porMonto(
                        String.valueOf(monto)
                )
        );
    }

    @Cuando("intenta transferir {double} al beneficiario {string}")
    public void intenta_transferir_al_beneficiario(
            Double monto,
            String beneficiario) {

        theActorInTheSpotlight().attemptsTo(
                SeleccionarBeneficiario.conNombre(beneficiario),
                RealizarTransferencia.porMonto(
                        String.valueOf(monto)
                )
        );
    }

    @Y("acepta el diálogo de confirmación")
    public void acepta_dialogo() {

        theActorInTheSpotlight().attemptsTo(
                AceptarTransferencia.confirmacion()
        );
    }

    @Entonces("debería ver un número de operación generado")
    public void deberia_ver_numero_operacion() {

        theActorInTheSpotlight().attemptsTo(
                that(TextoDe.el(TransferenciaScreen.NUMERO_OPERACION))
                        .isNotBlank()
        );
    }

    @Y("el saldo debería quedar en {string}")
    public void el_saldo_deberia_quedar(String saldo) {

        theActorInTheSpotlight().attemptsTo(
                that(TextoDe.el(TransferenciaScreen.SALDO))
                        .isEqualTo(saldo)
        );
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberia_ver_mensaje_error(String mensaje) {

        theActorInTheSpotlight().attemptsTo(
                that(TextoDe.el(TransferenciaScreen.MENSAJE_ERROR))
                        .isEqualTo(mensaje)
        );
    }
}