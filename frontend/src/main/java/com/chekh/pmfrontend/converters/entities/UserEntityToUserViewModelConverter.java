package com.chekh.pmfrontend.converters.entities;


import com.chekh.pmfrontend.beans.UserViewModel;
import com.chekh.pmbackend.impl.entities.UsersEntity;
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
