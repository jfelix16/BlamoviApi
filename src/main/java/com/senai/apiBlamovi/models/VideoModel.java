package com.senai.apiBlamovi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.*;
import java.io.Serializable;
import java.io.Serial;
import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_video")
public class VideoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_video", nullable = false)
    private UUID id;

    private String titulo;
    private String elenco;
    private String genero;
    private String classificacao;
    private String diretor;
    private String sinopse;
    private String temporada;
    private String imagem;
    private String duracao;
    private Integer ano;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }

//    public class FilmeModel extends VideoModel {
//
//
//    }

//    public class SerieModel extends VideoModel {
//        private int temporada;
//        private int episodio;
//
//    }

    //@JsonIgnore
    // private String senha;

    //private String url_img;


    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //    return null;
    // }

    //  @Override
    //  public String getPassword() {
    //   return senha;
    //  }

    // @Override
    // public String getUsername() {
    //   return null;
    // }

    //@Override
    //public String getUsername() {
    //   return email;
    //}

    // @Override
    //  public boolean isAccountNonExpired() {
    //   return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //   return true;
    //  }

    //  @Override
    // public boolean isCredentialsNonExpired() {
    //   return true;
    // }

    //  @Override
    // public boolean isEnabled() {
    //     return true;
    //  }
}