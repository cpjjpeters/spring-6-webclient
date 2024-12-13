package guru.springframework.client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/* carlpeters created on 13/12/2024 inside the package - guru.springframework.client */
public class BeerClientImpl implements BeerClient {
    private final WebClient webClient;

    public BeerClientImpl(WebClient webClient) {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @Override
    public Flux<String> listBeers() {
        return webClient.get().uri("/api/v3/beer",String.class).retrieve().bodyToFlux(String.class);
    }
}
