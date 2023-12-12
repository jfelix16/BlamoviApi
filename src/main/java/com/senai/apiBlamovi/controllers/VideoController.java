package com.senai.apiBlamovi.controllers;

import com.senai.apiBlamovi.dtos.UsuarioDto;
import com.senai.apiBlamovi.dtos.VideoDto;
import com.senai.apiBlamovi.models.UsuarioModel;
import com.senai.apiBlamovi.models.VideoModel;
import com.senai.apiBlamovi.repositories.UsuarioRepository;
import com.senai.apiBlamovi.repositories.VideoRepository;
import com.senai.apiBlamovi.services.FileUploadService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController

@CrossOrigin(origins = "*")

@RequestMapping(value = "/video", produces = {"application/json"})
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;


//    /*REQUISIÇÃO SEM IMAGEM*/
//@RequestMapping
//@PostMapping
//public ResponseEntity<Object> criarVideo(@RequestBody @Valid VideoDto VideoDto){
//       if (VideoRepository.findByImagem(VideoDto.Imagem()) != null) {
//          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Imagem já cadastrada no sistema");
//      }
//
//       VideoModel VideoModel = new VideoModel();
//       BeanUtils.copyProperties(VideoDto,VideoModel);
//
//       return ResponseEntity.status(HttpStatus.CREATED).body(VideoRepository.save(VideoModel));
//   }

    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<VideoModel>> listarVideo() {
        return ResponseEntity.status(HttpStatus.OK).body(videoRepository.findAll());
    }

    @GetMapping("/{idVideo}")
    public ResponseEntity<Object> buscarVideoId(@PathVariable(value = "idVideo") UUID id) {
        Optional<VideoModel> videoBuscado = videoRepository.findById(id);

        if (videoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(videoBuscado.get());
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> cadastrarVideo(@ModelAttribute @Valid VideoDto dadosRecebidos) {
        if (videoRepository.findByTitulo(dadosRecebidos.titulo()) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Titulo ja Cadastrado");
        }


        VideoModel novoVideo = new VideoModel();
        BeanUtils.copyProperties(dadosRecebidos, novoVideo);

        String urlImagem;

        try{
            urlImagem = fileUploadService.fazerUpload(dadosRecebidos.imagem());

        }catch (IOException erro){
            throw new RuntimeException(erro);
        }

        novoVideo.setImagem(urlImagem);

        return ResponseEntity.status(HttpStatus.OK).body(videoRepository.save(novoVideo));
    }

    @PutMapping(value = "/{idVideo}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object>editarVideo(@PathVariable(value = "idVideo") UUID id,@RequestBody @Valid VideoDto videoDto){
        Optional<VideoModel> videoBuscado = videoRepository.findById(id);

        if (videoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado");
        }
        VideoModel videoModel = videoBuscado.get();
        BeanUtils.copyProperties(videoDto,videoModel);

        String urlImagem;

        try{
            urlImagem = fileUploadService.fazerUpload(videoDto.imagem());

        }catch (IOException erro){
            throw new RuntimeException(erro);
        }

        videoModel.setImagem(urlImagem);



        return ResponseEntity.status(HttpStatus.OK).body(videoRepository.save(videoModel));
    }



    @DeleteMapping("/{idVideo}")
    public ResponseEntity<Object> deletarVideo(@PathVariable(value = "idVideo") UUID id){
        Optional<VideoModel> videoBuscado = videoRepository.findById(id);

        if (videoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado");
        }
        videoRepository.delete(videoBuscado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Video Deletado!");
    }
}


//Criptografa senha
//        String senhaCript = new BCryptPasswordEncoder().encode(usuarioDto.senha());
//        novoUsuario.setSenha(senhaCript);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(novoUsuario));
//    }

//   @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//   @Operation(summary = "Método para cadastrar um Video", method = "POST")
//    @ApiResponses(value = {
//           @ApiResponse(responseCode = "201", description = "Video Cadastrado com sucesso"),
//            @ApiResponse(responseCode = "400", description = "Paramatros inválidos")
//   })
//   public ResponseEntity<Object> criarVideo(@ModelAttribute @Valid VideoDto videoDto){
//        if (videoRepository.findByTitulo(videoDto.titulo()) != null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Imagem já cadastrado");
//        }

//
//        VideoModel novoVideo = new VideoModel();
//        BeanUtils.copyProperties(usuarioDto, novo@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//        @Operation(summary = "Método para cadastrar um Usuário", method = "POST")
//        @ApiResponses(value = {
//                @ApiResponse(responseCode = "201", description = "Cadastro foi efetuado com sucesso"),
//                @ApiResponse(responseCode = "400", description = "Paramatros inválidos")
//        })
//        public ResponseEntity<Object> criarUsuario(@ModelAttribute @Valid UsuarioDto usuarioDto){
//            if (videoRepository.findByImagem(usuarioDto.email()) != null){
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
//            }
//
//            UsuarioModel novoUsuario = new UsuarioModel();
//            BeanUtils.copyProperties(usuarioDto, novoUsuario);
//
//            String urlImagem;
//
//            try{
//                urlImagem = fileUploadService.fazerUpload(usuarioDto.imagem());
//            }catch (IOException e){
//                throw new RuntimeException(e);
//            }Video);
//
//        String urlImagem;
//
//        try{
//            urlImagem = fileUploadService.fazerUpload(VideoDto.imagem());
//        }catch (IOException e){
//            throw new RuntimeException(e);
//        }
//            @DeleteMapping("/{idVideo}")
//            public ResponseEntity<Object> deletarVideo(@PathVariable(value = "idVideo") UUID id){
//                Optional<VideoModel> videoBuscado = usuarioRepository.findById(id);
//
//                if (usuarioBuscado.isEmpty()) {
//                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
//                }
//                usuarioRepository.delete(usuarioBuscado.get());
//                return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso!");
//            }

//}
