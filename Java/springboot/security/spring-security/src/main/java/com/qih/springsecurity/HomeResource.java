package com.qih.springsecurity;

import com.qih.springsecurity.services.MyUserDetailsService;
import com.qih.springsecurity.util.JwtUtil;
import models.AuthenticationRequest;
import models.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @RequestMapping("/user")
    public String user() {
        return ("<h1>Welcome user</h1>");
    }

    @RequestMapping("/admin")
    public String admin() {
        return ("<h1>Welcome admin</h1>");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // do authentication
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch(BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }
        // generate userDetails
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        // generate JWT token
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        // respond with JWT token
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
