package com.loganhere.usercard;

import org.springframework.web.bind.annotation.*;

//Комментарии делаю для себя, чтобы понимать, как всё работает

@RestController //Этот класс обрабатывает HTTP запросы в нём @Controller и @ResponseBody
@RequestMapping("/users") // Все URL внутри этого класса будут начинаться с эндпоинта /users
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping //Вызывает этот метод, когда клиент отправляет запрос на /users
    public User createUser(@RequestBody User user) { //Берёт json запрос и превращает его в User
        return userRepository.save(user);
    }

    @GetMapping("/{id}") //Так же, как и @PostMapping, только перекидывает на /user/{id}
    public User getUser(@PathVariable Long id) { //@PathVariable - вытягивает id из URL
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}") //@GetMapping, но для удаления
    public void deleteUser(@PathVariable Long id) { //@PathVariable - вытягивает id из URL
        userRepository.delete(id);
    }
    //@PostMapping если бы я хотел изменить значение
}
