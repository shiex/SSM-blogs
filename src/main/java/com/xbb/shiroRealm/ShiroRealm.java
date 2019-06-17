package com.xbb.shiroRealm;

import com.xbb.pojo.User;
import com.xbb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 * @title: ShiroRealm
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\29 002919:44
 *
 * 通过 AuthenticatingRealm 的 credentialsMatcher 属性来进行密码的比对
 * 1：如何把一个字符串加密为MD5
 * 2：替换当前 Realm 的 credentialsMatcher属性，直接使用 HashedCredentialsMatcher 对象
 *    并设置加密算法即可
 *
 * 1：在 doGetAuthenticationInfo 方法返回值创建 SimpleAuthenticationInfo 对象的时候，需要使用
 *    new SimpleAuthenticationInfo(prinacipal, credentials, byteSource, realmName)构造器
 * 2：使用 ByteSource.Util.bytes() 来计算盐值
 * 3：盐值需要唯一：一般使用随机字符串或者user id
 * 4：使用 new SimpleHash(hashAlgorithmName, credentials, salt, hashTteraions) 来计算盐值加密后的密码的值
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /*
        执行登录：currentUser.login(token);传递token
        AuthenticationToken token：接收token
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException
    {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        User user = userService.findByUsername(username);
        if(user == null){
            throw  new UnknownAccountException("用户不存在!");
        }
        Session session= SecurityUtils.getSubject().getSession();
        session.setAttribute("SESSION_USER", user);
        // 计算盐值
        ByteSource byteSource = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user.getUsername(), user.getPassword(), byteSource, this.getName());
        return info;
    }

    // 授权会被 shiro 回调的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        /*System.out.println("doGetAuthorizationInfo：授权");
        // 1. 从 PrincipalCollection 中来获取登录用户的信息
        Object principal = principals.getPrimaryPrincipal();

        // 2. 利用登录的用户信息来获取当前用户角色权限（可能需要查询数据库）
        Set<String> roles = new HashSet<>();
        roles.add("user"); // 如果以user角色登录，则只有user一个权限（只可访问1个）
        if("admin".equals(principal)){
            roles.add("admin"); // 以admin登录，同时拥有2个权限（可访问2个）
        }
        // 3. 创建 SimpleAuthorizationInfo，并设置 roles 属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
*/
        // 4. 返回 SimpleAuthorizationInfo 对象
        return null;
    }



}
