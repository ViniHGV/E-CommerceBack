package ViniHGV.EcommerceBack.domain.strategy.impl;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.strategy.NewUserValidationStrategy;
import org.springframework.stereotype.Component;

@Component
public class EmailIsNotEmptyValidationImpl implements NewUserValidationStrategy {
    @Override
    public void execute(CreateUserRequestDTO createUserRequestDTO) {
        if(createUserRequestDTO.email().isEmpty())
            throw new NullPointerException("É obrigatório informar o campo E-mail!");
    }
}
