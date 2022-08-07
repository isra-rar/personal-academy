package com.fitness.myself.services.impl;

import com.fitness.myself.domain.DTO.request.AlunoRequestDTO;
import com.fitness.myself.domain.DTO.response.AlunoResponseDTO;
import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.aluno.FichaPessoal;
import com.fitness.myself.domain.enums.TipoPlano;
import com.fitness.myself.domain.personal.Personal;
import com.fitness.myself.domain.usuario.Usuario;
import com.fitness.myself.repositories.AlunoRepository;
import com.fitness.myself.services.AlunoService;
import com.fitness.myself.services.PersonalService;
import com.fitness.myself.services.UsuarioService;
import com.fitness.myself.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl extends GenericServiceImpl<AlunoRepository> implements AlunoService {

    private final PersonalService personalService;
    private final UsuarioService usuarioService;

    public AlunoServiceImpl(AlunoRepository repository, ModelMapper modelMapper, PersonalService personalService, UsuarioService usuarioService) {
        super(repository, modelMapper);
        this.personalService = personalService;
        this.usuarioService = usuarioService;
    }

    @Override
    public AlunoResponseDTO insertAluno(AlunoRequestDTO alunoRequestDTO) {
        Personal personal = personalService.findById(alunoRequestDTO.getPersonalId());
        Usuario usuario = usuarioService.findById(alunoRequestDTO.getUsuarioId());

        Aluno aluno = toAluno(alunoRequestDTO);
        aluno.atribuirPersonal(personal);
        aluno.atribuirUsuario(usuario);
        getRepository().save(aluno);
        return toAlunoDTO(aluno);
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
    public List<AlunoResponseDTO> findlAllAlunos() {
        List<Aluno> personalList = getRepository().findAll();
        return toAlunoListDTO(personalList);
    }

    @Override
    public AlunoResponseDTO toAlunoDTO(Aluno aluno) {
        return modelMapper.map(aluno, AlunoResponseDTO.class);
    }

    private Aluno toAluno(AlunoRequestDTO alunoDTO) {
        return new Aluno(alunoDTO.getNomeAcademia(),
                TipoPlano.valueOf(alunoDTO.getTipoPlano()),
                new FichaPessoal(alunoDTO.getFichaPessoal().getDataNascimento(),
                        alunoDTO.getFichaPessoal().getSexo(),
                        alunoDTO.getFichaPessoal().getPeso(),
                        alunoDTO.getFichaPessoal().getAltura(),
                        alunoDTO.getFichaPessoal().getObjetivo()));
    }

    private List<AlunoResponseDTO> toAlunoListDTO(List<Aluno> alunoList) {
        return mapList(alunoList, AlunoResponseDTO.class);
    }



}
