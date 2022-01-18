package myoffice.dms.repository

import myoffice.dms.domain.ContactEntity
import myoffice.dms.domain.ContactPersonEntity
import myoffice.dms.domain.SenderType
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.Locale

@SpringBootTest(classes = [
    RepositoryTestConfig::class
])
class ContactRepositoryTest {

    @Autowired
    private lateinit var contactRepository: ContactRepository

    @Autowired
    private lateinit var contactPersonRepository: ContactPersonRepository

    @BeforeEach
    fun setUp(){
        contactRepository.deleteAll()
        contactPersonRepository.deleteAll()
    }

    @Test
    fun `should store new contact entry`(){
        val newContactEntry = contact()
        contactRepository.save(newContactEntry)
        val newContactPerson = contactPerson()
        newContactPerson.apply {
            contact = contactRepository.findAll().first()
        }
        contactPersonRepository.save(newContactPerson)

        val saved = contactRepository.findByName("companyName")

        val softly = SoftAssertions()
        softly.assertThat(saved?.senderType).`as`("wrong sender type").isEqualTo(newContactEntry.senderType)
        softly.assertThat(saved?.name).`as`("wrong company name").isEqualTo(newContactEntry.name)
        softly.assertThat(saved?.street).`as`("wrong street").isEqualTo(newContactEntry.street)
        softly.assertThat(saved?.streetNumber).`as`("wrong street number").isEqualTo(newContactEntry.streetNumber)
        softly.assertThat(saved?.city).`as`("wrong city").isEqualTo(newContactEntry.city)
        softly.assertThat(saved?.plz).`as`("wrong city").isEqualTo(newContactEntry.plz)
        softly.assertThat(saved?.countryCode).`as`("wrong country code").isEqualTo(newContactEntry.countryCode)
        softly.assertThat(saved?.mail).`as`("wrong mail").isEqualTo(newContactEntry.mail)
        softly.assertThat(saved?.tel).`as`("wrong tel").isEqualTo(newContactEntry.tel)
        softly.assertThat(saved?.fax).`as`("wrong fax").isEqualTo(newContactEntry.fax)
        softly.assertThat(saved?.contactPersons?.first()?.firstname)
            .`as`("wrong contactPerson.firstname").isEqualTo(newContactPerson.firstname)
        softly.assertThat(saved?.contactPersons?.first()?.lastname)
            .`as`("wrong contactPerson.lastname").isEqualTo(newContactPerson.lastname)
        softly.assertThat(saved?.contactPersons?.first()?.telDirect)
            .`as`("wrong contactPerson.telDirect").isEqualTo(newContactPerson.telDirect)
        softly.assertThat(saved?.contactPersons?.first()?.mailDirect)
            .`as`("wrong contactPerson.mailDirect").isEqualTo(newContactPerson.mailDirect)
        softly.assertAll()
    }

    companion object{

        fun contact() : ContactEntity = ContactEntity().apply {
            senderType = SenderType.COMPANY
            name = "companyName"
            street = "street"
            streetNumber = "streetNumber"
            city = "city"
            plz = "plz"
            countryCode = Locale.GERMAN.hashCode()
            mail = "mail"
            tel = "tel"
            fax = "fax"
        }

        private fun contactPerson() : ContactPersonEntity = ContactPersonEntity().apply {
            firstname = "firstname"
            lastname = "lastname"
            telDirect = "telDirect"
            mailDirect = "mailDirect"
        }
    }
}