package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;//todo: неправильно именование слоя ..Spring, Hibernate ..уже repository

    @Transactional//todo: выносим как типовую - над классом
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCarModelAndSeries(String model, int series) {//todo: пора избавляться от примитивов
        return userDao.getUserByCarModelAndSeries(model, series);
    }

}
