package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerID);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);

    void updateBeer(UUID beerID, BeerDtoV2 beerDtoV2);

    void deleteById(UUID beerId);
}
