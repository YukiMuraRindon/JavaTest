package com.bookstore.service;

import com.bookstore.dao.admindao;
import com.bookstore.po.Admin;

public class adminservice {
	public Admin login(Admin admin) {
		admindao a = new admindao();
		String sql ="select * from t_admin where adminname = ? and adminpwd = ?";
		Object[] params = {admin.getAdminname(),admin.getAdminpwd()};
		return a.get(sql,Admin.class,params);
	}
}
