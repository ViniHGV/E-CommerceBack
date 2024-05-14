package ViniHGV.EcommerceBack.domain.useCases.Address.ListAddress;

import ViniHGV.EcommerceBack.domain.entities.Address;

import java.util.List;

public interface IListAddressUseCase {
    List<Address> execute();
}
