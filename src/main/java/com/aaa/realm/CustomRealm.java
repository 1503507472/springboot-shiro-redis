package com.aaa.realm;

import com.aaa.model.PermInfo;
import com.aaa.model.UserInfo;
import com.aaa.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:55
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     *用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        String userName = ((String) principalCollection.getPrimaryPrincipal());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        /**
         * 1,1，根据用户名去数据库中查询该用户所拥有的权限
         * 2，查询出权限之后 给simpleAuthorizationInfo
         */

        List<PermInfo> permInfos = userService.getPermsByUserName(userName);
        if (permInfos==null||permInfos.isEmpty()) {

        }else {
            for (PermInfo permInfo : permInfos) {
                simpleAuthorizationInfo.addStringPermission(permInfo.getResourcePermName());
            }
        }

        return simpleAuthorizationInfo;

    }

    /**
     *用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal = (String) authenticationToken.getPrincipal();
        //从数据库中查询该该用户是否存在

        authenticationToken.getCredentials();

        UserInfo userInfo = userService.getUserByUserName(principal);

        if (userInfo == null) {
            throw new UnknownAccountException("用户名不存在");
        }

        if (userInfo.getUserStatus() == 0) {
            throw new LockedAccountException("该用户已经被锁定");
        }
        /**
         * Object principal, 身份信息
         * Object hashedCredentials,  凭证信息
         * ByteSource credentialsSalt, 盐值 加点盐
         * String realmName 当前realm的名字
         */
        ByteSource byteSource = new SimpleByteSource(principal);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo.getUserName(), userInfo.getUserPassword(), byteSource,this.getName());

        return simpleAuthenticationInfo;
    }
}
