package com.github.woonsan.demo.spring.examples.mvc.form;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private Map<String, User> usersMap = new ConcurrentHashMap<>();
    {
        String id = "13c2ec8c-102c-4883-a282-3fe983e61515";
        User user = new User(id);
        user.setEmail("john@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(Calendar.YEAR, 1971);
        birthDate.set(Calendar.MONTH, Calendar.JANUARY);
        birthDate.set(Calendar.DATE, 5);
        user.setBirthDate(birthDate.getTime());
        usersMap.put(id, user);

        id = "04d6080b-2098-4eaf-90ee-7331caab5e91";
        user = new User(id);
        user.setEmail("jane@example.com");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        birthDate = Calendar.getInstance();
        birthDate.set(Calendar.YEAR, 1970);
        birthDate.set(Calendar.MONTH, Calendar.FEBRUARY);
        birthDate.set(Calendar.DATE, 7);
        user.setBirthDate(birthDate.getTime());
        usersMap.put(id, user);
    }

    public synchronized Set<String> getUserIds() {
        return new TreeSet<>(usersMap.keySet());
    }

    public synchronized User getUser(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must be non-null.");
        }

        User user = usersMap.get(id);

        if (user != null) {
            return cloneUser(user, user.getId());
        }

        return null;
    }

    public synchronized User addOrUpdateUser(final User user) {
        final String id = user.getId();
        User newUser = cloneUser(user, id);
        usersMap.put(id, newUser);
        return cloneUser(newUser, id);
    }

    public synchronized boolean deleteUser(final String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username must be non-null.");
        }

        final User user = usersMap.remove(username);
        return user != null;
    }

    private User cloneUser(final User source, final String id) {
        User clone = new User(id);
        clone.setPassword(source.getPassword());
        clone.setEmail(source.getEmail());
        clone.setFirstName(source.getFirstName());
        clone.setLastName(source.getLastName());
        clone.setBirthDate(source.getBirthDate());
        return clone;
    }
}
