package com.example.demo.domain;

import com.example.demo.domain.command.CreateMyAggregateCommand;
import com.example.demo.domain.event.MyAggregateCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Set;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class MyAggregate {

	@AggregateIdentifier
	private String id;

	@AggregateMember
	private MyEntity myEntity;
	@AggregateMember
	private Set<MyEntity> myOtherEntities = Set.of( );

	MyAggregate( ) {
		// Default Axon-Constructor
	}

	@CommandHandler
	@CreationPolicy( AggregateCreationPolicy.ALWAYS )
	public void handle( final CreateMyAggregateCommand command ) {
		apply( new MyAggregateCreatedEvent( command.getId( ) ) );
	}

	@EventSourcingHandler
	public void on( final MyAggregateCreatedEvent event ) {
		this.id = event.getId( );

		myEntity = new MyEntity( Constants.MY_ENTITY_ID_1, "My first entity" );
		myOtherEntities = Set.of( new MyEntity( Constants.MY_ENTITY_ID_2, "My second entity" ) );
	}

}
