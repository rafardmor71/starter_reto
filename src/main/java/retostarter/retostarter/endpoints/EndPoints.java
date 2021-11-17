package retostarter.retostarter.endpoints;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
@Endpoint(id = "estados")
public class EndPoints {
	
	private final static Logger logger = LoggerFactory.getLogger(EndPoints.class);

	private Counter counter;
	
	public EndPoints(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.estados").description("Invocaciones totales").register(registry);
	}
	
	//private List<String> listado = ArrayList<>();
	private static  List<String> listado = Arrays.asList("open", "close", "half-open");

	
	@ReadOperation
	public List<String> estados(){
		counter.increment();
		return listado;
	}

	
	@WriteOperation
	public void writeOperationOpen(@Selector String nuevo) {
		counter.increment();
		listado.add(nuevo);
	}

	/*
	@DeleteOperation
	public void deleteOperation(@Selector String estadoBorrar) {
		listado.remove(estadoBorrar);
	}
	*/

}
