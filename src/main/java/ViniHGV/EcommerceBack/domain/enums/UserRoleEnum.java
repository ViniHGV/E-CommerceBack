package ViniHGV.EcommerceBack.domain.enums;

public enum UserRoleEnum {
    Admin("Admin"),
    User("User");

    private String role;

    UserRoleEnum(String role){
        this.role = role;
    }
}
