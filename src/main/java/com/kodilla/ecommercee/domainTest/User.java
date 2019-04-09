// package com.kodilla.ecommercee.domainTest;

// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import javax.persistence.*;
// import javax.validation.constraints.NotNull;
// import java.time.LocalDate;
// import java.time.LocalTime;

// @Entity
// @Table(name = "USER")
// @NoArgsConstructor
// @AllArgsConstructor
// @Setter(value = AccessLevel.PUBLIC)

// public class User {
//     private Long id;
//     private String firstName;
//     private String lastName;
//     private LocalDate birthDate;
//     private String address;
//     private String login;
//     private String password;
//     private boolean isBlocked;
//     private String uuid;
//     private LocalTime beginValidityOfUuid;
//     private LocalTime endValidityOfUuid;


//     @Column(name = "ID")
//     @Id
//     @GeneratedValue
//     public Long getId() {
//         return id;
//     }


//     @Column(name = "FIRSTNAME")
//     @NotNull
//     public String getFirstName() {
//         return firstName;
//     }


//     @Column(name = "LASTNAME")
//     @NotNull
//     public String getLastName() {
//         return lastName;
//     }

//     @Column(name = "BIRTHDATE")
//     @NotNull
//     public LocalDate getBirthDate() {
//         return birthDate;
//     }

//     @Column(name = "ADDRESS")
//     public String getAddress() {
//         return address;
//     }


//     @Column(name = "LOGIN")
//     @NotNull
//     public String getLogin() {
//         return login;
//     }


//     @Column(name = "PASSWORD")
//     @NotNull
//     public String getPassword() {
//         return password;
//     }


//     @Column(name = "IS_BLOCKED")
//     @NotNull
//     public boolean isBlocked() {
//         return isBlocked;

//     }


//     @Column(name = "UUID")
//     public String getUuid() {
//         return uuid;
//     }


//     @Column(name = "BEGIN_VALIDITY_UUID")
//     @NotNull
//     public LocalTime getBeginValidityOfUuid() {
//         return beginValidityOfUuid;
//     }


//     @Column(name = "END_VALIDITY_UUID")
//     @NotNull
//     public LocalTime getEndValidityOfUuid() {
//         return endValidityOfUuid;


//     }
// }
