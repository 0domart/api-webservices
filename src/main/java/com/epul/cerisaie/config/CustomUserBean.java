package com.epul.cerisaie.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.epul.cerisaie.domains.EntityUtilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomUserBean implements UserDetails {
    private static final long serialVersionUID = -4709084843450077569L;
    private String username;
    private String role;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    CustomUserBean(String username, String role, String password, Collection<? extends GrantedAuthority> authorities){
        this.username = username;
        this.role = role;
        this.password = password;
        this.authorities = authorities;
    }

    public static CustomUserBean createInstance(EntityUtilisateur user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        System.out.println(authorities);
        return new CustomUserBean(user.getNomUtil(),
                user.getRole(), user.getMotPasse(), authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof CustomUserBean) {
            return username.equals(((CustomUserBean) rhs).username);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}