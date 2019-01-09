package io.project.app.audit;

import io.project.app.audit.aspect.Auditing;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("io.project")
@EntityScan("io.project.app.audit.domain")
@EnableAspectJAutoProxy
public class AuditApplication {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(AuditApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }

    @Bean
    public Auditing auditing() {
        return new Auditing();
    }

}
