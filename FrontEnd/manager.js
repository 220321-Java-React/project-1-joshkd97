const url = "http://localhost:3001"

var user = JSON.parse(sessionStorage.getItem("userStuff"));

console.log(user);


document.getElementById("reimbs-button").addEventListener("click", displayReimbs)
document.getElementById("reimbs-update").addEventListener("click",updateReimbs)
document.getElementById("logout").addEventListener("click",managerLogout)


async function displayReimbs(){

    clearTable()

    let response = await fetch(url+ "/displayReimbs")

    if(response.status == 200){

        let data = await response.json()
 

        for(let reimb of data){

            let row = document.createElement("tr")

            let cell1 = document.createElement("td")
            cell1.innerHTML = reimb.reimb_id
            row.appendChild(cell1)

            let cell2 = document.createElement("td")
            cell2.innerHTML = reimb.amount
            row.appendChild(cell2)

            let cell3 = document.createElement("td")
            cell3.innerHTML = reimb.time_submitted
            row.appendChild(cell3)

            let cell4 = document.createElement("td")
            cell4.innerHTML = reimb.time_resolved
            row.appendChild(cell4)

            let cell5 = document.createElement("td")
            cell5.innerHTML = reimb.description
            row.appendChild(cell5)

            let cell6 = document.createElement("td")
            cell6.innerHTML = reimb.author.user_id
            row.appendChild(cell6)

            let cell7 = document.createElement("td")
            cell7.innerHTML = reimb.resolver.user_id
            row.appendChild(cell7)

            let cell8 = document.createElement("td")
            cell8.innerHTML = reimb.status.reimb_status
            row.appendChild(cell8)

            let cell9 = document.createElement("td")
            cell9.innerHTML = reimb.type.reimb_type
            row.appendChild(cell9)

            document.getElementById("reimb-body").appendChild(row)

        }
    }else{
        alert("Uh oh request failed for some reason")
    }
}

function clearTable(){

    let table = document.getElementById("reimb-body")

    table.innerHTML=""
}

async function updateReimbs(){

    let r_id = document.getElementById("reimb-id").value
    let u_id = user.user_id
    let r_status = document.getElementById("status").value

    let updateInfo = {
        reimb_id: r_id,
        user_id: u_id,
        status: r_status
    }


    let response = await fetch(url+"/resolveReimb",{
        method: "POST",
        body: JSON.stringify(updateInfo),
        credentials: "include"

    })

    if(response.status == 200){

        let data = await response.json();
        document.getElementById("update-message").innerText = data;

    }else{

        document.getElementById("update-message").innerText = "There was an issue updating the reimbursement"
    }

}

function managerLogout(){
    
    sessionStorage.clear()
    location.href = "index.html"

}