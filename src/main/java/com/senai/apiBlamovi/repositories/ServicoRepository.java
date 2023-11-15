package com.senai.apiBlamovi.repositories;

import com.senai.apiBlamovi.models.ServicoModel;
import com.senai.apiBlamovi.models.ServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoModel, UUID> {
}