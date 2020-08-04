package com.advantageonlineshopping.tasks;


import com.advantageonlineshopping.interactions.Wait;
import com.advantageonlineshopping.util.Log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

import static com.advantageonlineshopping.userinterfaces.LoginPage.*;

public class SelectProductForCart implements Task {
    private List<Map<String, String>> listDatos;

    public SelectProductForCart(List<Map<String, String>> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i=0;i<listDatos.size();i++) {
            switch (listDatos.get(i).get("menu").toUpperCase()) {
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
            actor.attemptsTo(Click.on(PRODUCT.of(listDatos.get(i).get("product"))));
            actor.attemptsTo( Click.on(BTN_ADD_CAR), Click.on(BTN_HOME));
        }

    }

    public static SelectProductForCart inPage(List<Map<String, String>> listDatos) {
        return Tasks.instrumented(SelectProductForCart.class, listDatos);
    }

}
