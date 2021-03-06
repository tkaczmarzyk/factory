package pl.com.bottega.factory.demand.forecasting.projection;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import pl.com.bottega.tools.ProjectionRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(path = "demand-forecasts",
        collectionResourceRel = "demand-forecasts",
        itemResourceRel = "demand-forecast")
public interface CurrentDemandDao extends ProjectionRepository<CurrentDemandEntity, Long> {
    @RestResource(path = "refNos", rel = "refNos")
    List<CurrentDemandEntity> findByRefNoAndDateGreaterThanEqual(@Param("refNo") String refNo, @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date);

    @RestResource(exported = false)
    void deleteByRefNoAndDate(String refNo, LocalDate date);
}
