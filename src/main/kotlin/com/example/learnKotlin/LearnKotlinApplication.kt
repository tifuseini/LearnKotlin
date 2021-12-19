package com.example.learnKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
class LearnKotlinApplication

fun main(args: Array<String>) {
	runApplication<LearnKotlinApplication>(*args)
}

@RestController
class RestController{
	fun prices(symbol: String):Flux<StockPrice> {
		return Flux.interval(Duration.ofSeconds(1))
			.map {StockPrice(symbol,randomStockPrice(),now())}
	}

	private fun randomStockPrice(): Double {
		ThreadLocalRandom.current().nextDouble(100.0)

	}
}

data class StockPrice(val symbol: String,
					  val price: Double,
					  val time: LocalDateTime
)
