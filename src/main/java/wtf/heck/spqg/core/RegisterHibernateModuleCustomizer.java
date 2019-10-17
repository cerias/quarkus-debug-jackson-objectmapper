package wtf.heck.spqg.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import io.quarkus.jackson.ObjectMapperCustomizer;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class RegisterHibernateModuleCustomizer implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        Hibernate5Module module = new Hibernate5Module();
        module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
        log.info("It is called.");
        mapper.registerModule(module);
    }
}