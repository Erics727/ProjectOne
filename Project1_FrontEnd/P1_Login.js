const url = "http://localhost:8090/" //putting our base URL in a variable for cleaner code below
//eventually we'll use this in our fetch requests and make calls to the server by appending endpoints

//add functionality to our buttons using a eventlisteners
//so when these buttons gets clicked, the appropriate function will be called
document.getElementById("loginButton").addEventListener("click", loginFunc);


async function loginFunc(){

    //gather the user input from the login inputs
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;
    

    //document.getElementById("result").innerHTML = localStorage.lastname

    //console.log(localStorage.username)

    //we want to send the user/pass as JSON, so we need to make a JS object to send
    let user = {
        username:usern,
        password:userp
    }

    console.log(user)

    //Now I'm going to set up my fetch request to the server
    //Remember the second parameter fetch() can take?
    //It's essentially a configuration object! the settings of our fetch request
    //if you don't include it, it'll send a GET request by default
    let response = await fetch(url + "login", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), //turn our Javascript into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured
        //future fetches will also require this "include" value to send the cookie back
    });

    //console.log(response.text());
    let results = await response.json();
    console.log(results);
    console.log(results.user_role.role_id);

    console.log(response.status); //useful for debug :)

    //control flow based on successful login
    if(response.status === 200){
        //open user page
        //may need to change url to include your own ip address
        if(results.user_role.role_id == 1){//if user is a manager
            window.open("http://127.0.0.1:5500/P1_Reimbursements.html")//remember to set this to manager url later
        }
        else{//if user is not a manager
            window.open("http://127.0.0.1:5500/P1_Reimbursements.html")//set this to employee url 
        }

        
    }

}