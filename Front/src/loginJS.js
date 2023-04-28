function doPost(url, dto) {
    let request = new XMLHttpRequest();
    request.open("POST", url, true)
    request.setRequestHeader("content-type", "application/json")
    request.send(JSON.stringify(dto))

    request.onload = function() {
        console.log(this.responseText);
    }

    return request.responseText;
}

function registerUser() {
    event.preventDefault()

    let url = "http://localhost:8080/v1/users"
    let dto = getData()
    return doPost(url, dto)
}


function getData() {
    const name = document.getElementById("nameInput").value
    const login = document.getElementById("loginInput").value
    const password = document.getElementById("passwordInput").value

    let dto = { 
        "name" : name,
        "login" : login,
        "password" : password
    }

    return dto
}