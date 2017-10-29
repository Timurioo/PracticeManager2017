package com.netcracker.etalon.converters.entities;


import com.netcracker.etalon.beans.UserViewModel;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToUserViewModelConverter implements Converter<UsersEntity, UserViewModel> {

    public UserViewModel convert(UsersEntity usersEntity) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setId(String.valueOf(usersEntity.getId()));
        userViewModel.setLogin(usersEntity.getLogin());
        userViewModel.setPassword(usersEntity.getPassword());
        userViewModel.setRole(usersEntity.getRole());
        return userViewModel;
    }
}
