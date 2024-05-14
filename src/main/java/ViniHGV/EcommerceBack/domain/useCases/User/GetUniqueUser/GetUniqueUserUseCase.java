package ViniHGV.EcommerceBack.domain.useCases.User.GetUniqueUser;

import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUniqueUserUseCase implements  IGetUniqueUser{

    private final UserRepository userRepository;

    public UserEntity execute(Integer id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário inválido!"));
    }
}
