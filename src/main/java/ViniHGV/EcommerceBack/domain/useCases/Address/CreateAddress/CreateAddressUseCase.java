package ViniHGV.EcommerceBack.domain.useCases.Address.CreateAddress;

import ViniHGV.EcommerceBack.application.dtos.address.AddressRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.Address;
import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import ViniHGV.EcommerceBack.infra.repositories.AddressRepository;
import ViniHGV.EcommerceBack.infra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAddressUseCase implements ICreateAddressUseCase{

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public Address execute(AddressRequestDTO addressRequestDTO) {
        UserEntity user = this.userRepository.findById(addressRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("Usuário informado é inválido!"));

        Address address = new Address.AddressBuilder()
                .cep(addressRequestDTO.cep())
                .city(addressRequestDTO.city())
                .road(addressRequestDTO.road())
                .country(addressRequestDTO.country())
                .neighborhood(addressRequestDTO.neighborhood())
                .numberHome(addressRequestDTO.numberHome())
                .user(user)
                .build();

        user.getAddresses().add(address);
        this.userRepository.save(user);

        return this.addressRepository.save(address);
    }
}
