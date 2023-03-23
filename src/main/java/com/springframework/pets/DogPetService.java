package com.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile({"dog", "default"})
//@Service   //annotations commented out because we moved definition in configs
public class DogPetService implements PetService{
    public String getPetType(){
        return "Dogs are the best!";
    }
}
