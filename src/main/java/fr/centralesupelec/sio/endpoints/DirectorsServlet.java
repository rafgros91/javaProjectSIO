package fr.centralesupelec.sio.endpoints;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Director;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * A servlet to access the list of {@link Director}s.
 */

@WebServlet(urlPatterns = "/directors")
public class DirectorsServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get directors from the repository.
        //Parameters
        String limitParameter = req.getParameter("limit");
        String offsetParameter = req.getParameter("offset");
        int limit;
        int offset;

        // Manage limit parameter (default value of 15).
        if (limitParameter == null || limitParameter.isEmpty()) {
            limit= 15;
        }
        else {
            limit = Integer.parseInt(limitParameter);
        }

        // Manage offset parameter (default value of 0).
        if (offsetParameter == null || offsetParameter.isEmpty()) {
            offset = 0;
        }
        else {
            offset = Integer.parseInt(offsetParameter);
        }

        // Get a list of all the directors in the movies
        List<String> directors = MoviesRepository.getInstance().getDirectors();
        // Cast to a TreeSet to obtain an ordered list of unique elements
        Set<String> uniqueDirectors = new TreeSet<>(directors);
        uniqueDirectors = uniqueDirectors.stream().limit(limit).skip(offset).collect(Collectors.toSet());

        // Write to the response.
        ResponseHelper.writeJsonResponse(resp, uniqueDirectors);

    }
}
