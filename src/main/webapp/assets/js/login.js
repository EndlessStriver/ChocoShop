document.addEventListener("DOMContentLoaded", function () {
    const loginButton = document.querySelector('button[name="login"]');
    const forgotPasswordLink = document.querySelector('a[name="forgot"]');
    const signUpLink = document.querySelector('a[name="signUp"]');

    loginButton.addEventListener("click", function (event) {
        event.preventDefault();
        const username = document.querySelector('input[name="userName"]').value;
        const password = document.querySelector('input[name="password"]').value;

        if (username === "" || password === "") {
            alert("Please fill in all fields.");
        } else {
            alert(`Logging in with:\nEmail: ${username}\nPassword: ${password}`);
        }
    });

    forgotPasswordLink.addEventListener("click", function (event) {
        event.preventDefault();
        alert("Redirecting to password recovery...");
        // window.location.href = "forgot-password.html"; // Uncomment and change URL if needed
    });

    signUpLink.addEventListener("click", function (event) {
        event.preventDefault();
        alert("Redirecting to sign up page...");
        // window.location.href = "sign-up.html"; // Uncomment and change URL if needed
    });
});
