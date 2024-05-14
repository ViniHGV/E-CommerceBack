package ViniHGV.EcommerceBack.domain.strategy.impl;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.strategy.NewUserValidationStrategy;
import org.springframework.stereotype.Component;

@Component
public class NameIsNotEmptyValidationImpl implements NewUserValidationStrategy {
    @Override
    public void execute(CreateUserRequestDTO createUserRequestDTO) {
        if(createUserRequestDTO.name().isEmpty())
            throw new NullPointerException("É obrigatório informar nome do usuário!");
    }
}
