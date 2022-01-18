package myoffice.dms

import myoffice.dms.config.DmsCommonProperties
import myoffice.dms.controller.ControllerConfig
import myoffice.dms.repository.RepositoryConfig
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@SpringBootConfiguration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(
    DmsCommonProperties::class
)
@Import(
    RepositoryConfig::class,
)
@EntityScan(basePackages = ["myoffice.dms.*"])
@ComponentScan
class DmsApplication

fun main(args: Array<String>) {
    runApplication<DmsApplication>(*args)
}
