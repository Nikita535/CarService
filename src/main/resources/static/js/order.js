let orderButton = document.querySelector('.m-btn')
let paymentType = document.querySelector('.m-select')
let delivery =document.querySelector('#check1')
console.log(orderButton)
console.log(paymentType)
console.log(delivery.checked)

orderButton.addEventListener('click',doOrder)

function doOrder()
{
    let payment={
        id: paymentType.value,
        paymentType: paymentType.options[paymentType.selectedIndex].text
    }
    let order ={
        client:user,
        product:car,
        paymentType:payment,
        delivery:delivery.checked
    }
    console.log(order)
    var settings = {
        "url": "http://localhost:8080/order",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify(order),
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        window.location='/order'
    });
}