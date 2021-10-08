const url = "http://localhost:8090/"

//document.getElementById("getReims").addEventListener("click", loadReims); //if we need to load with button
//document.getElementById("addReimButton").addEventListener("click", addReim);

window.onload = async function loadReims() {

//async function loadReims() {
    //let response = await fetch(url + "reimbursement"); //, {credentials: "include"});
    let response = await fetch(url + "reimbursement", {credentials: "include"});
    console.log(response);
    //console.log(credentials);

    if(response.status === 200) {
        let data = await response.json();
   
        for(let reim of data){
            let row = document.createElement("tr"); 
            
            let cell = document.createElement("td"); 
            cell.innerHTML = reim.reim_id; 
            row.appendChild(cell); 

            let cell2 = document.createElement("td"); 
            cell2.innerHTML = reim.amount; 
            row.appendChild(cell2); 

            let cell3 = document.createElement("td"); 
            cell3.innerHTML = reim.created; 
            row.appendChild(cell3); 

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = reim.description; 
            row.appendChild(cell4); 

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = reim.reim_author.username; 
            console.log(reim.reim_author);
            row.appendChild(cell5); 

            let cell6 = document.createElement("td"); 
            cell6.innerHTML = reim.reim_status.status; 
            console.log(reim.reim_status);
            row.appendChild(cell6); 

            let cell7 = document.createElement("td"); 
            cell7.innerHTML = reim.reim_type.type; 
            console.log(reim.reim_type);
            row.appendChild(cell7); 

            document.getElementById("reimbursmentsData").appendChild(row);
        }
    }
} //end loadReims


//async function addReim(){

//}