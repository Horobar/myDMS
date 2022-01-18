package myoffice.dms.repository

import myoffice.dms.domain.ContactEntity
import myoffice.dms.domain.ContactPersonEntity
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory

@Configuration
@EnableJpaRepositories(basePackageClasses = [ContactRepository::class])
@EntityScan(basePackageClasses = [ContactEntity::class, ContactPersonEntity::class])
@EnableTransactionManagement
class RepositoryConfig {

}