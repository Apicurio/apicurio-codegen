package io.petstore;

import io.petstore.beans.Pet;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PetStoreImpl implements PetsResource {

    private static final Map<Long, Pet> PETS = new ConcurrentHashMap<>();

    @Override
    public List<Pet> listPets(Integer limit) {
        return PETS.values().stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public void createPets(Pet data) {
        PETS.put(data.getId(), data);
    }

    @Override
    public Pet showPetById(long petId) {
        return PETS.get(petId);
    }
}
