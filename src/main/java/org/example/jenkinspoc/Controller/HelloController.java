package org.example.jenkinspoc.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class HelloController {
    @Value("${app.environment:default}")
    private String environment;

    @Value("${app.greeting:Hello from Jenkins!}")
    private String greetingMessage;

    @Value("${app.loglevel:INFO}")
    private String logLevel;

    @GetMapping("/hello")
    public String hello() {
        return greetingMessage;
    }

    @GetMapping("/info")
    public String info() {
        return "Environment: " + environment +
                " | Log Level: " + logLevel;
    }
}
