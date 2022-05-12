const url = "http://localhost:3001"

var user = JSON.parse(sessionStorage.getItem("userStuff"));

console.log(user);

document.getElementById("submitReimb").addEventListener("click",submitReimb)
document.getElementById("show-reimbs").addEventListener("click", showReimbs)
document.getElementById("logout").addEventListener("click", employeeLogout)

async function submitReimb(){

    let userAmount = document.getElementById("amount").value 
    let userDescript = document.getElementById("description").value
    let reimbType = document.getElementById("type").value

    let holder = document.getElementById("img-holder")
    holder.innerHTML = ""
   

    let reimb = {
        amount: userAmount,
        user_id: user.user_id,
        descript: userDescript,
        type: reimbType

    }

    console.log(reimb)

    let response = await fetch(url+"/insertReimb",{

        method:"POST",
        body: JSON.stringify(reimb),
        credentials: "include"
    })

    if(response.status === 200){

        let data = await response.json();

        document.getElementById("server-response").innerText=data;

        
        var img = document.createElement("img")
        img.src = "business.png"
        holder.appendChild(img)

    }else{
        document.getElementById("server-response").innerText="Error submitting reimbursement";
    }

}

async function showReimbs(){

    clearTable()

    let info = {
        id: user.user_id

    }

  

    let response = await fetch(url+"/displayReimbsByUser",{

        method:"POST",
        body: JSON.stringify(info),
        credentials:"include"
    })

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

function employeeLogout(){
    
    sessionStorage.clear()
    location.href = "index.html"

}