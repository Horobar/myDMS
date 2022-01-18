package myoffice.dms.model

import myoffice.dms.domain.ContactEntity
import myoffice.dms.domain.ContactPersonEntity
import myoffice.dms.domain.SenderType
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingInheritanceStrategy
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

data class Contact(
    val senderType: SenderType,
    val name: String,
    val street: String?,
    val streetNumber: String?,
    val city: String?,
    val plz: String?,
    val countryCode: Int?,
    val mail: String?,
    val tel: String?,
    val fax: String?,
    val contactPersons: Set<ContactPerson>
)

data class ContactPerson(
    val firstname: String?,
    val lastname: String?,
    val telDirect: String?,
    val mailDirect: String?
)

fun Contact.asEntity() : ContactEntity = ContactEntity().also { contactEntity ->
    contactEntity.senderType = this.senderType
    contactEntity.name = this.name
    contactEntity.street = this.street
    contactEntity.streetNumber = this.streetNumber
    contactEntity.city = this.city
    contactEntity.countryCode = this.countryCode
    contactEntity.mail = this.mail
    contactEntity.tel = this.tel
    contactEntity.fax = this.fax
    contactEntity.contactPersons = this.contactPersons.map { it.asEntity() }.toSet()
}

fun ContactPerson.asEntity() : ContactPersonEntity = ContactPersonEntity().also {
    it.firstname = this.firstname
    it.lastname = this.lastname
    it.telDirect = this.mailDirect
    it.telDirect = this.telDirect
}

