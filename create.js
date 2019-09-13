function goHome(){
    location.href = "GameOhCrud.html";
}

const formDataObj = {};

function handleSubmitChar(form) {

    for (let element of form.elements) {
        formDataObj[element.id] = element.value;
    }
    console.log(formDataObj);
    registerHero();
    
    return false;
}

function registerHero() {
    console.log(formDataObj);

    const req = new XMLHttpRequest();
    req.onload = () => {
        location.href = "GameOhCrud.html";
    };
    req.open('POST', 'http://35.222.59.218:9000/hero');
    req.setRequestHeader('Content-Type', 'application/json');
    req.send(JSON.stringify(formDataObj));
}