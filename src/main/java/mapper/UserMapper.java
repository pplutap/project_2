package mapper;


import domain.User;
import domain.UserDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getContent());
    }
    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getContent());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getName(), t.getContent()))
                .collect(Collectors.toList());
    }
}
