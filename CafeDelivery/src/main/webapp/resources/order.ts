import * as $ from "jquery";

class Food {
    name: string;
    price: number;
    description: string;
    picture: string;

    constructor(name: string, price: number, description: string, picture: string) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }
}

var burger = new Food('Cheeseburger', 6.99,
    "We support local farmers in order to get you the freshest beef you've ever tasted!",
    "https://www.tasteofhome.com/wp-content/uploads/2018/01/Scrum-Delicious-Burgers_EXPS_CHMZ19_824_B10_30_2b.jpg");
var pizza = new Food('16" Pizza', 10.99,
    "Locally grown ingredients chapped and baked before your eyes. Choose any 3 toppings!",
    "https://th.bing.com/th/id/OIP.W075yrkvuwRHC0Uz8d7RAwHaLH?pid=Api&rs=1");
var soda = new Food('Jones Soda', 1.49,
    "The unique taste of Jones, and the custom-printed bottles make this soda a perfect match with any meal!",
    "https://www.foodbusinessnews.net/ext/resources/FBN-Features/11/JonesSoda_Lead.jpg?1542041218");
var coffee = new Food('Coffee', 1.99,
    'Ground and brewed to order!  Our cream is made from fresh, local dairy.',
    "https://gazettereview.com/wp-content/uploads/2016/07/coffee-cup.jpeg");

var menu = [burger, pizza, soda, coffee];

$(document).ready(function () { populateMenu(); });

function populateMenu() {
    menu.forEach(element => {
        $("#menu-container").append(
            '<div class="card" onclick="addToOrder()">'+
                '<img src="'+element.picture+'"'+
                    'alt="" style="width:100%">'+
                '<div class="container">'+
                    '<h4><b>'+element.name+'</b></h4>'+
                    '<p>'+element.price+'</p>'+
                    '<p>'+element.description+'</p>'+
                '</div>'+
            '</div>'
        )
    })
}
