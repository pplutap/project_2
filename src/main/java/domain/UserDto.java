package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String content;
}


/*public class UserDto {
    private Long id;
    private String name;
    private String content;


    public UserDto(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
*/



