userIcon = document.getElementById("userIcon");
userArea = document.getElementById("userArea");
userAreaOn = false;

userIcon.addEventListener("click", function(){
    userAreaOn = !userAreaOn;
    if(userAreaOn){
        userArea.style.display = "block";
    } else {
        userArea.style.display = "none";
    }
});
