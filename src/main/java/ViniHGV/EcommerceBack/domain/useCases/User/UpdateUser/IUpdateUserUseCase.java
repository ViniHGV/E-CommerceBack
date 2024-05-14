package ViniHGV.EcommerceBack.domain.useCases.User.UpdateUser;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;

public interface IUpdateUserUseCase {
    UserEntity execute(Integer id, CreateUserRequestDTO createUserRequestDTO);
}
