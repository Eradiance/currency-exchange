package org.example.servlets;

import org.example.models.Currency;
import org.example.repositories.CurrencyRepository;
import org.example.repositories.CurrencyRepositoryInMemoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet("/currencies")
public class GetCurrenciesServlet extends HttpServlet {
    private CurrencyRepository currencyRepo;

    @Override
    public void init() throws ServletException {
        this.currencyRepo = new CurrencyRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Currency> currencies  = currencyRepo.findAll();
        req.setAttribute("currenciesFromServer", currencies);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/currencies.jsp");
        dispatcher.forward(req, resp);

      /*  Writer out = resp.getWriter();
        out.write(String.valueOf(currencies.get(1).toString()));
        out.write(String.valueOf(currencies.get(2).toString()));
        out.write(String.valueOf(currencies.get(0).toString()));*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String fullName = req.getParameter("name");
        String sign = req.getParameter("sign");

        Currency currency = new Currency(code, fullName, sign);
        currencyRepo.save(currency);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
