package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

public class RealizarTransferencia implements Task {

    private final String monto;

    public RealizarTransferencia(String monto) {
        this.monto = monto;
    }

    public static RealizarTransferencia porMonto(String monto) {
        return instrumented(
                RealizarTransferencia.class,
                monto
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Clear.field(TransferenciaScreen.CAMPO_MONTO),
                Enter.theValue(monto)
                        .into(TransferenciaScreen.CAMPO_MONTO),
                Click.on(TransferenciaScreen.BOTON_TRANSFERIR)
        );
    }
}