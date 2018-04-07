package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {

        if (user == null || permission == null || permissions.size() == 0) {
            return false;
        }

        if (securityChecker.isAdmin() || isUserHasPermission(user, permission, permissions)) {
            return true;
        }
        return false;

    }

    private boolean isUserHasPermission(User user, Permission permission, ImmutableList<Permission> permissions) {
        return this.securityChecker.checkPermission(user, permission) || permissions.contains(permission);
    }
}
