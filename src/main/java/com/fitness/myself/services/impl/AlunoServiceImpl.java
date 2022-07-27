package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.AlunoDTO;
import com.fitness.myself.domain.DTO.PersonalDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.repositories.IAlunoRepository;
import com.fitness.myself.services.AlunoService;
import com.fitness.myself.services.PersonalService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl extends GenericServiceImpl<IAlunoRepository> implements AlunoService {

    @Autowired
    private PersonalService personalService;

    @Override
    public Aluno insert(Aluno entity) {
        return getRepository().save(entity);
    }

    @Override
    public Aluno findById(Long id) {
        Optional<Aluno> aluno = getRepository().findById(id);
        return aluno.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = findById(id);
        getRepository().delete(aluno);
    }

    @Override
    public void atribuirAluno(Long alunoId, Long personalId) {
        Personal personal = personalService.findById(personalId);
        Aluno aluno = findById(alunoId);

        aluno.atribuirPersonal(personal);
        getRepository().save(aluno);
    }

    @Override
    public List<AlunoDTO> findlAllAlunos() {
        List<Aluno> personalList = getRepository().findAll();
        return toAlunoListDTO(personalList);
    }

    @Override
    public AlunoDTO toAlunoDTO(Aluno aluno) {
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    @Override
    public Aluno toAluno(AlunoDTO alunoDTO) {
        return modelMapper.map(alunoDTO, Aluno.class);
    }

    private List<AlunoDTO> toAlunoListDTO(List<Aluno> alunoList) {
        return mapList(alunoList, AlunoDTO.class);
    }



}
