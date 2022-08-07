package com.fitness.myself.core;

import com.fitness.myself.domain.DTO.response.AlunoResponseDTO;
import com.fitness.myself.domain.aluno.Aluno;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(Aluno.class, AlunoResponseDTO.class)
                .<String>addMapping(src -> src.getPersonal().getUsuario().getNome(),
                        (dest,value) -> dest.setNomePersonal(value));

        return mapper;
    }
}
