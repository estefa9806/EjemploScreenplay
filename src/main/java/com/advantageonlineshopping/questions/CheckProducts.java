package com.advantageonlineshopping.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.advantageonlineshopping.userinterfaces.LoginPage.BTN_CAR;


public class CheckProducts implements Question<String> {
    private Target listaProductos;
    public CheckProducts(Target listaProductos) {
        this.listaProductos = listaProductos;
    }
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(Click.on(BTN_CAR));
        List<WebElement> productos = listaProductos.resolveFor(actor).findElements(By.tagName("td"));
return  null;
    }
    public static CheckProducts inShoppingCar(Target listaProductos) {
        return new CheckProducts( listaProductos);
    }
}
