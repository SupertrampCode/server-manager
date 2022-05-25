package com.supertramp.servermanager.model;

import com.supertramp.servermanager.model.enumeration.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP address cannot be null or empty.")
    //@Pattern(regexp = "\\\\d{1,2}|(0|1)\\\\d{2}|2[0-4]\\\\d|25[0-5]", message = "IP doesn't match ip pattern!")
    String ipAddress;
    String name;
    String memory;
    String type;
    String imageUrl;
    Status status;
}
