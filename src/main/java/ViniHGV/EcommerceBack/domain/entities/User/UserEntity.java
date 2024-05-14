package ViniHGV.EcommerceBack.domain.entities.User;

import ViniHGV.EcommerceBack.domain.entities.Address;
import ViniHGV.EcommerceBack.domain.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Table(name = "user_entity")
@NoArgsConstructor
public class UserEntity {

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private UserRoleEnum userRoleEnum;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;


    public static final class UserEntityBuilder {
        private String name;
        private String email;
        private String password;
        private UserRoleEnum userRoleEnum;

        public UserEntityBuilder() {
        }

        public UserEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserEntityBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserEntityBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserEntityBuilder userRoleEnum(UserRoleEnum userRoleEnum) {
            this.userRoleEnum = userRoleEnum;
            return this;
        }

        public UserEntity build() {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(name);
            userEntity.setEmail(email);
            userEntity.setPassword(password);
            userEntity.setUserRoleEnum(userRoleEnum);
            return userEntity;
        }
    }
}
