package myoffice.dms.repository

import myoffice.dms.domain.ContactEntity
import myoffice.dms.domain.ContactPersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : JpaRepository<ContactEntity, Long>{

    fun findByName(name: String): ContactEntity
}

@Repository
interface ContactPersonRepository : JpaRepository<ContactPersonEntity, Long>