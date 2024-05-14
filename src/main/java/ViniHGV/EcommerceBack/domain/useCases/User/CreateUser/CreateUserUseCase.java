package ViniHGV.EcommerceBack.domain.useCases.User.CreateUser;

import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.domain.enums.UserRoleEnum;
import ViniHGV.EcommerceBack.domain.strategy.NewUserValidationStrategy;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.List;

@Service
@AllArgsConstructor
public class CreateUserUseCase implements  ICreateUserUseCase{

    private final UserRepository userRepository;
    private final List<NewUserValidationStrategy> newUserValidationStrategy;

    @Override
    public UserEntity execute(CreateUserRequestDTO createUserRequestDTO) {

        this.newUserValidationStrategy.forEach(validations ->
                validations.execute(createUserRequestDTO));

        UserEntity user = new UserEntity.UserEntityBuilder()
                .name(createUserRequestDTO.name())
                .email(createUserRequestDTO.email())
                .password(BCrypt.with(BCrypt.Version.VERSION_2Y)
                    .hashToString(6, createUserRequestDTO.password().toCharArray()))
                .userRoleEnum(UserRoleEnum.User)
                .build();

        return this.userRepository.save(user);
    }
}
