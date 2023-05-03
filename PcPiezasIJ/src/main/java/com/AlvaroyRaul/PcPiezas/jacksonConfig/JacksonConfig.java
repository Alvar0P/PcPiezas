package com.AlvaroyRaul.PcPiezas.jacksonConfig;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.UsuarioMixin;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.failOnEmptyBeans(false);
        builder.failOnUnknownProperties(false);
        builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        builder.featuresToEnable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
        builder.featuresToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        builder.modules(new JavaTimeModule());
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        builder.simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        builder.mixIn(Usuario.class, UsuarioMixin.class);
        return builder;
    }
}