package foodtruck.helpers;

import foodtruck.pages.EmailLoginPage;
import foodtruck.pages.PhoneLoginPage;
import foodtruck.pages.WelcomePage;

/**
 * @author Michelle
 */
public class UserLoginHelper {

    public void validUserLogin(String email, String password) {
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickLoginButton();
        PhoneLoginPage phoneLoginPage = new PhoneLoginPage();
        phoneLoginPage.clickLoginWithEmail();
        EmailLoginPage emailLoginPage = new EmailLoginPage();
        emailLoginPage.loginWithEmail(email, password);
    }
}
