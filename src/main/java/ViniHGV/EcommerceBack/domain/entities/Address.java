package ViniHGV.EcommerceBack.domain.entities;

import ViniHGV.EcommerceBack.domain.entities.User.UserEntity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Address {


    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotNull()
    @Column(nullable = false)
    private String road;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private Integer numberHome;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonIncludeProperties(value = {"id", "name", "email", "userRoleEnum"})
    private UserEntity user;

    public static final class AddressBuilder{
        private String road;
        private String neighborhood;
        private String city;
        private String country;
        private String cep;
        private Integer numberHome;
        private UserEntity user;

        public AddressBuilder(){}


        public AddressBuilder road(String road){
            this.road = road;
            return this;
        }

        public AddressBuilder neighborhood(String neighborhood){
            this.neighborhood = neighborhood;
            return this;
        }

        public AddressBuilder city(String city){
            this.city = city;
            return this;
        }

        public AddressBuilder country(String country){
            this.country = country;
            return this;
        }

        public AddressBuilder cep (String cep){
            this.cep = cep;
            return this;
        }

        public AddressBuilder numberHome(Integer numberHome){
            this.numberHome = numberHome;
            return this;
        }

        public AddressBuilder user(UserEntity user){
            this.user = user;
            return this;
        }

        public Address build(){
            Address address = new Address();
            address.setRoad(road);
            address.setNumberHome(numberHome);
            address.setUser(user);
            address.setCountry(country);
            address.setNeighborhood(neighborhood);
            address.setCep(cep);
            address.setCity(city);

            return address;
        }
    }
}
