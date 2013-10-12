package cn.net.chenjun.s2sh.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected void writeJson(String json) {
		try {
			getResponse().setCharacterEncoding("utf-8");
			getResponse().setContentType("text/html; charset=utf-8");
			getResponse().getWriter().write(json);
			getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
