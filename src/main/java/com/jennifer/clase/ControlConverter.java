package com.jennifer.clase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Configuration

public class ControlConverter {
	
	@Value(value="${app.message.pesos}")
	private Double pesos;
	
	@Value(value="${app.message.dolar}")
	private Double dolar;
	
	@GetMapping("/pesos/{a}")
	public Converter pesos (@PathVariable Double a) {
		Converter pesoscol= new Converter();
		pesoscol.setDolar(a*pesos);
		pesoscol.setPesos(a);
		return pesoscol;
	
	}
	
	@GetMapping("/dolar/{a}")
	public Converter dolar (@PathVariable Double a) {
		Converter pesoscol = new Converter();
		pesoscol.setPesos(a/pesos);
		pesoscol.setDolar(a);
		return pesoscol;

}
}