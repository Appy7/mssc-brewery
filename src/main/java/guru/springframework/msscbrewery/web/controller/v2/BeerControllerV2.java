package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController

public class BeerControllerV2 {

        private final BeerServiceV2 beerServiceV2;

        public BeerControllerV2(BeerServiceV2 beerServiceV2) {
            this.beerServiceV2 = beerServiceV2;
        }


        @GetMapping({"/{beerId}"})
        public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerID)
        {
            return new ResponseEntity<>(beerServiceV2.getBeerById(beerID), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDtoV2)
        {
            BeerDtoV2 savedBeer=beerServiceV2.saveNewBeer(beerDtoV2);

            HttpHeaders httpHeaders=new HttpHeaders();
            //To add Hostname to URL
            httpHeaders.add("Location","/api/v2/beer"+ savedBeer.getId().toString());

            return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
        }

        @PutMapping({"/{beerId}"})
        public ResponseEntity handlePut(@PathVariable("beerId") UUID beerID, @RequestBody BeerDtoV2 beerDtoV2)
        {
            beerServiceV2.updateBeer(beerID,beerDtoV2);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }

        @DeleteMapping("/{beerId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void handleDelete(@PathVariable("beerId") UUID beerId){
            beerServiceV2.deleteById(beerId);
        }

    }

