package ViniHGV.EcommerceBack.domain.useCases.User.UpdateUser;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCase implements  IUpdateUserUseCase{

    private final UserRepository userRepository;

    public UserEntity execute(Integer id, CreateUserRequestDTO createUserRequestDTO) {
        UserEntity userById = this.userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário inválido!")
        );

        if(!createUserRequestDTO.name().isEmpty())
            userById.setName(createUserRequestDTO.name());

        if(!createUserRequestDTO.password().isEmpty())
            userById.setPassword(createUserRequestDTO.password());

        if(!createUserRequestDTO.email().isEmpty())
            userById.setEmail(createUserRequestDTO.email());

        return this.userRepository.save(userById);
    }
}
