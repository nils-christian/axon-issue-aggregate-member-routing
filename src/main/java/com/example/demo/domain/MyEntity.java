package com.example.demo.domain;

import com.example.demo.domain.command.ReturnMyEntityNameCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.EntityId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyEntity {

	private static final Logger LOGGER = LoggerFactory.getLogger( MyEntity.class );

	@EntityId
	private final String entityId;
	private final String name;

	public MyEntity( final String entityId, final String name ) {
		this.entityId = entityId;
		this.name = name;
	}

	@CommandHandler
	public String handle( ReturnMyEntityNameCommand command ) {
		if ( !command.getEntityId( ).equals( entityId ) ) {
			LOGGER.warn( "My Entity with id '{}' received a command for entity with id '{}'.", entityId, command.getEntityId( ) );
		}

		return name;
	}

}
