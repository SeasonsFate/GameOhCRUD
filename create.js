function goHome(){
    location.href = "GameOhCrud.html";
}


function handleSubmitChar(form) {
    let formDataObj = {}
    for (let element of form.elements) {
        
        element.id? formDataObj[element.id] = element.value:null;
    }
    formDataObj["alive"] == "Yes" ? formDataObj["alive"] = true : formDataObj["alive"] = false
    registerHero(formDataObj);
    
    return false;
}

function registerHero(formDataObj) {
    console.log(formDataObj);

    const req = new XMLHttpRequest();
    req.onload = () => {
        // location.href = "GameOhCrud.html";
    };
    req.open('POST', 'http://34.68.124.231:3306/gameohcrud/add');
    req.setRequestHeader('Content-Type', 'application/json');
    req.send(JSON.stringify(formDataObj));
}