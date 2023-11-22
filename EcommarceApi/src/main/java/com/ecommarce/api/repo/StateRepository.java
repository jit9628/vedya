package com.ecommarce.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ecommarce.api.entity.State;
import java.util.List;


@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	List<State> findByStatename(String statename);

}
