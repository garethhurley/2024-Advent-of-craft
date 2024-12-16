import domain.Toy;
import domain.ToyRepository;
import doubles.InMemoryToyRepository;
import org.junit.jupiter.api.Test;
import service.ToyProductionService;

import static domain.Toy.State.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class ToyProductionServiceTest {
    private static final String TOY_NAME = "Train";

    @Test
    void assignToyToElfShouldPassTheItemInProduction() {
        var repository = new InMemoryToyRepository();
        var service = new ToyProductionService(repository);
        repository.save(new Toy(TOY_NAME, UNASSIGNED));

        service.assignToyToElf(TOY_NAME);

        assertThat(repository.findByName(TOY_NAME).getState())
                .isEqualTo(IN_PRODUCTION);
    }

    @Test
    void givenToyAlreadyInProduction_thenToyIsNotSavedInRepository() {
        var toy = new Toy(TOY_NAME, IN_PRODUCTION);
        var mockedToyRepository = mockToyRepositoryToFindToy(toy);

        ToyProductionService mockedToyProductionService = new ToyProductionService(mockedToyRepository);

        mockedToyProductionService.assignToyToElf(TOY_NAME);

        verify(mockedToyRepository, never()).save(toy);
    }

    @Test
    void givenToyNotFound_thenToyIsNotSavedInRepository() {
        ToyRepository mockedToyRepository = mockToyRepositoryToFindToy(null);
        ToyProductionService mockedToyProductionService = new ToyProductionService(mockedToyRepository);

        mockedToyProductionService.assignToyToElf(TOY_NAME);

        verify(mockedToyRepository, never()).save(any());
    }

    private ToyRepository mockToyRepositoryToFindToy(Toy toy) {
        ToyRepository mockedToyRepository = mock(ToyRepository.class);
        when(mockedToyRepository.findByName(TOY_NAME)).thenReturn(toy);
        return mockedToyRepository;
    }

}