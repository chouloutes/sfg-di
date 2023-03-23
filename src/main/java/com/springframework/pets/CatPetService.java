package com.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Service
//@Profile("cat")   //annotations commented out because we moved definition in configs
public class CatPetService implements PetService{
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
