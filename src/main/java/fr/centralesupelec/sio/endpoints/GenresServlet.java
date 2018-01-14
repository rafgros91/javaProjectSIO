package fr.centralesupelec.sio.endpoints;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.MovieGenre;

import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * A servlet to access the list of {@link MovieGenre}s.
 */

@WebServlet(urlPatterns = "/genres")
public class GenresServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get genres from the repository.
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

        // Get a list of all the directors of the movies
        List<String> genres = MoviesRepository.getInstance().getGenres();

        // Cast to a TreeSet to obtain an ordered list of unique elements and apply pagination parameters
        Set<String> uniqueGenres = new TreeSet<>(genres);
        uniqueGenres = uniqueGenres.stream().limit(limit).skip(offset)
                .collect(Collectors.toCollection(TreeSet::new));

        // Write to the response.
        ResponseHelper.writeJsonResponse(resp, uniqueGenres);

    }

}