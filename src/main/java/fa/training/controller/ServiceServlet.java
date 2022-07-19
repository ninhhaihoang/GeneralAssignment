package fa.training.controller;

import fa.training.model.Service;
import fa.training.repository.ServiceRepository;
import fa.training.repository.impl.ServiceRepositoryImpl;

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

@WebServlet(urlPatterns = "/services/*", asyncSupported = true, loadOnStartup = 1)
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ServiceRepository serviceRepo = new ServiceRepositoryImpl();

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
                    deleteService(request, response);
                    break;
                case "/list":
                    listService(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void showAddPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addService.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addProcess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String errorMessage = "Mã dịch vụ đã tồn tại";

        String serviceCode = request.getParameter("serviceCode");
        String serviceName = request.getParameter("serviceName");
        String unit = request.getParameter("unit");
        long price = Long.parseLong(request.getParameter("price"));

        if (serviceRepo.findById(serviceCode) != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addService.jsp");
            requestDispatcher.forward(request, response);
        }
        if (serviceRepo.findById(serviceCode) == null) {
            Service service = new Service(serviceCode, serviceName, unit, price);
            serviceRepo.save(service);
            response.sendRedirect("list?pageNumber=1");
        }
    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String ServiceCode = request.getParameter("id");
        System.out.println(ServiceCode);
        Service service = serviceRepo.findById(ServiceCode);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addService.jsp");
        request.setAttribute("service", service);
        requestDispatcher.forward(request, response);
    }

    private void editProcess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String serviceCode = request.getParameter("serviceCode");
        String serviceName = request.getParameter("serviceName");
        String unit = request.getParameter("unit");
        long price = Long.parseLong(request.getParameter("price"));
        Service service = new Service(serviceCode, serviceName, unit, price);
        serviceRepo.save(service);
        response.sendRedirect("list?pageNumber=1");

    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String serviceCode = request.getParameter("id");
        System.out.println("delete id: " + serviceCode);
        serviceRepo.delete(serviceCode);
        response.sendRedirect("list?pageNumber=1");
    }

    private void listService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        List<Service> services;
        Map<String, Object> resMap = serviceRepo.findAll(pageNumber);
        Object obj = resMap.get("services");
        services = (ArrayList) obj;
        request.setAttribute("serviceList", services);
        request.setAttribute("totalPages", (Integer) resMap.get("totalPages"));
        request.setAttribute("currentPage", pageNumber);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/listService.jsp");
        requestDispatcher.forward(request, response);
    }
}
