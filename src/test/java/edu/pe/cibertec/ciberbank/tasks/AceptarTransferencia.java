package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.Click;

public class AceptarTransferencia implements Task {

    public static AceptarTransferencia confirmacion() {
        return instrumented(AceptarTransferencia.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ConfirmacionScreen.ACEPTAR)
        );
    }
}