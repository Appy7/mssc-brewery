package guru.springframework.msscbrewery.web.mappers;

import guru.springframework.msscbrewery.Domain.Beer;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-11T18:18:53+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDtoV2 beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoV2.BeerDtoV2Builder beerDtoV2 = BeerDtoV2.builder();

        beerDtoV2.id( beer.getId() );
        beerDtoV2.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDtoV2.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDtoV2.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDtoV2.upc( beer.getUpc() );

        return beerDtoV2.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDtoV2 beerDtoV2) {
        if ( beerDtoV2 == null ) {
            return null;
        }

        Beer.BeerBuilder beer = Beer.builder();

        beer.id( beerDtoV2.getId() );
        beer.createdDate( dateMapper.asTimeStamp( beerDtoV2.getCreatedDate() ) );
        beer.beerName( beerDtoV2.getBeerName() );
        if ( beerDtoV2.getBeerStyle() != null ) {
            beer.beerStyle( beerDtoV2.getBeerStyle().name() );
        }
        beer.upc( beerDtoV2.getUpc() );

        return beer.build();
    }
}
