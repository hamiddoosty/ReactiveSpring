package io.doosti.hamid.reactivespring.service;

import io.doosti.hamid.reactivespring.model.CoinBaseResponse;
import io.doosti.hamid.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinbaseService {

	Mono<CoinBaseResponse> getCryptoPrice(String priceName);

	Mono<Purchase> createPurchase(String pricaName);
	
	Mono<Purchase> getPurchaseById(String id);
	
	Flux<Purchase> listAllPurchases();

}
 