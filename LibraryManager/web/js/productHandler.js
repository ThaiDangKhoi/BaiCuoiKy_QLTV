imgProduct = document.getElementsByClassName("imgProduct");

function showInfo(bookId){
    onInfo("product"+bookId);
}

function onInfo(productId){
    document.getElementById(productId).style.display = "block";
}

function closeInfo(productId){
    document.getElementById(productId).style.display = "none";
}