var onEdit = false;

function editON(){
    onEdit = !onEdit;
    if(onEdit){
        openEdit();
    } else {
        closeEdit();
    }
}

function openEdit(){
    edit = document.getElementsByClassName("edit");
    view = document.getElementsByClassName("view");
    for(let i = 0; i < edit.length; i++){
        edit[i].style.display = "table-row";
        view[i].style.display = "none";
    }
}

function closeEdit(){
    edit = document.getElementsByClassName("edit");
    view = document.getElementsByClassName("view");
    for(let i = 0; i < edit.length; i++){
        edit[i].style.display = "none";
        view[i].style.display = "table-row";
    }
}
