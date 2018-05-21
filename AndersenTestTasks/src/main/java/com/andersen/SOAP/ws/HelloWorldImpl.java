package com.andersen.SOAP.ws;

import javax.jws.WebService;

@WebService (endpointInterface = "com.andersen.SOAP.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

}
