package guru.springframework.msscbrewery.loader;

import guru.springframework.msscbrewery.Domain.Beer;
import guru.springframework.msscbrewery.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {

        if(beerRepository.count()==0)
        {
            beerRepository.save(Beer
                    .builder()
                            .beerName("mango")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .minOnHand(12)
                            .upc(8271383767676L)
                            .price(new BigDecimal("12.7l"))
                    .build());

            beerRepository.save(Beer
                    .builder()
                    .beerName("cherry")
                    .beerStyle("pPA")
                    .quantityToBrew(100)
                    .minOnHand(10)
                    .upc(8271383769976L)
                    .price(new BigDecimal("72.7l"))
                    .build());
        }
    }
}
