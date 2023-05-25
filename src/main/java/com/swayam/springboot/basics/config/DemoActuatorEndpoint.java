package com.swayam.springboot.basics.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "demo")
public class DemoActuatorEndpoint {
    private final Map<String, DemoActuator> demoActuatorMap =
            new ConcurrentHashMap<String, DemoActuator>();

    public DemoActuatorEndpoint() {
        demoActuatorMap.put("Users", new DemoActuator(true));
        demoActuatorMap.put("Branch", new DemoActuator(false));
        demoActuatorMap.put("Accounts", new DemoActuator(false));
    }
    @ReadOperation
    public Map<String, DemoActuator> demoActuator() {
        return demoActuatorMap;
    }
    @ReadOperation
    public DemoActuator demoActuator(@Selector String name) {
        return demoActuatorMap.get(name);
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class DemoActuator {
        private boolean isEnabled;
    }
}
