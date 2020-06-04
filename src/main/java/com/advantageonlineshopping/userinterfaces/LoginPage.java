package com.advantageonlineshopping.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static  final Target BTN_LOGIN = Target.the("BOTON LOGIN").located(By.id("menuUser"));
    public static  final Target FIELD_USER = Target.the("login field").located(By.name("username"));
    public static  final Target FIELD_PASS = Target.the("password field").located(By.name("password"));
    public static  final Target BTN_SING_IN = Target.the("password field").located(By.id("sign_in_btnundefined"));
    public static  final Target USER_NAME = Target.the("password field").locatedBy("//*[@id='menuUserLink']/span");
    public static  final Target BTN_TABLE = Target.the("Boton table").located(By.id("tabletsTxt"));
    public static  final Target BTN_SPEKEARS= Target.the("Boton table").located(By.id("speakersTxt"));
    public static  final Target PRODUCT= Target.the("Producto").locatedBy("//a[contains(text(),'{0}')]");
    public static  final Target BTN_ADD_CAR= Target.the("Producto").located(By.name("save_to_cart"));



}
