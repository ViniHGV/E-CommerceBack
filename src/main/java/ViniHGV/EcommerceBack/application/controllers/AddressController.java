package ViniHGV.EcommerceBack.application.controllers;

import ViniHGV.EcommerceBack.application.dtos.address.AddressRequestDTO;
import ViniHGV.EcommerceBack.domain.useCases.Address.CreateAddress.ICreateAddressUseCase;
import ViniHGV.EcommerceBack.domain.useCases.Address.ListAddress.IListAddressUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@AllArgsConstructor
public class AddressController {

    private final ICreateAddressUseCase createAddressUseCase;
    private final IListAddressUseCase listAddressUseCase;

    @GetMapping
    public ResponseEntity getAddress(){
        return ResponseEntity.ok(this.listAddressUseCase.execute());
    }

    @PostMapping
    public ResponseEntity createAddress(@RequestBody AddressRequestDTO addressRequestDTO){
        try{
            return ResponseEntity.status(201).body(this.createAddressUseCase.execute(addressRequestDTO));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
