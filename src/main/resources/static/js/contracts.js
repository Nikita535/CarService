let deleteButtons =document.querySelectorAll('.delete')
for (let i = 0; i <deleteButtons.length ; i++) {
    console.log(deleteButtons[i])
    deleteButtons[i].addEventListener('click',function ()
    {

        deleteContractById(deleteButtons[i],deleteButtons[i].id)
    })
}

function deleteContractById(deleteEl,id)
{
    var settings = {
        "url": "http://localhost:8080/order/"+id,
        "method": "DELETE",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },

    };
    console.log()
    deleteEl.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.removeChild(deleteEl.parentNode.parentNode.parentNode.parentNode.parentNode)

    $.ajax(settings).done(function (response) {
    });
}