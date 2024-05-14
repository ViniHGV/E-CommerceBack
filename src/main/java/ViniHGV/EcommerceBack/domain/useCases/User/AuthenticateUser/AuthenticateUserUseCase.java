package ViniHGV.EcommerceBack.domain.useCases.User.AuthenticateUser;

import ViniHGV.EcommerceBack.application.dtos.user.AuthenticateRequest;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticateUserUseCase implements  IAuthenticateUserUseCase{

    private final UserRepository userRepository;

    public String execute(AuthenticateRequest authenticateRequest) {
        UserEntity userByEmail = this.userRepository.findByEmail(authenticateRequest.email()).orElseThrow(()->
                new RuntimeException("E-mail inserido não existe!"));

        Boolean passwordIsEqual = BCrypt.verifyer().verify(
                    authenticateRequest.password().toCharArray(),
                    userByEmail.getPassword()
                ).verified;

        if (!passwordIsEqual)
            throw new RuntimeException("A Senha está incorreta!");

        return "Usuário logado com sucesso!";
    }
}
