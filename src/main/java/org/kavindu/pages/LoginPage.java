package org.kavindu.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    private String txtUsername = "[name='username']";
    private String txtPassword = "[name='password']";
    private String btnLogin = "//button[text()=' Login ']";
    private String login_error_message = "//*[text()='Invalid credentials']";

    public void loginPage(String username , String password){
        page.fill(txtUsername , username);
        page.fill(txtPassword , password);
        page.click(btnLogin);
    }

    public String getLoginErrorMessage(){
        return page.locator(login_error_message).textContent();
    }
}
