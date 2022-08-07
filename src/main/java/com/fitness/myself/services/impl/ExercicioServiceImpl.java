package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.response.ExercicioDTO;
import com.fitness.myself.domain.treino.Exercicio;
import com.fitness.myself.repositories.ExercicioRepository;
import com.fitness.myself.services.ExercicioService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioServiceImpl extends GenericServiceImpl<ExercicioRepository> implements ExercicioService {


    public ExercicioServiceImpl(ExercicioRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Exercicio insert(Exercicio entity) {
        return getRepository().save(entity);
    }

    @Override
    public Exercicio findById(Long id) {
        Optional<Exercicio> exercicio = getRepository().findById(id);
        return exercicio.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Exercicio exercicio = findById(id);
        getRepository().delete(exercicio);
    }

    @Override
    public ExercicioDTO toExercicioDTO(Exercicio exercicio) {
        return modelMapper.map(exercicio, ExercicioDTO.class);
    }

    @Override
    public Exercicio toExercicio(ExercicioDTO alunoDTO) {
        return modelMapper.map(alunoDTO, Exercicio.class);
    }

    @Override
    public List<ExercicioDTO> findlAllExercicios() {
        List<Exercicio> personalList = getRepository().findAll();
        return toExercicioListDTO(personalList);
    }

    private List<ExercicioDTO> toExercicioListDTO(List<Exercicio> exercicioList) {
        return mapList(exercicioList, ExercicioDTO.class);
    }

}
