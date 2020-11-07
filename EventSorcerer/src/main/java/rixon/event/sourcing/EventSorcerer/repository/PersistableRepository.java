package rixon.event.sourcing.EventSorcerer.repository;

import java.util.List;

import javax.mail.MethodNotSupportedException;

import org.springframework.data.mongodb.repository.MongoRepository;

import rixon.event.sourcing.EventSorcerer.model.Persistable;

public interface PersistableRepository extends MongoRepository<Persistable, Long> {
	
}
