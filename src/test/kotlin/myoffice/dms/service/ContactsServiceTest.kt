package myoffice.dms.service

import myoffice.dms.domain.ContactEntity
import myoffice.dms.domain.SenderType
import myoffice.dms.model.Contact
import myoffice.dms.model.ContactPerson
import myoffice.dms.repository.ContactPersonRepository
import myoffice.dms.repository.ContactRepository
import myoffice.dms.repository.RepositoryTestConfig
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [
    RepositoryTestConfig::class
])
internal class ContactsServiceTest {
    lateinit var contactsService: ContactsService

    @Autowired
    lateinit var contactRepository: ContactRepository

    @Autowired
    lateinit var contactPersonRepository: ContactPersonRepository

    @BeforeEach
    fun setUp(){
        contactsService = ContactsService(contactRepository)
        contactRepository.deleteAll()
        contactPersonRepository.deleteAll()
    }

    @Test
    fun `should generate valid ContactEntity, saves and returns it`() {
        val newContact = contact()
        val savedEntity: ContactEntity = contactsService.saveContact(newContact)

        val softly = SoftAssertions()
        softly.assertThat(savedEntity.senderType).`as`("wrong sender type").isEqualTo(newContact.senderType)
        softly.assertThat(savedEntity.name).`as`("wrong name").isEqualTo(newContact.name)
        softly.assertThat(savedEntity.street).`as`("wrong street").isEqualTo(newContact.street)
        softly.assertThat(savedEntity.streetNumber).`as`("wrong streetNumber").isEqualTo(newContact.streetNumber)
        softly.assertThat(savedEntity.city).`as`("wrong city").isEqualTo(newContact.city)
        softly.assertThat(savedEntity.plz).`as`("wrong plz").isEqualTo(newContact.plz)
        softly.assertThat(savedEntity.countryCode).`as`("wrong countryCode").isEqualTo(newContact.countryCode)
        softly.assertThat(savedEntity.mail).`as`("wrong mail").isEqualTo(newContact.mail)
        softly.assertThat(savedEntity.tel).`as`("wrong tel").isEqualTo(newContact.tel)
        softly.assertThat(savedEntity.fax).`as`("wrong fax").isEqualTo(newContact.fax)
        softly.assertThat(savedEntity.contactPersons?.first()?.firstname).`as`("wrong firstname").isEqualTo(newContact.contactPersons.first().firstname)
        softly.assertThat(savedEntity.contactPersons?.first()?.lastname).`as`("wrong lastname").isEqualTo(newContact.contactPersons.first().lastname)
        softly.assertThat(savedEntity.contactPersons?.first()?.telDirect).`as`("wrong telDirect").isEqualTo(newContact.contactPersons.first().telDirect)
        softly.assertThat(savedEntity.contactPersons?.first()?.mailDirect).`as`("wrong mailDirect").isEqualTo(newContact.contactPersons.first().mailDirect)

    }

    companion object {
        fun contact(): Contact = Contact(
            senderType = SenderType.COMPANY,
            name = "name",
            street = "street",
            streetNumber = "streetNumber",
            city = "city",
            plz = "plz",
            countryCode = 1,
            mail = "mail",
            tel = "tel",
            fax = "fax",
            contactPersons = setOf(contactPerson())
        )

        private fun contactPerson(): ContactPerson = ContactPerson(
            firstname = "firstname",
            lastname = "lastname",
            telDirect = "telDirect",
            mailDirect = "mailDirect"
        )
    }
}
