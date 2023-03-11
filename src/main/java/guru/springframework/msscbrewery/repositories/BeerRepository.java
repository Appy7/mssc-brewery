package guru.springframework.msscbrewery.repositories;

import guru.springframework.msscbrewery.Domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
    int count();

    void save(Beer build);
}
