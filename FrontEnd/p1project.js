const url = "http://localhost:3001";


var userInfo ={};

document.getElementById("employeeButton").addEventListener("click", employeeLogin);

document.getElementById("managerButton").addEventListener("click", managerLogin);

async function managerLogin(){

    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        user_name: usern,
        pass_word: userp
    }
    //sessionStorage.setItem("user", JSON.stringify(user));

   console.log(user);

    let response = await fetch(url+"/managerLogin",{

        method:"POST",  //sending a POST request
        body: JSON.stringify(user), //turning our user object into JSON to send to the server
        credentials: "include"
    })

    if(response.status === 202){

        let data = await response.json();
              
        userInfo = JSON.stringify(data);
        //console.log(userInfo);
        sessionStorage.setItem("userStuff",userInfo);
        location.href = "manager.html";
        


  
    }else{
        document.getElementById("welcomeHead").innerText="Login Failed please try again";
        document.getElementById("welcomeHead").style.color = "red";
    }

}


async function employeeLogin(){

    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        user_name: usern,
        pass_word: userp
    }
    //sessionStorage.setItem("user", JSON.stringify(user));

   console.log(user);

    let response = await fetch(url+"/employeeLogin",{

        method:"POST",  //sending a POST request
        body: JSON.stringify(user), //turning our user object into JSON to send to the server
        credentials: "include"
    })

    if(response.status === 202){

        let data = await response.json();
              
        userInfo = JSON.stringify(data);
        //console.log(userInfo);
        sessionStorage.setItem("userStuff",userInfo);
        location.href = "employee.html";
        


  
    }else{
        document.getElementById("welcomeHead").innerText="Login Failed please try again";
        document.getElementById("welcomeHead").style.color = "red";
    }
    
}