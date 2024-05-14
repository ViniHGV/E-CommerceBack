package ViniHGV.EcommerceBack.domain.strategy.impl;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.strategy.NewUserValidationStrategy;
import org.springframework.stereotype.Component;

@Component
public class PasswordLengthValidationImpl implements NewUserValidationStrategy
{
    @Override
    public void execute(CreateUserRequestDTO createUserRequestDTO) {
        if(createUserRequestDTO.password().length() < 8)
            throw new NullPointerException("A senha deve conter no minímo 8 caracteres!");
    }
}
