package ViniHGV.EcommerceBack.domain.useCases.Address.CreateAddress;

import ViniHGV.EcommerceBack.application.dtos.address.AddressRequestDTO;
import ViniHGV.EcommerceBack.domain.entities.Address;

public interface ICreateAddressUseCase {
    Address execute(AddressRequestDTO addressRequestDTO);
}
