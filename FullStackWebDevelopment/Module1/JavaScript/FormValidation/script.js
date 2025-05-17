function validateForm() {
    let email = document.getElementById("emailInput").value;
    if (email === "") {
        alert("Email cannot be empty!");
        return false; // Prevent form submission
    }
}