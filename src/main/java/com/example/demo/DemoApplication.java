package com.example.demo;

import com.example.demo.domain.Constants;
import com.example.demo.domain.command.CreateMyAggregateCommand;
import com.example.demo.domain.command.ReturnMyEntityNameCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger( DemoApplication.class );

	public static void main( String[] args ) {
		final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder( )
				.sources( DemoApplication.class )
				.logStartupInfo( false )
				.bannerMode( Mode.OFF )
				.run( args );
		final CommandGateway commandGateway = applicationContext.getBean( CommandGateway.class );

		commandGateway.sendAndWait( new CreateMyAggregateCommand( Constants.MY_AGGREGATE_ID ) );
		final String name1 = commandGateway.sendAndWait( new ReturnMyEntityNameCommand( Constants.MY_AGGREGATE_ID, Constants.MY_ENTITY_ID_1 ) );
		LOGGER.info( "Entity with id '{}' has name '{}'", Constants.MY_ENTITY_ID_1, name1 );

		final String name2 = commandGateway.sendAndWait( new ReturnMyEntityNameCommand( Constants.MY_AGGREGATE_ID, Constants.MY_ENTITY_ID_2 ) );
		LOGGER.info( "Entity with id '{}' has name '{}'", Constants.MY_ENTITY_ID_2, name2 );
	}

}
