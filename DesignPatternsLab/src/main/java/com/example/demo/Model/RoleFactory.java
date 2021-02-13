//Class Factory
package com.example.demo.Model;

import org.springframework.stereotype.Component;

//Should always be public
@Component
public class RoleFactory {

	public Role createRole(String role) {
		switch(role) {
		case "admin":
			return new Admin();
		case "member":
			return new Member();
		default:
			throw new UnsupportedOperationException("Role unsupported");
		}
	}
}
