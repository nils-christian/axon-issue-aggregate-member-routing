package com.example.demo.domain.command;

public final class CreateMyAggregateCommand {

	private final String id;

	public CreateMyAggregateCommand( final String id ) {
		this.id = id;
	}

	public String getId( ) {
		return id;
	}

}
