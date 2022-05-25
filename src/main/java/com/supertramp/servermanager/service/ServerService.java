package com.supertramp.servermanager.service;

import com.supertramp.servermanager.model.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {
    Server create (Server server);
    Server findById (Long id);
    Server update (Server server);
    boolean delete (Long id);
    Collection<Server> getAll(int limit);
    Server ping (String ipAddress) throws IOException;
}
