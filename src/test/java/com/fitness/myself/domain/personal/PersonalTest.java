package com.fitness.myself.domain.personal;

import com.fitness.myself.domain.aluno.Aluno;
import com.fitness.myself.domain.enums.UF;
import com.fitness.myself.domain.util.FakerSingleton;
import com.fitness.myself.domain.valuesObjects.CPF;
import com.fitness.myself.domain.valuesObjects.Email;
import com.fitness.myself.domain.valuesObjects.Telefone;
import com.fitness.myself.repositories.IPersonalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.fitness.myself.domain.util.FakerSingleton.getInstace;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
class PersonalTest {


    @Test
    void createPersonalSucess() {
        fail();
    }

    @Test
    void adicionarAlunoPersonalSucesso() {
        Personal personal = createPersonal();
        personal.addAluno(mock(Aluno.class));

        Assertions.assertEquals(personal.getAlunos().size(), 1);
    }

    @Test
    void adicionarAlunoInvalidoPersonal() {
        Personal personal = createPersonal();
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
                () -> personal.addAluno(null));

        assertEquals("Aluno invalido", result.getMessage());
    }

    public Personal createPersonal() {
        return new Personal.PersonalBuilder()
                .nome(getInstace().name().fullName())
                .cpf(new CPF(getInstace().cpf().valid()))
                .email(new Email(getInstace().internet().emailAddress()))
                .telefone(new Telefone("(83)996134740"))
                .password(getInstace().internet().password())
                .cref(new CREF(UF.PB, getInstace().number().digits(4)))
                .build();
    }
}