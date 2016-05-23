/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.servicio;

import ec.com.espe.distribuidas.perionet.facade.UsuarioFacade;
import ec.com.espe.distribuidas.perionet.modelo.Usuario;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@LocalBean
@Stateless
public class UsuarioServicio 
{
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    
    public boolean login(String nick, String clave)
    {
        
        Usuario usuario=usuarioFacade.login(nick, clave);
        if(usuario==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
