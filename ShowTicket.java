package HW12Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TicketEntryManager;

/**
 * Servlet implementation class ShowTicket
 */
@WebServlet("/ShowTicket")
public class ShowTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		TicketEntryManager entryManager=new TicketEntryManager();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Ticket information</title>");
		out.println("</head>");
		out.println("<body>");
		
		int code=0;
		try{
		code=Integer.parseInt(request.getParameter("TicketCode"));
		System.out.println(code);
		}catch(Exception e){
			e.printStackTrace();
		}
		Ticket ticket=entryManager.showTicketByNumber(code);
		if(ticket!=null){
			//means the code was right 
			out.println("<br>");
			out.println("<b>Ticket information with code '"+code+"' :</b>");
			out.print("<b>");
			out.println("<br>");
			out.print("customer name:");out.println(ticket.getCustomerName());
			out.println("<br>");
			out.print("origin:");out.println(ticket.getOrigin());
			out.println("<br>");
			out.print("destination:");out.println(ticket.getDestination());
			out.println("<br>");
			out.print("flight number:");out.println(ticket.getFlightNumber());
			out.println("<br>");
			out.print("date:");out.println(ticket.getDate());
			out.println("<br>");
			
			out.print("</b>");
			
			
			
			
			
		}else{
			//means the code is wrong
			out.println("<b>");
			out.println("wrong Ticket code enter again");
			out.print("enterd code was:");out.print(code);
			out.println("</b>");
			
		}
		
		out.println("<br>");
    	out.println("<br>");
    	out.println("<a href=\"Ticket.html\">");
		out.println("<b>go to first page</b>");
		out.println("</a>");
		

		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
