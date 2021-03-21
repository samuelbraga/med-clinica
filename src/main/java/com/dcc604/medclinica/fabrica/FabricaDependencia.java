package com.dcc604.medclinica.fabrica;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FabricaDependencia {

    @Bean
    public Clock getClock() {
        return Clock.system(Clock.systemDefaultZone().getZone());
    }
}
