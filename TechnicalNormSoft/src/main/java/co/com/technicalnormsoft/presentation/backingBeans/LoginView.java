package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.technicalnormsoft.utilities.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
    private String userId;
    private String password;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    private HttpSession httpSession;

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
                    this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(result);

            FacesUtils.getHttpSession(true)
                      .setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            
            httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            httpSession.setAttribute("usuarioEmail", userId);
        } catch (Exception e) {
            FacesUtils.addErrorMessage("login o password incorrecto");

            return "/login.xhtml";
        }
        try {
        	FacesContext context = FacesContext.getCurrentInstance();
    		HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    		String contextPath = origRequest.getContextPath();
    		context.getExternalContext().redirect(contextPath + "/XHTML/listadoEstablecimiento.xhtml");
		} catch (IOException e) {
			FacesUtils.addErrorMessage("Algo malo acurrió :(");
		}
        return "";
    }
}
