
package ViniHGV.EcommerceBack.application.controllers;


import ViniHGV.EcommerceBack.application.dtos.user.AuthenticateRequest;
import ViniHGV.EcommerceBack.application.dtos.user.CreateUserRequestDTO;
import ViniHGV.EcommerceBack.domain.useCases.User.AuthenticateUser.IAuthenticateUserUseCase;
import ViniHGV.EcommerceBack.domain.useCases.User.CreateUser.ICreateUserUseCase;
import ViniHGV.EcommerceBack.domain.useCases.User.GetUniqueUser.IGetUniqueUser;
import ViniHGV.EcommerceBack.domain.useCases.User.ListUsers.IListUsersUseCase;
import ViniHGV.EcommerceBack.domain.useCases.User.UpdateUser.IUpdateUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private final IListUsersUseCase listUsersUseCase;
    private final ICreateUserUseCase createUserUseCase;
    private final IAuthenticateUserUseCase authenticateUserUseCase;
    private final IGetUniqueUser getUniqueUser;
    private final IUpdateUserUseCase updateUserUseCase;

    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(this.listUsersUseCase.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Integer id, @RequestBody CreateUserRequestDTO createUserRequestDTO){
        try{
            return ResponseEntity.ok(this.updateUserUseCase.execute(id,createUserRequestDTO));
        }catch (RuntimeException e){
           return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO){
        try{
            return ResponseEntity.status(201).body(this.createUserUseCase.execute(createUserRequestDTO));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticateUser(@RequestBody AuthenticateRequest authenticateRequest){
        try{
            return ResponseEntity.ok(this.authenticateUserUseCase.execute(authenticateRequest));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getUniqueUser(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(this.getUniqueUser.execute(id));
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
