/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.web;

import ec.com.espe.distribuidas.perionet.servicio.UsuarioServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author carlo
 */
@ViewScoped
@ManagedBean
public class LoginMB implements Serializable {

    private String nick;
    private String clave;

    @EJB
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {

    }

    public String login() {
        System.out.println("verificando el login");
        if (usuarioServicio.login(nick, clave)) {
            System.out.println("accedio");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("...", "Bienvenido al Sistema Perionet"));
            return "indexAdmin";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("...", "Los datos son incorrectos"));
            System.out.println("no accedio");
            return "login";
        }
        
    }

    ///////////////// METODOS GET AND SET/////////////////
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
