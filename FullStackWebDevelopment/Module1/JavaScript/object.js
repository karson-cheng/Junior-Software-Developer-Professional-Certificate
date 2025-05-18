let fruits = ["apple", "banana", "cherry"]; // Using square brackets

let numbers = new Array(1, 2, 3, 4, 5); // Using the new Array() constructor

console.log(fruits[1]); // Output: banana

fruits.push("orange"); // Adds a new element to the end of the array
console.log(fruits); // Output: ["apple", "banana", "cherry", "orange"]

fruits.pop(); //Removes the last element from the array
console.log(fruits); // Output: ["apple", "banana", "cherry"]

fruits.shift(); // Removes the first element from the array
console.log(fruits); // Output: ["banana", "cherry"]

fruits.unshift("kiwi"); // Adds a new element to the beginning of the array
console.log(fruits); // Output: ["kiwi", "banana", "cherry"]

console.log(fruits.length); // Output: 3

// Executes a function for each element in the array
fruits.forEach(function(fruit) {
    console.log(fruit);
});

// Create a object - person
let person = {
    name: "Karson",
    age: 30,
    email: "karson@example.com"
};
console.log(person.name); // Output: Karson
console.log(person["email"]); // Output: karson@example.com
person.age = 31; // change the value of an existing property by reassigning it
console.log(person.age); // Output: 31
person.country = "Hong Kong"; // add a new property to an object by assigning it a value
console.log(person); // Output: {name: "Karson", age: 31, email: "karson@example.com", country: "Hong Kong"}
delete person.email; // remove a property from an object, use the delete keyword
console.log(person);// Output: {name: "Karson", age: 31, country: "Hong Kong"}


// Array of student objects
let students = [
        { name: "Alice", grades: [85, 90, 78] },
        { name: "Bob", grades: [70, 75, 80] },
        { name: "Charlie", grades: [95, 88, 92] }
        ];
// Function to calculate average grade
function calculateAverage(grades) {
    //TODO: Write your code here
    let total = 0;
    grades.forEach(function(grade){ total += grade})
    return total / grades.length;
}
// Display each student’s name, grades, and average grade
students.forEach(function(student) {
    //TODO: Write your code here
    console.log(`Name: ${student.name}\tAverage grade: ${calculateAverage(student.grades)}`);
});


