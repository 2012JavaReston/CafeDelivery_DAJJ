var burger = {name:'Cheeseburger',price:6.99,description:"We support local farmers in order to get you the freshest beef you've ever tasted!",image:"https://www.tasteofhome.com/wp-content/uploads/2018/01/Scrum-Delicious-Burgers_EXPS_CHMZ19_824_B10_30_2b.jpg"};
var pizza = {name:'16 inch Pizza', price:10.99, description:"Locally grown ingredients chopped fresh daily. Choose any 3 toppings!", image:"https://th.bing.com/th/id/OIP.W075yrkvuwRHC0Uz8d7RAwHaLH?pid=Api&rs=1"};
var soda = {name:'Soda', price:1.49, description:"Jones' unique taste and custom bottles make this a perfect match with any meal!", image:"https://www.foodbusinessnews.net/ext/resources/FBN-Features/11/JonesSoda_Lead.jpg?1542041218"};
var coffee = {name:'Coffee', price:1.75, description:'Out dark roast coffee is ground and brewed to order!  Our cream is made from local dairy.', image:"https://gazettereview.com/wp-content/uploads/2016/07/coffee-cup.jpeg"};
var milk = {name:"Milk",price:1.99,description:'Ice cold whole milk fresh from local dairy farms to your doorstep!   #SupportLocal',image:'https://th.bing.com/th/id/OIP.qD0LdMR8kt15ZbwMW3RC_AHaFa?pid=Api&rs=1'};

console.log(burger)

var menu = [burger,pizza,soda,coffee,milk];

$(document).ready(function () { populateMenu(); populateOrderHistory(); });

function populateMenu() {
    console.log('Poplating menu!')
    menu.forEach(element => {
        $("#menu-container").append('<div class="card" onclick="addToOrder(' +"'"+ element.name +"'"+')">' +
            '<img src="' + element.image + '"' +
            'alt="" style="width:100%; height:200px;">' +
            '<div class="info">' +
            '<h4><b>' + element.name + '</b></h4>' +
            '<p>' + element.price + '</p>' +
            '<p>' + element.description + '</p>' +
            '</div>' +
            '</div>');
    });
};

var order = [];

function addToOrder(name) {

    let x = order.length;
    if (name == 'Cheeseburger') {
        order[x] = burger;
        showOrders();
    } else if (name == '16 inch Pizza') {
        order[x] = pizza;   
        showOrders()
    } else if (name == 'Soda') {
        order[x] = soda;
        showOrders();
    } else if (name == 'Coffee'){
        order[x] = coffee;
        showOrders();
    } else if (name == "Milk"){
        order[x] = milk;
        showOrders();
    }
    console.log(order);
}

function showOrders() {
    let total = 0;
    for (let i = 0; i<order.length; i++) {
        total += order[i].price;
    }
    document.getElementById("current-order").innerHTML=' ';
    for (let i = 0; i<order.length; i++)
    {
        $("#current-order").append(
            "<tr><td>" + 
            order[i].name +"</td><td>"+ 
            order[i].price +"</td><td>" +
            '<button class="button" onclick="removeFromCart('+i+')">Remove from Cart</button></td>'+
            //Remove from order button.
            "</tr>"); 
    }
    $("#current-order").append(
        '<tr><th>Total</th><td>' + total + '</td></tr>'
    );
}

function removeFromCart(int)
{
    order.splice(int,1);
    showOrders();
}

function completeOrder(){
    var http = new XMLHttpRequest()
    http.open("POST", "/CafeDelivery/api/order");
    http.send(JSON.stringify(order));
    http.onreadystatechange = e => {
        if(http.readyState == 4 && http.status == 200){
            alert('Order successfully sent!  Your food should be ready in a few minutes.')
            populateOrderHistory();
            order = [];
            showOrders();
        } else if(http.readyState == 4 && http.status == 500){
            error.innerText = "Order failed to send."
        }
    }
}

function populateOrderHistory(){
    console.log('Populating order history!')
    $.ajax({
        url: 'http://localhost:8080/CafeDelivery/api/order/history',
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(data){
            console.log(data);
            populateHistory(data);
        },
        error: function(error){
            alert('You must be logged in to populate this table.');
        }
    });
}

function populateHistory (data) {
    for (let i = 0; i < data.length; i++){
        $("#past-orders").append(
            "<tr><td>" + 
            data[i].id +"</td><td>"+ 
            data[i].totalPrice +"</td><td>"+
            data[i].foodOrdered +"</td></tr>"
        )
    }
}