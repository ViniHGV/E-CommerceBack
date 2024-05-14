package ViniHGV.EcommerceBack.domain.useCases.User.ListUsers;

import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;

import java.util.List;

public interface IListUsersUseCase {
    public List<UserEntity> execute();
}
