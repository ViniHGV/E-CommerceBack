package ViniHGV.EcommerceBack.domain.useCases.User.CreateUser;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;

public interface ICreateUserUseCase {
    public UserEntity execute(CreateUserRequestDTO createUserRequestDTO);
}
