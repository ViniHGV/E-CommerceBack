package ViniHGV.EcommerceBack.domain.useCases.Address.ListAddress;

import ViniHGV.EcommerceBack.domain.entities.Address;
import ViniHGV.EcommerceBack.infra.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAddressUseCase implements  IListAddressUseCase {

    private final AddressRepository addressRepository;

    public List<Address> execute() {
        return this.addressRepository.findAll();
    }
}
