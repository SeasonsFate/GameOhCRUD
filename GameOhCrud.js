function goToCreate(){
    location.href = "create.html";
}
function goToUpdate(){
    location.href = "update.html";
}
function goToDelete(){
    location.href = "delete.html";
}

  
const req = new XMLHttpRequest();
req.open('GET', 'http://35.242.168./:9000/gameohcrud');
req.onload = () => {
    const data = JSON.parse(req.response);
    console.log(data)
    document.getElementById("id").innerHTML = data[0].id;
    document.getElementById("charName").innerHTML = data[0].character_name;
    document.getElementById("houseName").innerHTML = data[0].house;
    document.getElementById("actorName").innerHTML = data[0].actor_name;
    document.getElementById("alive").innerHTML = data[0].Alive;

}
req.send();