package com.epul.cerisaie.domains;

import com.epul.cerisaie.config.CustomUserBean;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private String role;
    private String username;


    public JwtResponse(String jwttoken, CustomUserBean customUserBean) {
        this.jwttoken = jwttoken;
        this.role = customUserBean.getRole();
        this.username = customUserBean.getUsername();
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

}