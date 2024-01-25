package cc.ehan.modules.auth.admin.security;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class AccountUserDetails extends User {

    @Getter
    private final Long userId;

    public AccountUserDetails(Long userId, String username, String password, boolean enabled) {
        super(username, password, enabled, true, true, true, Collections.emptyList());
        this.userId = userId;
    }

}
