package ViniHGV.EcommerceBack.application.dtos.address;

public record AddressRequestDTO (
        String road,
        String neighborhood,
        String city,
        String country,
        String cep,
        Integer numberHome,
        Integer userId
){
}
