package com.curso.RentaCar.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Model.User;


@Component
public class MapperSrvUserImpl  implements MapperServices<UserDTO, User> {

	

		
		@Override
		public UserDTO mapToDto(User user) {
			final UserDTO userDto = new UserDTO();
			if (Optional.ofNullable(user).isPresent()) {
				userDto.setId(user.getId());
				userDto.setDni(user.getDni());
				userDto.setName(user.getName());
			}
			return userDto;
		}

		@Override
		public User mapToEntity(UserDto dto) {
			final User user = new User();
			if (Optional.ofNullable(dto).isPresent()) {
				user.setIdCar(dto.getIdCar());
				user.setName(dto.getName());
			}
			return user;
		}

		@Override
		public Page<UserDto> mapPageToDto(Page<User> pageEntity) {
			return pageEntity.map(b-> mapToDto(b));
		}

		@Override
		public List<UserDto> mapListToDto(List<User> listUser) {
			final List<UserDto> listUserDTO = new ArrayList<>();
			listUser.forEach((b)-> {
				final UserDto userDTO = mapToDto(b);			
				listUserDTO.add(userDTO);		
			});
			return listUserDTO;
		}

}
