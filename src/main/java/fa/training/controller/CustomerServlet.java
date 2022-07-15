package fa.training.controller;

import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;
import fa.training.repository.impl.CustomerRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/customers/**", asyncSupported = true, loadOnStartup = 1)
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CustomerRepository customerRepo = new CustomerRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/showAddPage":
                    showAddPage(request, response);
                    break;
                case "/addProcess":
                    addProcess(request, response);
                    break;
                case "/show-edit-page":
                    showEditPage(request, response);
                    break;
//                case "/edit-process":
//                    editProcess(request, response);
//                    break;
                case "/delete":
                    deleteCustomer(request, response);
                    break;
                case "list":
                    listCustomers(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void showAddPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addCustomer.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addProcess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customerCode = request.getParameter("customerCode");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Customer customer = new Customer(customerCode, fullName, address, phone, email);
        customerRepo.save(customer);
        response.sendRedirect("list");
    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customerCode = request.getParameter("customerCode");
        Customer customer = customerRepo.findById(customerCode);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../webapp/pages/addCustomer.jsp");
        request.setAttribute("customer", customer);
        requestDispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customerCode = request.getParameter("customerCode");
        customerRepo.delete(customerCode);
        response.sendRedirect("list");
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> customers = customerRepo.findAll();
        request.setAttribute("customerList", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/listCustomer.jsp");
        requestDispatcher.forward(request, response);
    }

}
