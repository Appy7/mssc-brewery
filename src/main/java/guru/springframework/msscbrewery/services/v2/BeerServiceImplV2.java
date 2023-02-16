package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2{

    @Override
    public BeerDtoV2 getBeerById(UUID beerID) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Appy").beerStyle(BeerStyleEnum.A).build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerID, BeerDtoV2 beerDtoV2) {

    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleted a beer");
    }
}
