package io.falcon.assignment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TestService {

  public static byte[] convertToJson(Object object) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper.writeValueAsBytes(object);
  }
//  docker ps -a
//  docker rm 687e9f0642ff 060fd612d398
//  U
//  ./mvnw clean package && docker-compose build && docker-compose up
}
