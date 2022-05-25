package com.supertramp.servermanager;

import com.supertramp.servermanager.model.Server;
import com.supertramp.servermanager.model.enumeration.Status;
import com.supertramp.servermanager.repository.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ServerRepo serverRepo) {
        return args -> {
            serverRepo
                    .save(new Server(null,"192.168.1.160","Linux", "16GB",
                            "Personal PC","sad", Status.SERVER_UP));
            serverRepo
                    .save(new Server(null,"192.168.1.21","Windows", "16GB",
                            "Personal PC","sad", Status.SERVER_UP));
        };
    }
}
