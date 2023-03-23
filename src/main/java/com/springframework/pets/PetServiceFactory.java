package com.springframework.pets;

import java.util.HashMap;
import java.util.Map;

public class PetServiceFactory {

    private Map<String, PetService> petServiceMap = new HashMap<>();

    public PetServiceFactory() {
        petServiceMap.put("dog", new DogPetService());
        petServiceMap.put("cat", new CatPetService());
    }

    public PetService getPetService(String petType){
        return petServiceMap.getOrDefault(petType, new DogPetService());
    }
}
