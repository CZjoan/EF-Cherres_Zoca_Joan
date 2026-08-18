package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.CerrarSesion;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;

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

public class PerfilStepDefinitions {

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

    @Cuando("cierra sesión")
    public void cierra_sesion() {

        theActorInTheSpotlight().attemptsTo(
                CerrarSesion.ejecutar()
        );
    }

    @Entonces("debería ver la pantalla de login")
    public void deberia_ver_pantalla_login() {

        theActorInTheSpotlight().attemptsTo(
                that(LoginScreen.CAMPO_USUARIO)
                        .isDisplayed()
        );
    }

    @Y("presiona el botón atrás del sistema")
    public void presiona_boton_atras() {

    }

    @Entonces("debería seguir en la pantalla de login")
    public void deberia_seguir_en_login() {

        theActorInTheSpotlight().attemptsTo(
                that(LoginScreen.CAMPO_USUARIO)
                        .isDisplayed()
        );
    }
}