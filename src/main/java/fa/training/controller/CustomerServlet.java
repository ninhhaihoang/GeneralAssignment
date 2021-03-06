package fa.training.controller;

import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;
import fa.training.repository.impl.CustomerRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/customers/*", asyncSupported = true, loadOnStartup = 1)
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CustomerRepository customerRepo = new CustomerRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();

        try {
            switch (action) {
                case "/show-add-page":
                    showAddPage(request, response);
                    break;
                case "/add-process":
                    addProcess(request, response);
                    break;
                case "/show-edit-page":
                    showEditPage(request, response);
                    break;
                case "/edit-process":
                    editProcess(request, response);
                    break;
                case "/delete":
                    deleteCustomer(request, response);
                    break;
                case "/list":
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
        String errorMessage = "M?? kh??ch h??ng ???? t???n t???i";

        String customerCode = request.getParameter("customerCode");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        if (customerRepo.findById(customerCode) != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addCustomer.jsp");
            requestDispatcher.forward(request, response);
        }
        if (customerRepo.findById(customerCode) == null) {
            Customer customer = new Customer(customerCode, fullName, address, phone, email);
            customerRepo.save(customer);
            response.sendRedirect("list?pageNumber=1");
        }
    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customerCode = request.getParameter("id");
        System.out.println(customerCode);
        Customer customer = customerRepo.findById(customerCode);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addCustomer.jsp");
        request.setAttribute("customer", customer);
        requestDispatcher.forward(request, response);
    }

    private void editProcess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String customerCode = request.getParameter("customerCode");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Customer customer = new Customer(customerCode, fullName, address, phone, email);
        customerRepo.save(customer);
        response.sendRedirect("list?pageNumber=1");

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customerCode = request.getParameter("id");
        System.out.println("delete id: " + customerCode);
        customerRepo.delete(customerCode);
        response.sendRedirect("list?pageNumber=1");
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        List<Customer> customers;
        Map<String, Object> resMap = customerRepo.findAll(pageNumber);
        Object obj = resMap.get("customers");
        customers = (ArrayList) obj;
        request.setAttribute("customerList", customers);
        request.setAttribute("totalPages", (Integer) resMap.get("totalPages"));
        request.setAttribute("currentPage", pageNumber);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/listCustomer.jsp");
        requestDispatcher.forward(request, response);
    }

}
