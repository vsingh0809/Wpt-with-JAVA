package com.app.pages;

import static com.app.utils.DBUtils.closeConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDaoImpl candidateDao;
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter() ) {
          
			pw.print("admin has login");
			HttpSession hs=request.getSession();
		
			
			
				pw.print("<h3 align='center'> Top Candidates </h3>");
				// 2. get candidate dao from session
				CandidateDaoImpl dao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
				// 3. invoke dao's method to get list of candidates
				List<Candidate> candidateList = dao.getTop2Candidate();
				// 4. dynamic form generation
				pw.print("<form action='logout' method='post'>");
				for (Candidate c : candidateList) {
					pw.print("<h5>" + c.getCandidateId()+" "
							+ c.getCandidateName() + " " + c.getParty() +" "+c.getVotes()+ "</h5>");
				}
				
				HttpSession ss=request.getSession();
				CandidateDaoImpl ddd = (CandidateDaoImpl) ss.getAttribute("candidate_dao");
				System.out.println(ddd);
				List<Candidate> partyList = ddd.getPartyWiseVote();
				pw.print("</form>");
				pw.print("<form action='logout' method='post'>");
				for (Candidate c :partyList) {
					pw.print("<h5>" + c.getParty() +" "+c.getVotes()+ "</h5>");
				}
				
				pw.print("</form>");
	
			
			
		} catch (Exception e) {
			
		}
		
	}

	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * doGet(request, response); }
	 */
}
