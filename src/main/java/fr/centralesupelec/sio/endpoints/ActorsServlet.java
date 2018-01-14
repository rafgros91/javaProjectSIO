package fr.centralesupelec.sio.endpoints;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Actor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * A servlet to access the list of {@link Actor}s.
 */

@WebServlet(urlPatterns = "/actors")
public class ActorsServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get actors from the repository.
        //Pagination parameters
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

        // Get a list of all the actors in the movies
        List<String> actors = MoviesRepository.getInstance().getActors();

        // Cast to a TreeSet to obtain an ordered list of unique elements and apply pagination parameters
        Set<String> uniqueActors = new TreeSet<>(actors);
        uniqueActors = uniqueActors.stream().limit(limit).skip(offset)
                .collect(Collectors.toCollection(TreeSet::new));

        // Write to the response.
        ResponseHelper.writeJsonResponse(resp, uniqueActors);

    }
}
