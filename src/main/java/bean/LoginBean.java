/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import models.Account;
import service.AccountService;
import utils.RedirectUtil;

/**
 * @RequestScope: Beans are created for the duration of the request
 * @author teren
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    private AccountService accountService;
    @Inject
    private SessionBean sessionBean;

    private String username;
    private String password;

    public void init() {
    }

    public void login() {
        String username = this.username.toLowerCase();

        System.out.println(username);
        System.out.println(password);
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(username, this.password);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        Account user = this.accountService.findByUsername(request.getRemoteUser());
        sessionBean.setLoggedInUser(user);

        boolean isRegular = request.isUserInRole("regular_role");
        boolean isAdmin = request.isUserInRole("admin_role");

        if (isRegular) {
            RedirectUtil.redirect("/pages/profile/profile.xhtml");
        } else if (isAdmin) {
            RedirectUtil.redirect("/pages/admin/admin.xhtml");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
