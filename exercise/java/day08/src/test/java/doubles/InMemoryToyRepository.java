package doubles;

import domain.Toy;
import domain.ToyRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryToyRepository implements ToyRepository {
    private final List<Toy> toys = new ArrayList<>();

    @Override
    public Toy findByName(String name) {
        return toys.stream()
                .filter(t -> t.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Toy toy) {
        toys.remove(toy);
        toys.add(toy);
    }
}