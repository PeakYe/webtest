package pers.abaneo.test.controller.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends  AuthorizingRealm{

	/**
	 * 授权过程。在请求资源而没有权限的时候会进行调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		
		Set<String> role =new HashSet<>();
		role.add("admin");
		info.setRoles(role);
		
		Set<String> permissions =new HashSet<>();
		permissions.add("admin");
		permissions.add("test");
		info.setStringPermissions(permissions);
		
		return info;
	}

	/**
	 * 认证过程 。在登录的时候传入用户名密码的token，这里对token进行校验。成功返回用户认证信息，失败会抛出各种不同异常
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken atoken) throws AuthenticationException {
		UsernamePasswordToken token =(UsernamePasswordToken) atoken;
		
		//根据用户名查询用户，这里用用创建替代
		User user=new User();
		user.setLoginName(token.getUsername());
		user.setLoginPassword("123456");
		
		
		//这里会自动校验密码，不需要自己判断
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getLoginName(),user.getLoginPassword(),getName());
		return info;
	}

}
