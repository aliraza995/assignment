package service_flow.assignment.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @author Ali Raza
 */
@Configuration
@ImportResource({
    "classpath:assignment-webapp-context.xml",
    "classpath:META-INF/cxf/cxf.xml",
    "classpath:META-INF/cxf/cxf-servlet.xml"})
public class WebAppConfig {

    @Bean
    public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module());
        final JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
        jsonProvider.setMapper(objectMapper);
        return jsonProvider;
    }
}
