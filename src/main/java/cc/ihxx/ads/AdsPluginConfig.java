package cc.ihxx.ads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import run.halo.app.plugin.SettingFetcher;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * @author Eternal
 * @since 1.0.0
 * @halo 2.0.0
 */
@Component
@Slf4j
public class AdsPluginConfig {

    private final SettingFetcher settingFetcher;

    public AdsPluginConfig(SettingFetcher settingFetcher) {
        this.settingFetcher = settingFetcher;
    }

    private Mono<String> getAds() {
        return Mono.fromCallable(() -> settingFetcher.get("basic").findValue("ads_content").asText())
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Bean
    RouterFunction<ServerResponse> adsRouterFunction() {
        return RouterFunctions.route(GET("/ads.txt")
                .and(accept(MediaType.TEXT_PLAIN)), request -> ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(getAds(), String.class));
    }

}
