package  com.smart.user.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{
	private String id;
	private String name;
	private String email;
	private String phone;
	private String status;
	
	private String password;
	private String role;
	
//	public UserDTO() {}
//	
//	public UserDTO(String id,String name,String email,String phone,String status) {
//		this.id=id;
//		this.name=name;
//		this.email=email;
//		this.phone=phone;
//		this.status=status;
//	}
	
}