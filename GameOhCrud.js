function goToCreate(){
    location.href = "create.html";
}
function goToUpdate(){
    location.href = "update.html";
}
function goToDelete(){
    location.href = "delete.html";
}

const table = document.getElementById("charTable");

function newTableEntries(table) {
    let row = document.createElement("tr");
    for (let i = 1; i < arguments.length; i++) {
        let box = document.createElement("td");
        box.innerHTML = arguments[i];
        row.append(box);
    }
    table.append(row)
}

function Load(){
const req = new XMLHttpRequest();
req.open('GET', 'http://34.68.124.231:3306/gameohcrud/values');
req.onload = () => {
    const data = JSON.parse(req.response);
    console.log(data)
for (let i = 0; i < data.length; i++) {
           let temp = data[i];
           newTableEntries(table, temp["id"], temp["characterName"], temp["house"], temp["actorName"],temp["alive"]);
    
    // document.getElementById("id").innerHTML = data[0].id;
    // document.getElementById("charName").innerHTML = data[0].character_name;
    // document.getElementById("houseName").innerHTML = data[0].house;
    // document.getElementById("actorName").innerHTML = data[0].actor_name;
    // document.getElementById("alive").innerHTML = data[0].Alive;

}
}
req.send();
}