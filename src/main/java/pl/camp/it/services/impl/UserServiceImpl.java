package pl.camp.it.services.impl;

import org.springframework.stereotype.Service;
import pl.camp.it.model.User;
import pl.camp.it.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser1() {
        // jakis dodatkowy nowy kawałek kodu
        System.out.println("Wykonanie metody getUser1 z serwisu !!");
        return new User(1, "mateusz", "mateusz");
    }

    @Override
    public User getUser2() {
        System.out.println("Wykonanie metody getUser2 z serwisu !!");
        return new User(2, "janusz", "janusz");
    }

    @Override
    public User getUser3() {
        System.out.println("Wykonanie metody getUser3 z serwisu !!");
        return new User(3, "wiesiek", "wiesiek");
    }
}
