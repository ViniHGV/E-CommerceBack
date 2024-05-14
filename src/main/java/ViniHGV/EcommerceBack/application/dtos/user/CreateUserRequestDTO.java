package ViniHGV.EcommerceBack.application.dtos.user;

import ViniHGV.EcommerceBack.domain.enums.UserRoleEnum;

public record CreateUserRequestDTO(
     String name,
     String email,
     String password
) {
}
