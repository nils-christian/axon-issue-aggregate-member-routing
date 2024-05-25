package com.example.demo.domain.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public final class ReturnMyEntityNameCommand {

	@TargetAggregateIdentifier
	private final String id;
	private final String entityId;

	public ReturnMyEntityNameCommand( final String id, final String entityId ) {
		this.id = id;
		this.entityId = entityId;
	}

	public String getEntityId( ) {
		return entityId;
	}
}
