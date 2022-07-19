package fa.training.controller;

import fa.training.model.Computer;
import fa.training.repository.ComputerRepository;
import fa.training.repository.impl.ComputerRepositoryImpl;

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

@WebServlet(urlPatterns = "/computers/*", asyncSupported = true, loadOnStartup = 1)
public class ComputerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ComputerRepository computerRepo = new ComputerRepositoryImpl();

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
                    deleteComputer(request, response);
                    break;
                case "/list":
                    listComputer(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void showAddPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addComputer.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addProcess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String errorMessage = "Mã máy đã tồn tại";

        String computerCode = request.getParameter("computerCode");
        String location = request.getParameter("location");
        String status = request.getParameter("status");

        if (computerRepo.findById(computerCode) != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addComputer.jsp");
            requestDispatcher.forward(request, response);
        }
        if (computerRepo.findById(computerCode) == null) {
            Computer computer = new Computer(computerCode, location, status);
            computerRepo.save(computer);
            response.sendRedirect("list?pageNumber=1");
        }
    }

    private void showEditPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String computerCode = request.getParameter("id");
        System.out.println(computerCode);
        Computer computer = computerRepo.findById(computerCode);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/addComputer.jsp");
        request.setAttribute("computer", computer);
        requestDispatcher.forward(request, response);
    }

    private void editProcess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String computerCode = request.getParameter("computerCode");
        String location = request.getParameter("location");
        String status = request.getParameter("status");
        Computer computer = new Computer(computerCode, location, status);
        computerRepo.save(computer);
        response.sendRedirect("list?pageNumber=1");

    }

    private void deleteComputer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String computerCode = request.getParameter("id");
        System.out.println("delete id: " + computerCode);
        computerRepo.delete(computerCode);
        response.sendRedirect("list?pageNumber=1");
    }

    private void listComputer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        List<Computer> computers;
        Map<String, Object> resMap = computerRepo.findAll(pageNumber);
        Object obj = resMap.get("computers");
        computers = (ArrayList) obj;
        request.setAttribute("computerList", computers);
        request.setAttribute("totalPages", (Integer) resMap.get("totalPages"));
        request.setAttribute("currentPage", pageNumber);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/listComputers.jsp");
        requestDispatcher.forward(request, response);
    }

}
