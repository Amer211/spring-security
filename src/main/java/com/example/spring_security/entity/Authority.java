package com.example.spring_security.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorityId;

    @Column(name = "authority", nullable = false, unique = true)
    private String authority;


    public Authority() {
    }

    public Authority(Long authorityId, String authority) {
        this.authorityId = authorityId;
        this.authority = authority;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    @Override
    public String getAuthority() {
        return "";
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(authorityId, authority1.authorityId) && Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityId, authority);
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityId=" + authorityId +
                ", authority='" + authority + '\'' +
                '}';
    }
}
