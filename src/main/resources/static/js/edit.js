let selects = document.querySelectorAll('.m-select')
let inputs = document.getElementsByTagName('input')
let submitButton = document.querySelector('#submit')
console.log(submitButton)
let submitAside=document.querySelector('.b-submit__aside')
submitButton.addEventListener('click', createOrUpdateProduct)
console.log(editCar)
// for (let i = 0; i < selects.length; i++) {
//     console.log(selects[i].value)
// }
for (let i = 0; i < inputs.length; i++) {

}

function createOrUpdateProduct() {


    let bodyType = {
        id: selects[0].value,
        bodyTypeName: selects[0].options[selects[0].selectedIndex].text
    }
    let markSeries = selects[3].options[selects[3].selectedIndex].text.split(" ")
    let carMark = {
        id: selects[3].value,
        mark: markSeries[0],
        series: markSeries[1]
    }
    let engineLayoutType = {
        id: selects[5].value,
        engineLayoutTypeName: selects[5].options[selects[5].selectedIndex].text
    }
    let engineType = {
        engineTypeName: selects[4].value,
        engineVolume: selects[6].value,
        enginePower: selects[7].value
    }
    let countryCity = selects[8].options[selects[8].selectedIndex].text.split(", ")
    let manufacture = {
        id: selects[8].value,
        country: countryCity[0],
        city: countryCity[1]
    }
    console.log(countryCity)
    let technicalDetails = {
        engineLayoutType: engineLayoutType,
        engineType: engineType,
        doorsNumber: selects[1].value,
        seatsNumber: selects[2].value,
        bodyType:bodyType
    }
    let product ={
            model: inputs[0].value,
            price: inputs[1].value,
            color: inputs[2].value,
            technicalDetails:technicalDetails,
            carMark:carMark,
            availability:selects[9].value,
            manufacture:manufacture
    }

    console.log(product)
    var settings
    if (!editCar) {
        settings = {
            "url": "http://localhost:8080/create",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify(product),
        };
    }else {
        settings = {
            "url": "http://localhost:8080/update/"+editCar.id,
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify(product),
        };
    }

    $.ajax(settings).done(function (response) {
        let createdCar=document.createElement('div')
        createdCar.classList.add('b-submit__aside-step','wow' ,'zoomInUp')
        createdCar.innerHTML="<h3>Recently updates</h3>\n" +
            "    <div class=\"b-submit__aside-step-inner m-active clearfix\">\n" +
            "        <div class=\"b-submit__aside-step-inner-icon\">\n" +
            "            <span class=\"fa fa-car\"></span>\n" +
            "        </div>\n" +
            "        <div class=\"b-submit__aside-step-inner-info\">\n" +
            "            <h4>"+response.carMark.mark+" "+response.carMark.series+"</h4>\n" +
            "            <p>"+response.model+", "+response.color+"</p>\n" +
            "            <div class=\"b-submit__aside-step-inner-info-triangle\"></div>\n" +
            "        </div>\n" +
            "    </div>"
        submitAside.appendChild(createdCar)
    });

}


