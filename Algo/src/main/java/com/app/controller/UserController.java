package com.app.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.SessionExpiryHook;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.Quote;
import com.zerodhatech.models.User;


@Controller
@RequestMapping("/user")
public class UserController {


	
	public UserController() {
		System.out.println("In constructor " + getClass().getName());
	}
	
	//Request handling method to display the login page
	@GetMapping("/login")//Get method
	public String showLoginPage(@RequestParam String request_token, Model map) {
		System.out.println("In show LoginPage method");
		String message = "Connected from Zerodha";
		try {
		KiteConnect kiteSdk = new KiteConnect("nyqzyyx2xcq2cabo");

		// Set userId.
		kiteSdk.setUserId("HN0149");
		String url = kiteSdk.getLoginURL();

		// Get accessToken as follows,
		User userModel =  kiteSdk.generateSession(request_token, "gc6qwuta78ieu8yttpvz9il8n68fxo3t");

		// Set request token and public token which are obtained from login process.
		kiteSdk.setAccessToken(userModel.accessToken);
		kiteSdk.setPublicToken(userModel.publicToken);

		// Set session expiry callback.
		kiteSdk.setSessionExpiryHook(new SessionExpiryHook() {
		    @Override
		    public void sessionExpired() {
		        System.out.println("session expired");                    
		    }
		});
		
		getLTP(kiteSdk);
		getQuote(kiteSdk);
		map.addAttribute("message", request_token);
		
		return "/user/login";
		}catch(KiteException e) {
			System.out.println("In Exception" + e.getMessage());
			return "/user/login";
		}catch(Exception e) {
			System.out.println("In Exception" + e.getMessage());
			return "/user/login";
		}
	}
	
    /** Get quote for a scrip.*/
    public void getQuote(KiteConnect kiteConnect) throws KiteException, IOException {
        // Get quotes returns quote for desired trading symbol.
        String[] instruments = {"256265","NSE:INFY", "NSE:APOLLOTYRE", "NSE:NIFTY 50", "24507906"};
        Map<String, Quote> quotes = kiteConnect.getQuote(instruments);
        System.out.println(quotes.get("NSE:INFY").instrumentToken+"");
        System.out.println(quotes.get("NSE:INFY").oi +"");
        System.out.println(quotes.get("NSE:INFY").depth.sell.get(0).getPrice());
        System.out.println(quotes.get("NSE:INFY").depth.sell.get(0).getOrders());
        System.out.println(quotes.get("NSE:INFY").depth.sell.get(0).getQuantity());
        System.out.println(quotes.get("NSE:INFY").depth.buy.get(0).getPrice());
        System.out.println(quotes.get("NSE:INFY").lastTradedTime);
        System.out.println(quotes.get("NSE:INFY").lowerCircuitLimit+"");
        System.out.println(quotes.get("NSE:INFY").upperCircuitLimit+"");
        System.out.println(quotes.get("NSE:INFY").oiDayHigh);
        System.out.println(quotes.get("NSE:INFY").oiDayLow);
    }
    
    /** Get last price for multiple instruments at once.
     * USers can either pass exchange with tradingsymbol or instrument token only. For example {NSE:NIFTY 50, BSE:SENSEX} or {256265, 265}*/
    public void getLTP(KiteConnect kiteConnect) throws KiteException, IOException {
        String[] instruments = {"256265","BSE:INFY", "NSE:INFY", "NSE:NIFTY 50"};
        System.out.println(kiteConnect.getLTP(instruments).get("NSE:INFY").lastPrice);
    }
	

}
