package com.son.controller.hb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HBAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
