package challenge;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@EnableJpaRepositories
@RepositoryRestResource
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
	

	@Query(value = "select s.id, s.actor, s.detail from scripts s", nativeQuery = true)
	List<Quote> getRandomQuote();
	
    @Query(value = "select id, actor, detail from scripts where actor = :actor", nativeQuery = true)
    List<Quote> getQuoteByActor(@Param("actor") String actor);

}


