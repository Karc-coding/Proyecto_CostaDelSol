package com.store.app.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.security.AuthenticationRequest;
import com.store.app.security.AuthenticationResponse;
import com.store.app.security.JwtService;
import com.store.app.service.MyUserDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

	private final AuthenticationManager authenticationManager;
	private final MyUserDetailsService myUserDetailService;
	private final JwtService jwtService;

	@PostMapping("/login")
	public AuthenticationResponse createToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword());
			authenticationManager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid username or password", e);
		}
		UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		String token = jwtService.createToken(userDetails);
		return new AuthenticationResponse(token);
	}
	
	@GetMapping("/test")
    public String getTest(){
        return "test";
    }

}
