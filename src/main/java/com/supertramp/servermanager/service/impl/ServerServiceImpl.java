package com.supertramp.servermanager.service.impl;

import com.supertramp.servermanager.service.ServerService;
import com.supertramp.servermanager.model.Server;
import com.supertramp.servermanager.repository.ServerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import static com.supertramp.servermanager.model.enumeration.Status.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ServerServiceImpl implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        log.info("Saving new server: "+server.getName());
        server.setImageUrl(setImageUrl());
        return serverRepo.save(server);
    }
//TODO
    private String setImageUrl() {
        return null;
    }

    @Override
    public Server findById(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server: "+server.getName());
        return serverRepo.save(server);
    }

    @Override
    public boolean delete(Long id) {
        log.info("Deleting server with id: {}", id);
        serverRepo.deleteById(id);
        return true;
    }

    @Override
    public Collection<Server> getAll(int limit) {
        log.info("Fetching all servers.");
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Ping server by IP:"+ ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000)? SERVER_UP : SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }
}
