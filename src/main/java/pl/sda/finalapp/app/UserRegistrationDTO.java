package pl.sda.finalapp.app;

public class UserRegistrationDTO {
    private String firstName;
    private String lastName;
    private String eMail;
    private String passwordHash;
    private String city;
    private String country;
    private String zipCode;
    private String street;
    private String birthDate;
    private String pesel;
    private String phone;
    private boolean preferEmails;

    public UserRegistrationDTO(String firstName, String lastName, String eMail, String passwordHash, String city, String country, String zipCode, String street, String birthDate, String pesel, String phone, boolean preferEmails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.passwordHash = passwordHash;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.street = street;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.phone = phone;
        this.preferEmails = preferEmails;
    }

    public UserRegistrationDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isPreferEmails() {
        return preferEmails;
    }
}
