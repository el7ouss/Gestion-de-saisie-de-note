package tn.rnu.isetsf.accessHandler;


import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/*public class MySpecialAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	 
	    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
	                                        HttpServletResponse httpServletResponse,
	                                        Authentication authentication)
	            throws IOException, ServletException {
	        //do some logic here if you want something to be done whenever
	        //the user successfully logs in.

	        HttpSession session = httpServletRequest.getSession();
	        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        session.setAttribute("username", authUser.getUsername());
	        session.setAttribute("authorities", authentication.getAuthorities());

	        //set our response to OK status
	        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

	        //since we have created our custom success handler, its up to us to where
	        //we will redirect the user after successfully login
	        httpServletResponse.sendRedirect("/CustomLoginPageHouss/secure/home.jsf");
	    }
	}
*/
public class MySpecialAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    protected Log logger = LogFactory.getLog(this.getClass());
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
 
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    /** Builds the target URL according to the logic defined in the main class Javadoc. */
    protected String determineTargetUrl(Authentication authentication) {
        boolean isEnseignant = false;
        boolean isAdmin = false;
        boolean isEtudiant = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
        	//System.out.println(grantedAuthority.getAuthority());
            if (grantedAuthority.getAuthority().equals("role_enseignant")) {
                isEnseignant = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("role_admin")) {
                isAdmin = true;
                break;
            } if (grantedAuthority.getAuthority().equals("role_etudiant")) {
                isEtudiant = true;
                break;
            }
        }
 
        if (isEnseignant) {
            return "/secure_enseignant/enseignant.jsf";
        } else if (isAdmin) {
            return "/secure_admin/admin.jsf";
        } else if (isEtudiant) {
            return "/secure_etudiant/etudiant.jsf";
        } else {
            throw new IllegalStateException();
        }
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}