package fr.centralesupelec.sio.model;

/**
 * An entity class for an access token response.
 */
public class Token {

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String access_token) {
        this.accessToken = access_token;
    }

}
