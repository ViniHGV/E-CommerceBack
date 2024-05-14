package ViniHGV.EcommerceBack.domain.strategy.impl;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.application.utils.EmailValidator;
import ViniHGV.EcommerceBack.domain.strategy.NewUserValidationStrategy;
import org.springframework.stereotype.Component;

@Component
public class EmailIsValidValidationImpl implements NewUserValidationStrategy {
    @Override
    public void execute(CreateUserRequestDTO createUserRequestDTO) {
        if(!EmailValidator.isValidEmail(createUserRequestDTO.email()))
            throw new RuntimeException("O E-mail informado é inválido!");
    }
}
