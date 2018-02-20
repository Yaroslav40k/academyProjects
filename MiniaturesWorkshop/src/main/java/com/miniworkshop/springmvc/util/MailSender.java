package com.miniworkshop.springmvc.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailSender
 */
@WebServlet("/MailSender")
public class MailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailSender() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerName =request.getParameter("name");
		String customerEmailSubject =request.getParameter("subject");
		String customerMessage = request.getParameter("message");
		String customerEmail = request.getParameter("email");
		new Thread(new Runnable() {

			@Override
			public void run() {
				Date date = new Date();
				final String adminEmail = "1dmitriev.yaroslav1@gmail.com";
				final String password = "Sunnyboy";

				Session session = EmailUtil.createSession(adminEmail, password);
				EmailUtil.sendMessage(session,customerName, customerEmail,adminEmail, customerEmailSubject, customerMessage);
				Date date2 = new Date();
				System.out.println("Time spent: " + (date2.getTime() - date.getTime()));

			}
		}).start();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerName =request.getParameter("name");
		String customerEmailSubject =request.getParameter("subject");
		String customerMessage = request.getParameter("message");
		String customerEmail = request.getParameter("email");

		System.out.println("Thread is trying");
		new Thread(new Runnable() {

			@Override
			public void run() {
				Date date = new Date();
				final String adminEmail = "1dmitriev.yaroslav1@gmail.com";
				final String password = "Sunnyboy";

				Session session = EmailUtil.createSession(adminEmail, password);
				EmailUtil.sendMessage(session,customerName, customerEmail,adminEmail, customerEmailSubject, customerMessage);
				Date date2 = new Date();
				System.out.println("Time spent: " + (date2.getTime() - date.getTime()));

			}
		}).start();

	}

}
