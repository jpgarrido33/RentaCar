package com.curso.RentaCar.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Model.User;


@Component
public class MapperSrvUserImpl  implements MapperServices<UserDto, User> {

	

		
		@Override
		public UserDto mapToDto(User user) {
			final UserDto userDto = new UserDto();
			if (Optional.ofNullable(user).isPresent()) {
				userDto.setIdUser(user.getIdUser());
				userDto.setName(user.getName());
			}
				return userDto;
		}

		@Override
		public User mapToEntity(UserDto dto) {
			final User user = new User();
			if(Optional.of(dto).isPresent()){
				user.setIdUser(dto.getIdUser());
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
			final List<UserDto> listUserDto = new ArrayList<>();
			listUser.forEach((b)-> {
				final UserDto userDto = mapToDto(b);			
				listUserDto.add(userDto);		
			});
			return listUserDto;
		}

}
