package io.doosti.hamid.reactivespring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.doosti.hamid.reactivespring.model.Purchase;
import io.doosti.hamid.reactivespring.service.CoinbaseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PurchaseHandler {
	
	@Autowired
	private CoinbaseService  coinbaseService;	

	public Mono<ServerResponse>listPurchases(ServerRequest serverRequest){
		final Mono<Purchase> purchase = coinbaseService.getPurchaseById(serverRequest.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase,Purchase.class); 
	}
	
	public Mono<ServerResponse> listAllPurchases(ServerRequest request){
		final Flux<Purchase> purchaseFlux = coinbaseService.listAllPurchases();
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		.body(purchaseFlux.collectList(),new ParameterizedTypeReference<List<Purchase>>() {}); 
	}
}
