package ViniHGV.EcommerceBack.infra.repositories;

import ViniHGV.EcommerceBack.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
