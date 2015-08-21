package com.epam.controller.util;

import com.epam.DTO.UserFormBean;
import com.epam.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by Yevhen_Vasyliev on 21.08.2015.
 */
@Component
public class ConverterUserDtoToUser {

    public User convert(UserFormBean userFormBean){
        User user = new User();
        user.setFirstName(userFormBean.getFirstName());
        user.setLastName(userFormBean.getLastName());
        user.setEmail(userFormBean.getEmail());
        user.setBirthday(userFormBean.getBirthday());
        return null;
    }
}
