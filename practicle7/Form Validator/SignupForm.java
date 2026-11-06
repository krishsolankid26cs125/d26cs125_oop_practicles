public class SignupForm {

    @NotBlank
    private String name;

    @NotBlank
    @MaxLength(20)
    private String username;

    @NotBlank
    @MaxLength(50)
    private String email;

    public SignupForm(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
