package fr.centralesupelec.sio.endpoints;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to access the list of {@link Movie}s.
 */
// The following pattern will exactly match /movies only.
@WebServlet(urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get movies from the repository.
        String titleParameter = req.getParameter("title");
        String genreParameter = req.getParameter("genre");
        String directorParameter = req.getParameter("director");
        String actorParameter = req.getParameter("actor");
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

        // Manage all the other parameters
        if ((titleParameter == null || titleParameter.isEmpty())) {
            titleParameter = "_";
        }

        if ((genreParameter == null || genreParameter.isEmpty())) {
            genreParameter = "_";
        }

        if ((directorParameter == null || directorParameter.isEmpty())) {
            directorParameter = "_";
        }

        if ((actorParameter == null || actorParameter.isEmpty())) {
            actorParameter = "_";
        }

        List<Movie> movies = MoviesRepository.getInstance().getMoviesFilteredByParameters(titleParameter,
                genreParameter, directorParameter, actorParameter, limit, offset);
        // Write to the response.
        ResponseHelper.writeJsonResponse(resp, movies);

    }

}
