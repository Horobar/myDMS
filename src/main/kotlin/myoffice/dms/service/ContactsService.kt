package myoffice.dms.service

import myoffice.dms.domain.ContactEntity
import myoffice.dms.model.Contact
import myoffice.dms.model.asEntity
import myoffice.dms.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ContactsService(
    val contactRepository: ContactRepository
) {
    fun saveContact(contact: Contact): ContactEntity {
        return contactRepository.save(contact.asEntity())
    }


}