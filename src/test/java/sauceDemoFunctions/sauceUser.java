package sauceDemoFunctions;

public enum sauceUser {
    STANDARD("standard_user", "secret_sauce"),
    LOCKED_OUT("locked_out_user", "secret_sauce"),
    PROBLEM("problem_user", "secret_sauce"),
    PERFORMANCE("performance_glitch_user", "secret_sauce"),
    ERROR("error_user", "secret_sauce"),
    VISUAL("visual_user", "secret_sauce");

    private final String username;
    private final String password;

    sauceUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
