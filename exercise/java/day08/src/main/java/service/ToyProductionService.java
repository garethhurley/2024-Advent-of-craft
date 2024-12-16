package service;

import domain.Toy;
import domain.ToyRepository;

public class ToyProductionService {
    private final ToyRepository repository;

    public ToyProductionService(ToyRepository repository) {
        this.repository = repository;
    }

    public void assignToyToElf(String toyName) {
        Toy toy = repository.findByName(toyName);
        if (toy != null && toy.moveToProduction()) {
            repository.save(toy);
        }
    }

}