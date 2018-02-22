package io.pivotal.pace;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface GreetingRepository extends JpaRepository<Greeting, Integer> {
	  List<Greeting> findByLanguage(@Param("language") String language); 
}