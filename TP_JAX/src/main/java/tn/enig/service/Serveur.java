package tn.enig.service;

import jakarta.xml.ws.Endpoint;

public class Serveur {
	public static void main (String[] args) {
		String url= "http://127.0.0.1:8090/";
		Endpoint.publish(url, new JaxWS());
	}
}
