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
 * Servlet implementation class InsertTicket
 */
@WebServlet("/InsertTicket")
public class InsertTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertTicket() {
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
        System.out.println(name+" "+origin+" "+destination+" "+flightNumber+" "+Date);
        //inserting the ticket into database
        int key=entryManager.addTicket(new Ticket(name, origin, destination, Date, flightNumber, 0));
        if(key==0){
        	//means the ticket could'nt get saved
        	out.println("<b>operation failed</b>");
        	
        }else{
        	out.println("<br>");
        	out.println("<br>");
        	out.println("<b>Ticket reserved successfully</b>");
        	out.print("<b>");
        	out.print("your Ticket code is:"); out.print(key);
        	out.print("</b>");
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
