package io.doosti.hamid.reactivespring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.doosti.hamid.reactivespring.model.CoinBaseResponse;
import io.doosti.hamid.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CoinbaseServiceImpl implements CoinbaseService{
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private ReactiveMongoOperations reactiveMongoOperations;
	
	@Override
	public Mono<CoinBaseResponse> getCryptoPrice(String priceName) {
		// TODO Auto-generated method stub
		return webClient.get()
				.uri("https://api.coinbase.com/v2/prices/{crypto}/buy",priceName)
				.exchange()
				.flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
	}

	@Override
	public Mono<Purchase> createPurchase(String pricaName) {
		// TODO Auto-generated method stub
		return getCryptoPrice(pricaName).flatMap(price -> reactiveMongoOperations.save(
				new Purchase(pricaName, price.getData().getAmount(), LocalDateTime.now())));
	}

	@Override
	public Mono<Purchase> getPurchaseById(String id) {

		return reactiveMongoOperations.findById(id, null);
	}

	@Override
	public Flux<Purchase> listAllPurchases() {

		return reactiveMongoOperations.findAll(Purchase.class);
	}
	
}
