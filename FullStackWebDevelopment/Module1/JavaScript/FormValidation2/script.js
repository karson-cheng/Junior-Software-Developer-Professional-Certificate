// Function to validate form inputs
function validateForm() {
    // Get form input values
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    let valid = true;

    // Clear previous error messages
    document.getElementById("nameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";

    // Check if the name field is empty
    if (name === "") {
        document.getElementById("nameError").innerHTML = "Name is required!";
        valid = false;
    }

    // Check if the email field is empty
    if (email === "") {
        document.getElementById("emailError").innerHTML = "Email is required!";
        valid = false;
    }

    // Check if the password field is empty or too short
    if (password === "") {
        document.getElementById("passwordError").innerHTML = "Password is required!";
        valid = false;
    } else if (password.length < 8) {
        document.getElementById("passwordError").innerHTML = "Password must be at least 8 characters long!";
        valid = false;
    }

    // Check if the confirm password field matches the password
    if (confirmPassword !== password) {
        document.getElementById("confirmPasswordError").innerHTML = "Passwords do not match!";
        valid = false;
    }

    // Prevent form submission if validation fails
    return valid;
}