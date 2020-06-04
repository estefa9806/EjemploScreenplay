package com.advantageonlineshopping.stepdefinitions;

import com.advantageonlineshopping.questions.TheLoginIsSuccessful;
import com.advantageonlineshopping.tasks.Login;
import com.advantageonlineshopping.tasks.SelectProductForCart;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ManejarUsuariosStepDefinitions {
    @Before
public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled("Mariana");
}

    @Given("^that Mariana is logged in$")
    public void thatMarianaIsLoggedIn(List<Map<String, String>> listDatos) {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.advantageonlineshopping.com/"));
        OnStage.theActorInTheSpotlight().attemptsTo(Login.inPage(listDatos.get(0).get("user"),listDatos.get(0).get("pass")));
    }
    @Then("^successful login is validated with (.*)$")
    public void successfulLoginIsValidated(String user) {
        theActorInTheSpotlight().should(seeThat(TheLoginIsSuccessful.inPage(), equalToIgnoringCase(user)));
    }
    @When("^and add a tablet to the shopping cart$")
    public void andAddATabletToTheShoppingCart(List<Map<String, String>> listDatos) {
        theActorInTheSpotlight().attemptsTo(SelectProductForCart.inPage(listDatos.get(0).get("menu"),listDatos.get(0).get("product")));
    }


}
