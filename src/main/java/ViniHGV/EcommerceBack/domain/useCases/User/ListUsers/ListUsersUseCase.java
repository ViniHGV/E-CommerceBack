package ViniHGV.EcommerceBack.domain.useCases.User.ListUsers;

import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListUsersUseCase implements IListUsersUseCase{

    private final UserRepository userRepository;

    public List<UserEntity> execute() {
        return this.userRepository.findAll();
    }
}
