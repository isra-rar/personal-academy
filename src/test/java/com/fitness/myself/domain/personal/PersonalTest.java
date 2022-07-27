package com.fitness.myself.domain.personal;

import com.fitness.myself.domain.enums.UF;
import com.fitness.myself.domain.valuesObjects.CPF;
import com.fitness.myself.domain.valuesObjects.Email;
import com.fitness.myself.domain.valuesObjects.Telefone;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static com.fitness.myself.domain.util.FakerSingleton.getInstace;
import static org.junit.jupiter.api.Assertions.fail;

@AutoConfigureMockMvc
class PersonalTest {


    @Test
    void createPersonalSucess() {
        fail();
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