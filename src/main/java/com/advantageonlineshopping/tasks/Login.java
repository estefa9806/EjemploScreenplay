package com.advantageonlineshopping.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.advantageonlineshopping.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class Login implements Task {
    private String user;
    private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_LOGIN),
                WaitUntil.the(FIELD_USER, isEnabled()).forNoMoreThan(4).seconds(),
                Enter.theValue(user).into(FIELD_USER));
                actor.attemptsTo(
                Check.whether(CurrentVisibility.of(FIELD_PASS).viewedBy(actor).asBoolean()).
                        andIfSo(Enter.theValue(pass).into(FIELD_PASS)).
                        otherwise(),
                Click.on(BTN_SING_IN));
    }

    public static Login inPage(String user, String pass) {
        return Tasks.instrumented(Login.class, user, pass);
    }
}
