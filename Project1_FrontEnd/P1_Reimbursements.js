

document.getElementById("addReimButton").addEventListener("click", addReimFunc);
document.getElementById("approveButton").addEventListener("click", approveFunc);
document.getElementById("denyButton").addEventListener("click", denyFunc);
document.getElementById("sortReims").addEventListener("click", sortFunc);



//console.log(userId);
const userId = localStorage.getItem("userId");
const roleId = localStorage.getItem("roleId");

window.onload = async function loadReims() {
    console.log(localStorage.username);
    console.log(userId);
//async function loadReims() {
    //let response = await fetch(url + "reimbursement"); //, {credentials: "include"});
    if (roleId == 1){
        var response = await fetch(url + "reimbursement", {credentials: "include"});
    }else{
        var response = await fetch(url + "reimbursement/user/" + userId, {credentials: "include"});
    }
    //let response = await fetch(url + "reimbursement/user/" + userId, {credentials: "include"});
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
            cell5.innerHTML = reim.reim_author.lName; 
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


async function addReimFunc(){
    let amt = document.getElementById("amtId").value;
    let desc = document.getElementById("descId").value;
    let type = document.querySelector('input[name="selectRadio"]:checked').value;
    //let userId = localStorage.getItem("userId");

    let newReim = {
        amount:amt,
        description:desc,
        reim_type:type,
        user_id:userId
    }

    console.log(newReim);
    let response = await fetch(url + "reimbursement/add", { 
        method:"POST",
        body: JSON.stringify(newReim)
    });

    console.log(response.status);
}

async function approveFunc(){
    let reimId = document.getElementById("reimIdInput").value;
    let status = 2;

    let statusUpdate = {
        reim_id:reimId,
        status_id: status
    }

    console.log(statusUpdate);
    let response = await fetch(url + "reimbursement/update", { //need endpoint
        method:"PATCH",
        body: JSON.stringify(statusUpdate)
    });

    console.log(response.status);
}

async function denyFunc(){
    let reimId = document.getElementById("reimIdInput").value;
    let status = 3;

    let statusUpdate = {
        reim_id:reimId,
        status_id: status
    }

    console.log(statusUpdate);
    let response = await fetch(url + "reimbursement/update", { 
        method:"PATCH",
        body: JSON.stringify(statusUpdate)
    });

    console.log(response.status);
}

async function sortFunc(){
    let response = await fetch(url + "reimbursement/status/1", {credentials: "include"});
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
            cell5.innerHTML = reim.reim_author.lName; 
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
}