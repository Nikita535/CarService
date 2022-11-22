function showAllProducts()
{
    var settings = {
        "url": "http://localhost:8080/products",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
        for (let i = 0; i < response.length; i++) {
            createProductLine(response[i])
        }
    });
}

function createProductLine(response)
{
    let mainContainer=document.querySelector('.b-items__cars')
    let car = document.createElement('div')
    car.classList.add('b-items__cars-one','wow','zoomInUp')
    car.innerHTML="<div class=\"b-items__cars-one-img\">\n" +
        "\t\t\t\t\t\t\t\t\t<img src=\"media/270x230/"+ Math.floor(Math.random() * 6+1)+".jpg\" alt=\"ferrari\"/>\n" +
        "\t\t\t\t\t\t\t\t\t<a data-toggle=\"modal\" data-target=\"#myModal\" href=\"#\" class=\"b-items__cars-one-img-video\"><span class=\"fa fa-film\"></span>VIDEO</a>\n" +
        "\t\t\t\t\t\t\t\t\t<form action=\"/\" method=\"post\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"check2\" id='check2'/>\n" +
        "\t\t\t\t\t\t\t\t\t\t<label for=\"check2\" class=\"b-items__cars-one-img-check\"><span class=\"fa fa-check\"></span></label>\n" +
        "\t\t\t\t\t\t\t\t\t</form>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t<div class=\"b-items__cars-one-info\">\n" +
        "\t\t\t\t\t\t\t\t\t<header class=\"b-items__cars-one-info-header s-lineDownLeft\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<h2>"+response.carMark.mark+" "+response.carMark.series+"</h2>\n" +
        "\t\t\t\t\t\t\t\t\t\t<span>$"+response.price+"</span>\n" +
        "\t\t\t\t\t\t\t\t\t</header>\n" +
        "\t\t\t\t\t\t\t\t\t<p>\n" +
        "\t\t\t\t\t\t\t\t\t\tAbove sports cars, there are exotic sports cars. And the LaFerrari is poised to be the king of all exotic sports cars. Its 789-hp V-12 gets a 161-hp boost from an electric motor\n" +
        "\t\t\t\t\t\t\t\t\t</p>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"b-items__cars-one-info-km\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<span class=\"fa fa-tachometer\"></span> 35,000 KM\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"b-items__cars-one-info-details\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"b-featured__item-links\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">"+response.technicalDetails.engineType.engineTypeName+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">"+response.color+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">"+response.model+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\">"+response.availability+"</a>\n" +
        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t\t<a href=\""+response.id+"\" class=\"btn m-btn\">VIEW DETAILS<span class=\"fa fa-angle-right\"></span></a>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>"
    mainContainer.appendChild(car)

}
showAllProducts()