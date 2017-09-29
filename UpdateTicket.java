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
 * Servlet implementation class UpdateTicket
 */
@WebServlet("/UpdateTicket")
public class UpdateTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTicket() {
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
        out.println("<title>Ticket Reservation</title>");
        out.println("</head>");
        out.println("<body>");
        
        //making a new Ticket
        String name=request.getParameter("name");
        String origin=request.getParameter("origin");
        String destination=request.getParameter("destination");
        int flightNumber=Integer.parseInt(request.getParameter("flightNumber"));
        String Date=request.getParameter("date");
        int TicketCode=Integer.parseInt(request.getParameter("TicketNumber"));
        System.out.println(name+" "+origin+" "+destination+" "+flightNumber+" "+Date+" "+TicketCode);
        //inserting the ticket into database
        boolean status=entryManager.updateTicket(new Ticket(name, origin, destination, Date, flightNumber, TicketCode), TicketCode);
        if(!status){
        	//means the ticket could'nt get saved
        	out.println("<b>worng Ticket code</b>");
        	out.print("<br>");
        	out.print("enterd code was:");out.print(TicketCode);
        	
        }else{
        	out.println("<br>");
        	out.println("<br>");
        	out.println("<b>Ticket updates successfully</b>");
        	out.print("<b>");
        	
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
