package com.epam.util.aspects;

import com.epam.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Yevhen_Vasyliev on 10.08.2015.
 */
@Aspect
@Component
public class DiscountAspect {

    private Map<Long, Map<String, Integer>> userDiscount;

    public DiscountAspect() {
        userDiscount = new HashMap<>();
    }

    @AfterReturning(pointcut = "execution(* com.epam.util.discount.api.DiscountStrategy.getDiscount(..))", returning = "discount")
    public void checkDiscount(JoinPoint joinPoint, int discount) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Aspect is working!!!!");
        if (joinPoint.getArgs()[0] instanceof User) {
            User user = (User) joinPoint.getArgs()[0];

            String discountName = ClassUtils.getShortName(joinPoint.getTarget().getClass());
            if (discount != 0) {
                updateUserDiscount(user, discountName);
            }
            System.out.println("Added user discount." + user);
        } else {
            System.out.println("Wrong type of method argument.");
            throw new ClassCastException();
        }
    }

    private void updateUserDiscount(User user, String discountName) {
        if (userDiscount.containsKey(user.getId())) {
            Map<String, Integer> userDiscounts = userDiscount.get(user.getId());
            updateDiscountByName(discountName, userDiscounts);
        }
        updateDiscountByName(discountName, new HashMap<>());
    }

    private void updateDiscountByName(String discountName, Map<String, Integer> userDiscounts) {
        if (userDiscounts.containsKey(discountName)) {
            int countDiscount = userDiscounts.get(discountName);
            userDiscounts.put(discountName, countDiscount + 1);
        } else {
            userDiscounts.put(discountName, 1);
        }
    }

}
