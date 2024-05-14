package ViniHGV.EcommerceBack.infra.repositories;

import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
  Optional<UserEntity> findByEmail(String email);

  @JsonIncludeProperties(value = {"id", "name", "email", "password", "userRoleEnum"})
  List<UserEntity> findAll();
}
