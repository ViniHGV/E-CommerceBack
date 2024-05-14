package ViniHGV.EcommerceBack.domain.useCases.User.AuthenticateUser;

import ViniHGV.EcommerceBack.application.dtos.user.AuthenticateRequest;

public interface IAuthenticateUserUseCase {
    public String execute(AuthenticateRequest authenticateRequest);
}
