package myoffice.dms.domain

import java.util.Locale
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "CONTACT")
class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "SENDER_TYPE")
    lateinit var senderType: SenderType

    @Column(name = "NAME")
    lateinit var name: String

    @Column(name = "STREET")
    var street: String? = null

    @Column(name = "STREET_NUMBER")
    var streetNumber: String? = null

    @Column(name = "CITY")
    var city: String? = null

    @Column(name = "PLZ")
    var plz: String? = null

    @Column(name = "COUNTRY_CODE")
    var countryCode: Int? = null

    @Column(name = "MAIL")
    var mail: String? = null

    @Column(name = "TEL")
    var tel: String? = null

    @Column(name = "FAX")
    var fax: String? = null

    @OneToMany(mappedBy = "contact", fetch = FetchType.EAGER)
    var contactPersons: Set<ContactPersonEntity>? = null
}

@Entity
@Table(name = "CONTACT_PERSON")
class ContactPersonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "FIRSTNAME")
    var firstname: String? = null

    @Column(name = "LASTNAME")
    var lastname: String? = null

    @Column(name = "TEL_DIRECT")
    var telDirect: String? = null

    @Column(name = "MAIL_DIRECT")
    var mailDirect: String? = null

    @ManyToOne()
    @JoinColumn(name = "contact_id")
    var contact: ContactEntity? = null
}

enum class SenderType{
    COMPANY, PRIVATE, CLUB
}

