package com._4mila.backend.server;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class GuicePersistenceInitializer { 
    @Inject GuicePersistenceInitializer(PersistService service) {
        service.start(); 
        // At this point JPA is started and ready.
    } 
}