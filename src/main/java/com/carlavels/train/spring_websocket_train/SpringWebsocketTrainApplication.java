package com.carlavels.train.spring_websocket_train;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.carlavels.train.spring_websocket_train.model.Response;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringWebsocketTrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebsocketTrainApplication.class, args);
	}


	@Bean
	public CommandLineRunner startPublisher(SimpMessagingTemplate template) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				int count = 0;
				while (true) {
					Thread.sleep(6000);

					count++;
					log.info("Sending message #{}", count);
					// 123456 = caseId
					template.convertAndSend("/topic/123456", new Response("Sending Message: " + count, "dummy message"));
					//template.convertAndSendToUser("123456", "/queue/msgOut", new Response("Sending Message: " + count, "dummy message"));
				}
			}
		};
	}
}
