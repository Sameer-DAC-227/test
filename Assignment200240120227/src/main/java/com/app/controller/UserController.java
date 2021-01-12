package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	private static final String authorizationRequestBaseUri = "oauth2/authorize-client";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
	
	public UserController() {
		System.out.println("In default constructor : " + getClass().getName());
	}
	
	@GetMapping("/signup")
	public String showSignupForm(Model modelMap, HttpSession session) {
		modelMap.addAttribute("user", session.getAttribute("user"));
		return "/user/signup";
	}

	@PostMapping("/signup")
	public String addUser(@ModelAttribute (name = "user") User u, RedirectAttributes flashMap) {
		String message = service.saveUser(u);
		flashMap.addFlashAttribute("message", message);
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model, OAuth2AuthenticationToken authentication, 
											RedirectAttributes flashMap, HttpSession session) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        String email = null;
        String name = null;
        String userInfoEndpointUri = client.getClientRegistration()
            .getProviderDetails()
            .getUserInfoEndpoint()
            .getUri();

        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                .getTokenValue());

            HttpEntity<String> entity = new HttpEntity<String>("", headers);

            ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttributes = response.getBody();
            System.out.println("Name : " + userAttributes.get("name"));
            model.addAttribute("name", userAttributes.get("name"));
            name = (String)userAttributes.get("name");
            System.out.println("Name : " + userAttributes.get("email"));
            email = (String)userAttributes.get("email");
            model.addAttribute("email", userAttributes.get("email"));
        }
        String message = "Successfully logged in";
		User user = null;
		try {
		user = service.validateUser(email);
		}catch(Exception e) {
			user = new User(name,email);
			session.setAttribute("user", user);
			flashMap.addFlashAttribute("message", message);
			return "redirect:/user/signup";			
		}
		if(user==null) {
			user = new User(name,email);
			session.setAttribute("user", user);
			flashMap.addFlashAttribute("message", message);
			return "redirect:/user/signup";			
		}else {
			session.setAttribute("user", user);
			flashMap.addFlashAttribute("message", message);
			return "redirect:/flight/search";			
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, RedirectAttributes flashMap, HttpSession session) {
		String message = "Successfully logged in";
		User user = null;
		try {
			user = service.validateUser(email);
		}catch(Throwable e) {
			message = "Invalid email/password. Please try again";
			flashMap.addFlashAttribute("message", message);
			return "redirect:/user/login";			
		}
		if(user==null) {
			message = "Invalid email/password. Please try again";
			flashMap.addFlashAttribute("message", message);
			return "redirect:/user/signup";			
		}else {
			session.setAttribute("user", user);
			flashMap.addFlashAttribute("message", message);
			return "redirect:/flight/search";			
		}
	}
}
