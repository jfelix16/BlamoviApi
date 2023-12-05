package com.senai.apiBlamovi.repositories;

import com.senai.apiBlamovi.models.UsuarioModel;
import com.senai.apiBlamovi.models.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel, UUID> {
    VideoModel findByTitulo(String titulo);
}

