package myoffice.dms.repository

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Configuration
@Import(
    RepositoryConfig::class
)
@EnableAutoConfiguration(

)
class RepositoryTestConfig {
}