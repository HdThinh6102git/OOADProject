package com.hcmute.edu.vn.OronProject.api;

import com.hcmute.edu.vn.OronProject.config.JwtUtils;
import com.hcmute.edu.vn.OronProject.api.output.AuthenticationErrOutput;
import com.hcmute.edu.vn.OronProject.api.output.AuthenticationOutput;
import com.hcmute.edu.vn.OronProject.dto.AuthenticationRequestDTO;
import com.hcmute.edu.vn.OronProject.dto.CustomUserDetails;
import com.hcmute.edu.vn.OronProject.dto.UserDTO;
import com.hcmute.edu.vn.OronProject.service.impl.CustomUserDetailsService;
import com.hcmute.edu.vn.OronProject.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationAPI {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final UserService userService;
    private final JwtUtils jwtUtils;
    private void setValuesAuthenticationOutput(AuthenticationOutput output,UserDTO userInfor ){
        output.setUserName(userInfor.getUserName());
        output.setDisplayName(userInfor.getDisplayName());
        output.setAddress(userInfor.getAddress());
        output.setPhoneNumber(userInfor.getPhoneNumber());
        output.setEmailAddress(userInfor.getEmailAddress());
        output.setProfilePic(userInfor.getProfilePic());
        output.setCoverPic(userInfor.getCoverPic());
        output.setStatus(userInfor.getStatus());
        output.setId(userInfor.getId());

    }
    private void setResponseCookie(Cookie cookie){
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
    }

    @PostMapping("/authenticate")
    public Object authenticate(@RequestBody AuthenticationRequestDTO request,
                               HttpServletResponse response){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
        );
        final CustomUserDetails user = userDetailsService.loadUserByUsername(request.getUserName());
        final UserDTO userInfor = userService.loadUserByUserName(request.getUserName());

        if(user != null ){
            //generate access token
            String accessToken = jwtUtils.generateToken(user);
            //add cookie to response
            ResponseCookie cookie = ResponseCookie.from("accessToken", accessToken)
                    .httpOnly(true)
                    .sameSite("None")
                    .secure(true)
                    .path("/")
                    .maxAge(7 * 24 * 60 * 60)
                    .build();
            response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

            //set output of api
            AuthenticationOutput output = new AuthenticationOutput();
            setValuesAuthenticationOutput(output, userInfor);
            output.setAccessToken(accessToken);
            return output;
        }
        // return error
        AuthenticationErrOutput error = new AuthenticationErrOutput();
        error.setCode(401);
        error.setMessage("Unauthorized");
        return error;

    }
    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletResponse response){
        //delete cookie
        ResponseCookie cookie = ResponseCookie.from("accessToken", null)
                .secure(true)
                .maxAge(0)
                .sameSite("None")
                .build();
        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.status(200).body("User has been logged out");
    }

}
