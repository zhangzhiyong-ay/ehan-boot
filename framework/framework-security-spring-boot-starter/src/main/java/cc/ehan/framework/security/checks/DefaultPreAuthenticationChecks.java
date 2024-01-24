package cc.ehan.framework.security.checks;

import cc.ehan.common.base.constant.constant.MessageSourceCodeStandard;
import cc.ehan.common.base.utils.MessageSourceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

@Slf4j
public class DefaultPreAuthenticationChecks implements UserDetailsChecker {
    @Override
    public void check(UserDetails user) {
        if (!user.isAccountNonLocked()) {
            if (log.isDebugEnabled()) {
                log.debug("Failed to authenticate since user account is locked");
            }
            throw new LockedException(
                    MessageSourceUtils.message(MessageSourceCodeStandard.ORGANIZATION_USER_ACCOUNT_LOCKED)
            );
        }
        if (!user.isEnabled()) {
            if (log.isDebugEnabled()) {
                log.debug("Failed to authenticate since user account is disabled");
            }
            throw new DisabledException(
                    MessageSourceUtils.message(MessageSourceCodeStandard.ORGANIZATION_USER_ACCOUNT_DISABLED)
            );
        }
        if (!user.isAccountNonExpired()) {
            if (log.isDebugEnabled()) {
                log.debug("Failed to authenticate since user account has expired");
            }
            throw new AccountExpiredException(
                    MessageSourceUtils.message(MessageSourceCodeStandard.ORGANIZATION_USER_ACCOUNT_EXPIRED)
            );
        }
    }
}
