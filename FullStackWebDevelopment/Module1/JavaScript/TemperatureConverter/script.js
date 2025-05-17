function convertToFahrenheit(){
    let celsius  = document.getElementById("celsiusInput").value;
    if (celsius  === "") {
        alert("Input cannot be empty!");
        return false; // Prevent form submission
    }
    document.getElementById("result").innerHTML = "The resulte is " + (celsius * 9/5) + 32;
}