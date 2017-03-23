/*
 * (C) Copyright 2017 CodeUrjc (http://www.code.etsii.urjc.es/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package es.urjc.etsii.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Main class.
 *
 * @author Boni Garcia (boni.garcia@urjc.es)
 * @since 6.6.1
 */
@SpringBootApplication
@EnableWebSocket
public class One2ManyApp implements WebSocketConfigurer {

	@Bean
	public One2ManyHandler callHandler() {
		return new One2ManyHandler();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(callHandler(), "/one2many");
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(One2ManyApp.class).run(args);
	}

}
