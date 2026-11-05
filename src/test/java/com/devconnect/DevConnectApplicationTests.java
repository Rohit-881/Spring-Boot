package com.devconnect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.devconnect.controller.HealthController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DevConnectApplicationTests {

	@Autowired
	private HealthController healthController;

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;

	@Test
	void healthEndpointIsRegisteredAndReturnsRunningMessage() {
		assertTrue(handlerMapping.getHandlerMethods().keySet().stream()
				.flatMap(info -> info.getPatternValues().stream())
				.anyMatch("/health"::equals));
		assertEquals("Application is running", healthController.health());
	}

	@Test
	void statusEndpointIsRegisteredAndReturnsServiceStatus() {
		assertTrue(handlerMapping.getHandlerMethods().keySet().stream()
				.flatMap(info -> info.getPatternValues().stream())
				.anyMatch("/api/v1/status"::equals));
		var status = healthController.status();
		assertEquals("DevConnect", status.get("Service"));
		assertEquals("Running", status.get("Status"));
		assertEquals("1.0.0", status.get("version"));
	}
}
