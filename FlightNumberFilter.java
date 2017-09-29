package Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ReserveFilter
 */
@WebFilter(description = "filtering for reserving a ticket", urlPatterns = { "/ReserveFilter" })
public class FlightNumberFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FlightNumberFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter();
		
		
		//flight number check
		boolean flightNumberCheck=flightNumberValidation(Integer.parseInt(request.getParameter("flightNumber")));
		if(flightNumberCheck){
			//means the flight number is right
			chain.doFilter(request, response);
		}else{
			out.println("wrong flight number");
			RequestDispatcher rd=request.getRequestDispatcher("Ticket.html");  
		    rd.include(request, response);  
		}

		/*// pass the request along the filter chain
		chain.doFilter(request, response);*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	
	
	public boolean flightNumberValidation(int flightNumber){
		//flight number must be a three digit number
		if(digitCounter(flightNumber)!=3){
			return false;
		}else{
			return true;
		}
		
	}
	
	
	private int digitCounter(int number){
		int count=1;
		while(number>=10){
			number/=10;
			count++;
			
		}
		return count;
		
	}

}
