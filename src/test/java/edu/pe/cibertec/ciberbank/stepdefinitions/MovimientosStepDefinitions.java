package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.DesplazarLista;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.ensure.Ensure.that;

public class MovimientosStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Cuando("abre la pantalla de movimientos")
    public void abre_la_pantalla_de_movimientos() {

    }

    @Entonces("debería ver el contador {string}")
    public void deberia_ver_el_contador(String contador) {

        theActorInTheSpotlight().attemptsTo(
                that(TextoDe.el(
                        MovimientosScreen.CONTADOR_MOVIMIENTOS
                )).isEqualTo(contador)
        );
    }

    @Cuando("desplaza la lista hasta el final")
    public void desplaza_la_lista_hasta_el_final() {

        theActorInTheSpotlight().attemptsTo(
                DesplazarLista.hastaElFinal()
        );
    }
}