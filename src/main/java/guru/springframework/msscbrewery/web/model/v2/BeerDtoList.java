package guru.springframework.msscbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerDtoList extends PageImpl<BeerDtoV2> {

    public BeerDtoList(List content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerDtoList(List content) {
        super(content);
    }

    //public BeerDtoList(){}
}
