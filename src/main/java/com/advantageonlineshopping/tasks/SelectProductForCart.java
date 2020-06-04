package com.advantageonlineshopping.tasks;


import com.advantageonlineshopping.interactions.Wait;
import com.advantageonlineshopping.util.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static com.advantageonlineshopping.userinterfaces.LoginPage.*;

public class SelectProductForCart implements Task {
    private String product;
    private String productName;

    public SelectProductForCart(String product, String productName) {
        this.product = product;
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.aMoment(2));
        switch (product.toUpperCase()) {
            case "TABLETS":
                actor.attemptsTo(Click.on(BTN_TABLE));
                break;
            case "SPEAKERS":
                actor.attemptsTo(Click.on(BTN_SPEKEARS));
                break;
            default:
                Log.printError("No se encontro el elemento");
                break;
        }
        actor.attemptsTo(Click.on(PRODUCT.of(productName)), Wait.aMoment(2), Click.on(BTN_ADD_CAR));
    }

    public static SelectProductForCart inPage(String product, String productName) {
        return Tasks.instrumented(SelectProductForCart.class, product, productName);
    }

}
