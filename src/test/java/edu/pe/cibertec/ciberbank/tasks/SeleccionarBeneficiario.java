package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarBeneficiario implements Task {

    private final String beneficiario;

    public SeleccionarBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public static SeleccionarBeneficiario conNombre(String beneficiario) {
        return instrumented(
                SeleccionarBeneficiario.class,
                beneficiario
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(TransferenciaScreen.SPINNER_BENEFICIARIO),
                SelectFromOptions.byVisibleText(beneficiario)
                        .from(TransferenciaScreen.SPINNER_BENEFICIARIO)
        );
    }
}