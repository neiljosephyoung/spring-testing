package com.njy.cli_tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.njy.cli_tools.graphql.User;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
public class CliToolsApplication {

	private WebClient webClient;
	private ObjectMapper objectMapper;

	@PostConstruct
	void doGraphQlRequest() {
		webClient = WebClient.builder()
				.baseUrl("http://localhost:8080/graphql")
				.defaultHeaders(httpHeaders -> {
					httpHeaders.setContentType(MediaType.APPLICATION_JSON);
					httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				})
				.build();
		objectMapper = new ObjectMapper();
	}

	public Mono<List<User>> fetchUsers() {
		String query = """
            query {
                users {
                    id
                    name
                    email
                }
            }
            """;

		return webClient.post()
				.bodyValue(Collections.singletonMap("query", query))
				.retrieve()
				.bodyToMono(String.class)
				.map(response -> {
					JsonNode jsonNode = null;
					try {
						jsonNode = objectMapper.readTree(response);
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
					JsonNode usersNode = jsonNode.get("data").get("users");
					return objectMapper.convertValue(usersNode,
							new TypeReference<List<User>>() {});
				});
	}

	@GetMapping(value = "/pull", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<List<User>>> getUsers() {
		return fetchUsers()
				.map(users -> ResponseEntity.ok(users))
				.doOnError(error -> System.err.println("Error fetching users: " + error.getMessage()));
	}


	public static void main(String[] args) {
		SpringApplication.run(CliToolsApplication.class, args);
	}
}