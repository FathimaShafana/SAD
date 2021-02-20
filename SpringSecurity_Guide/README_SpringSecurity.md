# Spring Security
This repository gives you a brief a brief idea on security implementations in Spring Boot basically the authentication and authorization. This is a quick demonstration of how different users are authenticated at first and then authorized with user privileges.
This program lets you login to your account at first if you are a registered user and display your user roles. Else, directs you to register if you are a new user.  The validation is customized and error messages would be displayed for few specific errors defined in messages.properties. 

## Few things on authentication and Password
BCryptPasswordEncoder is used to encode the password so that it is not directly visible to others. I have created a bean of type BCryptPasswordEncoder and this bean type is then provided to the AuthenticationManagerBuilder. The encoded password is stored in the database.
If you have successfully implemented all the files as here, you could see them as follows:

### Register
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/RegisterPortal.PNG?raw=true)

### Login
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/LoginPortal.PNG?raw=true)

### Successful Login
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/Successful%20Login.PNG?raw=true)

### Error Messages
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/LoginError.PNG?raw=true)

#### Error registering
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/ErrorRegister.JPG?raw=true)

#### When a required field is missing
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/MandateField.PNG?raw=true)

#### USername already taken
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/userTaken.PNG?raw=true)

### JOIN TABLE
![](https://github.com/FathimaShafana/SAD/blob/main/SpringSecurity_Guide/SpringSecuritySnaps/JoinTable.PNG?raw=true)
