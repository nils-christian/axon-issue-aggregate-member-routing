package com.example.demo.domain.event;

public final class MyAggregateCreatedEvent {

	private final String id;

	public MyAggregateCreatedEvent( final String id ) {
		this.id = id;
	}

	public String getId( ) {
		return id;
	}

}