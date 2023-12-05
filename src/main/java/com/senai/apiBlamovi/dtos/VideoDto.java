package com.senai.apiBlamovi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;
import org.springframework.web.multipart.MultipartFile;

public record VideoDto(
        @NotBlank String titulo,

        @NotBlank  String elenco,

        @NotBlank String genero,

        @NotBlank  String classificacao,

        @NotNull String diretor,

        String sinopse,

       String temporada,

       MultipartFile imagem,

        @NotBlank String duracao,

        int ano
) {
}
