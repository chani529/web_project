package com.son.controller.st;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
