package com.lzp.common;

import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.admin.servlet.AdminServlet;

public class ProxoolAdminServlet  extends AdminServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		ProxoolFacade.shutdown();
		super.destroy();
	}
}
