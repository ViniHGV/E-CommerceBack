package ViniHGV.EcommerceBack.domain.strategy;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;

public interface NewUserValidationStrategy {
    void execute(CreateUserRequestDTO createUserRequestDTO);
}
