package co.com.technicalnormsoft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import co.com.technicalnormsoft.model.Usuario;
import co.com.technicalnormsoft.model.control.IUsuarioLogic;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Silicon Cali
 * 
 *
 */
@Scope("singleton")
@Component("tnsAuthenticationProvider")
public class TnsAuthenticationProvider implements AuthenticationProvider {
	/**
	 * Security Implementation
	 */
	@Autowired
	private IUsuarioLogic usuarioLogic;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		try {
			Usuario usuario = usuarioLogic.findUsuarioByEmail(name);

			if (usuario != null && usuario.getPassword().equals(password)) {
				final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

				final UserDetails principal = new User(name, password, grantedAuths);
				final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
						password, grantedAuths);

				return auth;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
