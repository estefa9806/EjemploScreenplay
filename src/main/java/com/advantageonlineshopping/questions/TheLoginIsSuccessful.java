package com.advantageonlineshopping.questions;

import com.advantageonlineshopping.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static com.advantageonlineshopping.userinterfaces.LoginPage.USER_NAME;


public class TheLoginIsSuccessful implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(Wait.aMoment(2));
        return  Text.of(USER_NAME).viewedBy(actor).asString();
    }
    public static TheLoginIsSuccessful inPage() {
        return new TheLoginIsSuccessful();
    }
}
