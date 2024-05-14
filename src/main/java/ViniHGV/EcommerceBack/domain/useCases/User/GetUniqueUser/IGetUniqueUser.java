package ViniHGV.EcommerceBack.domain.useCases.User.GetUniqueUser;

import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;

public interface IGetUniqueUser {
    UserEntity execute(Integer id);
}
