package br.com.reciclahub.security;

import br.com.reciclahub.model.Empresa;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final Empresa empresa;

    public UserDetailsImpl(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Long getIdEmpresa() {
        return empresa.getIdEmpresa();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String tipo = empresa.getTipo() == null ? "EMPRESA" : empresa.getTipo().toUpperCase();
        return List.of(new SimpleGrantedAuthority("ROLE_" + tipo));
    }

    @Override
    public String getPassword() {
        return empresa.getSenha();
    }

    @Override
    public String getUsername() {
        return empresa.getEmail();
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
}
