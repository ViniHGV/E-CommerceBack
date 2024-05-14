package ViniHGV.EcommerceBack.application.dtos.user;

public record AuthenticateRequest(
        String email,
        String password
) {
}
