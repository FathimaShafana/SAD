package com.example.mid.services;

import com.example.mid.dao.UserJPADao;
import com.example.mid.models.User;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJPADao userdao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	//@Autowired
	//private EmailService emailService;

	@Override
	public void save(User user) {
		System.out.println("here");
		String hashedPassword = bcryptEncoder
				.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setActive(true);
		userdao.save(user);

		/* successful registration -> send emails
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(user.getEmail());
		emailMsg.setText("You are registered!");
		emailMsg.setSubject("Registration successful!");
		emailMsg.setFrom("admin@random.asia");

		try {
			emailService.sendEmail(emailMsg);
			System.out.println("Email sent successfully!");

		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}*/

	}

	@Override
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}

}