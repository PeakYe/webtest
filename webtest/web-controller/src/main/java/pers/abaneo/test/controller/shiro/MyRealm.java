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
	 * ��Ȩ���̡���������Դ��û��Ȩ�޵�ʱ�����е���
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
	 * ��֤���� ���ڵ�¼��ʱ�����û��������token�������token����У�顣�ɹ������û���֤��Ϣ��ʧ�ܻ��׳����ֲ�ͬ�쳣
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken atoken) throws AuthenticationException {
		UsernamePasswordToken token =(UsernamePasswordToken) atoken;
		
		//�����û�����ѯ�û����������ô������
		User user=new User();
		user.setLoginName(token.getUsername());
		user.setLoginPassword("123456");
		
		
		//������Զ�У�����룬����Ҫ�Լ��ж�
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getLoginName(),user.getLoginPassword(),getName());
		return info;
	}

}
