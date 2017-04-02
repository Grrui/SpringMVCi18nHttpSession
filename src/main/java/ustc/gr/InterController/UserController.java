package ustc.gr.InterController;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


@Controller
public class UserController {
	@RequestMapping(value="/{formName}")
	public String loginForm(
			@PathVariable String formName,
			String request_locale,
			Model model,
			HttpServletRequest request){
		System.out.println("request_locale:" + request_locale);
		if (request_locale != null){
			if (request_locale.equals("zh_CN")){
				Locale locale = new Locale("zh","CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
			}else if (request_locale.equals("en_US")){
				Locale locale = new Locale("en","US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);

			}else{
				//使用之前的语言环境
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
			}
		}
		User user = new User();
		model.addAttribute("user", user);
		return formName;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@ModelAttribute @Validated User user,
			Model model,
			HttpServletRequest request){
		System.out.println("222222w2");
		if(user.getLoginname().equals("gr")&&user.getPassword().equals("123")){
			RequestContext requestContext = new RequestContext(request);
			String username=requestContext.getMessage("username");
			user.setUsername(username);
			model.addAttribute("user",user);
			return "success";
		}
		return "error";
	}
}
