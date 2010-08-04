package info.yalamanchili.security.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import net.sf.gilead.pojo.gwt.LightEntity;

import org.jboss.seam.annotations.security.management.RoleName;

@Entity
public class YRole extends LightEntity {

	public static final long serialVersionUID = 5472657332417332843L;
	public Integer roleId;
	public String rolename;

	@Id
	@GeneratedValue
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@RoleName
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
