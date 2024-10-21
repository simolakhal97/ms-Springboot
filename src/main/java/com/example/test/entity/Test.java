package com.example.test.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Test implements UserDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long oid;
    private String name;
    private String email;
    private String password;
    private Long age;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())); // Assuming role is an enum
    }

    @Override
    public String getPassword() {
        return password; // your password field
    }

    @Override
    public String getUsername() {
        return email; // assuming email is used as username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // or your logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // or your logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // or your logic
    }

    @Override
    public boolean isEnabled() {
        return true; // or your logic
    }
}
