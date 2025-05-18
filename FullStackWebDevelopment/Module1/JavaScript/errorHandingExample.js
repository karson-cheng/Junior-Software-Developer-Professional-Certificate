function fetchUserData() {
    try {
        // Simulate an API request with a 50% chance of failure
        let success = Math.random() > 0.5;
        
        // Simulate asynchronous operation using a timeout
        setTimeout(() => {
            if (!success) {
                throw new Error("Failed to fetch user data. Network error.");
            } else {
                console.log("User data fetched successfully.");
            }
        }, 1000);
        
    } catch (error) {
        // Catch the error and display an error message
        console.log("Error:", error.message);
    } finally {
        // Always executed whether there is an error or not
        console.log("Fetch user data operation complete.");
    }
}

// Call the function
fetchUserData();

function validateUserForm(userData) {
    try {
        // Validate name: must be a non-empty string
        if (typeof userData.name !== "string" || userData.name.trim() === "") {
            throw new Error("Invalid name. Name cannot be empty.");
        }


        // Validate age: must be a positive integer
        if (typeof userData.age !== "number" || userData.age <= 0 || !Number.isInteger(userData.age)) {
            throw new Error("Invalid age. Age must be a positive integer.");
        }


        // Validate email: Check if it contains @ in email id
        if (!emailRegex.includes('@')) {
            throw new Error("Invalid email format.");
        }


        // Log success message if all validations pass
        console.log("User form is valid:", userData);


    } catch (error) {
        // Handle validation errors by logging the error message
        console.log("Validation Error:", error.message);


    } finally {
        // Finalize by logging a completion message
        console.log("Validation process completed.");
    }
}


// Example test cases
validateUserForm({ name: "Alice", age: 25, email: "alice@example.com" }); // Should pass
validateUserForm({ name: "", age: 25, email: "alice@example.com" });       // Should fail (invalid name)
validateUserForm({ name: "Alice", age: -1, email: "alice@example.com" });  // Should fail (invalid age)
validateUserForm({ name: "Alice", age: 25, email: "alice@com" });          // Should fail (invalid email)