package ViniHGV.EcommerceBack.domain.strategy.impl;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.domain.strategy.NewUserValidationStrategy;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ExistingEmailValidationImpl implements NewUserValidationStrategy {

    private final UserRepository userRepository;
    @Override
    public void execute(CreateUserRequestDTO createUserRequestDTO) {
        if(this.EmailExists(createUserRequestDTO.email()).isPresent())
            throw new RuntimeException("Já existe um usuário com esse E-mail!");
    }

    private Optional<UserEntity> EmailExists(String email){
       return this.userRepository.findByEmail(email);
    }

}
