package com.advantageonlineshopping.tasks;

import com.advantageonlineshopping.certificacion.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.advantageonlineshopping.certificacion.userinterface.LoginPage.*;

public class Login implements Task {
    private String user;
    private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
actor.attemptsTo(Wait.aMoment(2), Click.on(BTN_LOGIN),
        Enter.theValue(user).into(FIELD_USER), Enter.theValue(pass).into(FIELD_PASS), Click.on(BTN_SING_IN));
    }
    public static Login inPage(String user,String pass ){
        return Tasks.instrumented(Login.class,user,pass);
    }
}
