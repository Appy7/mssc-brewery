package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerID)
    {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Appy").beerStyle("Kasa").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto){
        return BeerDto.builder().id(UUID.randomUUID()).build();


    }

    @Override
    public void updateBeer(UUID beerID, BeerDto beerDto){}


    @Override
    public void deleteById(UUID beerId) {

        log.debug("Deleted a beer");

    }
}

//    it init
//    git add README.md
//        git commit -m "first commit"
//        git branch -M main
//        git remote add origin https://github.com/Appy7/mssc-brewery.git
//        git push -u origin main
