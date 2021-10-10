const url = "http://localhost:8090/" 

//add eventhandler for login button
document.getElementById("loginButton").addEventListener("click", loginFunc);

async function loginFunc(){

    //gather the user input from the login inputs
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;

    //create object to model user
    let user = {
        username:usern,
        password:userp
    }

    //send object for validation
    let response = await fetch(url + "login", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), 
        credentials: "include"
    });

    console.log(response.status); 

    if(response.status === 200){
        //get valid user
        let results = await response.json();
    
        // use local storage to save user 
        localStorage.setItem("userId", results.user_id);
        let userId = localStorage.getItem("userId");
        localStorage.setItem("roleId", results.user_role.role_id);
        let roleId = localStorage.getItem("roleId");

        //open user page
        //may need to change url to include your own local port
        //window.open("http://127.0.0.1:5500/P1_Reimbursements.html"); 
        window.open("http://127.0.0.1:5501/P1_Reimbursements.html"); //needed to change 5500 to 5501 to load properly on my machine -Eric Shawn
    }
}